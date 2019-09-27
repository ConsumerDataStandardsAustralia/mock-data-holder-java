package au.org.consumerdatastandards.codegen.code.java;

import au.org.consumerdatastandards.codegen.code.CodeGeneratorConfig;
import au.org.consumerdatastandards.support.Extension;
import io.swagger.codegen.*;
import io.swagger.codegen.languages.AbstractJavaCodegen;
import io.swagger.models.*;
import io.swagger.models.parameters.BodyParameter;
import io.swagger.models.parameters.Parameter;
import io.swagger.models.parameters.SerializableParameter;
import io.swagger.models.properties.*;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public abstract class JavaCodegenBase extends AbstractJavaCodegen implements CodeGeneratorConfig {

    private Map<String, String> modelNameMap = new HashMap<String, String>() {
        {
            put("ResponseErrorList_errors", "Error");
        }
    };

    enum ResponseCode {
        OK("200"),
        CREATED("201"),
        ACCEPTED("202"),
        NO_CONTENT("204"),
        BAD_REQUEST("400"),
        UNAUTHORIZED("401"),
        FORBIDDEN("403"),
        UNPROCESSABLE_ENTITY("422"),
        TOO_MANY_REQUESTS("429");

        String code;

        ResponseCode(String code) {
            this.code = code;
        }

        static ResponseCode of(String code) {
            for (ResponseCode value : values()) {
                if (value.code.equals(code)) {
                    return value;
                }
            }
            return null;
        }
    }

    private Swagger swagger;
    private Map<String, String> refParameters = new HashMap<>();
    private Set<String> refModels = new HashSet<>();
    private Map<String, Set<String>> modelPackages = new HashMap<String, Set<String>>() {
        {
            put("ResponseErrorList", new HashSet<>(Collections.singletonList("common")));
            put("LinksPaginated", new HashSet<>(Collections.singletonList("common")));
            put("MetaPaginated", new HashSet<>(Collections.singletonList("common")));
        }
    };

    @Override
    public void addOperationToGroup(String tag, String resourcePath, Operation operation, CodegenOperation co,
                                    Map<String, List<CodegenOperation>> operations) {

        String groupTag = getGroupTag(co);
        List<CodegenOperation> group = operations.get(groupTag);
        if (!contains(group, co)) {
            super.addOperationToGroup(groupTag, resourcePath, operation, co, operations);
        }
    }

    private boolean contains(List<CodegenOperation> group, CodegenOperation co) {
        if (group == null || group.isEmpty()) return false;
        for (CodegenOperation o : group) {
            if (o.operationId.equals(co.operationId) && o.httpMethod.equals(co.httpMethod)) {
                return true;
            }
        }
        return false;
    }

    private String getGroupTag(CodegenOperation co) {
        String groupName = co.tags.get(0).getName();
        String subGroupName = co.tags.get(1).getName();
        String[] parts = groupName.split(" ");
        return parts[0] + sanitizeName(subGroupName).replace("_", "");
    }

    @Override
    public void preprocessSwagger(Swagger swagger) {
        super.preprocessSwagger(swagger);
        this.swagger = swagger;
        preprocessParameters(swagger);
        preprocessModels(swagger);
        preprocessPaths(swagger);
    }

    private void preprocessPaths(Swagger swagger) {
        for (Path path : swagger.getPaths().values()) {
            preprocessPath(path);
        }
    }

    private void preprocessPath(Path path) {
        for (Operation operation : path.getOperations()) {
            preprocessOperation(operation);
        }
    }

    private void preprocessOperation(Operation operation) {
        String packageName = getPackageName(operation.getTags());
        for (Parameter parameter : operation.getParameters()) {
            if (parameter instanceof SerializableParameter) {
                SerializableParameter sp = (SerializableParameter) parameter;
                if (sp.getEnum() != null) {
                    String referenceName = refParameters.get(sp.getName());
                    if (referenceName != null) {
                        ModelImpl enumModel = new ModelImpl().type(StringProperty.TYPE)._enum(sp.getEnum());
                        enumModel.setDescription(sp.getDescription());
                        swagger.getDefinitions().put(referenceName, enumModel);
                        addPackageForModel(packageName, referenceName);
                    }
                }
            }
            if (parameter instanceof BodyParameter) {
                Model schema = ((BodyParameter) parameter).getSchema();
                processModel(packageName, schema);
            }
        }
        for (Response response : operation.getResponses().values()) {
            Model schema = response.getResponseSchema();
            processModel(packageName, schema);
        }
    }

    private void processModel(String packageName, Model schema) {
        String modelName = null;
        if (schema instanceof ModelImpl) {
            modelName = ((ModelImpl) schema).getName();
        } else if (schema instanceof RefModel) {
            modelName = ((RefModel) schema).getSimpleRef();
        }
        processModel(packageName, modelName, schema);
    }

    private void processModel(String packageName, String modelName, Model schema) {
        addPackageForModel(packageName, modelName);
        if (schema instanceof RefModel) {
            refModels.add(modelName);
            Model model = swagger.getDefinitions().get(modelName);
            processModel(packageName, modelName, model);
        } else if (schema instanceof ComposedModel) {
            ComposedModel cm = (ComposedModel) schema;
            if (cm.getParent() != null) {
                preprocessModel(packageName, modelName, cm.getParent());
            }
            Model child = cm.getChild();
            preprocessModel(packageName, modelName, child);
            if (cm.getInterfaces() != null && !cm.getInterfaces().isEmpty()) {
                for (Model model : cm.getInterfaces()) {
                    preprocessModel(packageName, modelName, model);
                }
            }
        }
        if (schema.getProperties() != null) {
            for (Map.Entry<String, Property> entry : schema.getProperties().entrySet()) {
                processProperty(modelName, entry.getValue(), entry.getKey());
            }
        }
    }

    private void preprocessModel(String packageName, String modelName, Model model) {
        if (model != null) {
            if (model instanceof ModelImpl) {
                processModel(packageName, modelName, model);
            } else if (model instanceof RefModel) {
                processModel(packageName, ((RefModel) model).getSimpleRef(), model);
            }
        }
    }

    private void processProperty(String modelName, Property property, String propertyName) {
        if (property instanceof RefProperty) {
            String ref = ((RefProperty) property).getSimpleRef();
            refModels.add(ref);
            Set<String> packageNames = modelPackages.get(modelName);
            if (packageNames != null) {
                packageNames.forEach(p -> processModel(p, ref, swagger.getDefinitions().get(ref)));
            }
        } else if (property instanceof ObjectProperty) {
            String ref = toModelName(modelName + "_" + propertyName);
            Set<String> packageNames = modelPackages.get(modelName);
            addPackagesToModel(packageNames, ref);
            ObjectProperty op = (ObjectProperty) property;
            if (op.getProperties() != null) {
                for (Map.Entry<String, Property> entry : op.getProperties().entrySet()) {
                    processProperty(ref, entry.getValue(), entry.getKey());
                }
            }
        } else if (property instanceof ArrayProperty) {
            ArrayProperty ap = (ArrayProperty) property;
            processProperty(modelName, ap.getItems(), propertyName);
        }
    }

    private void addPackageForModel(String packageName, String modelName) {
        if (!StringUtils.isBlank(modelName)) {
            modelPackages.computeIfAbsent(modelName, k -> new HashSet<>());
            modelPackages.get(modelName).add(packageName);
        }
    }

    private void addPackagesToModel(Set<String> packageNames, String modelName) {
        modelPackages.computeIfAbsent(modelName, k -> new HashSet<>());
        if (packageNames != null) {
            packageNames.forEach(p -> addPackageForModel(p, modelName));
        }
    }

    private String getPackageName(List<String> operationTags) {
        return operationTags.get(0).split(" ")[0].toLowerCase();
    }

    private void preprocessModels(Swagger swagger) {
        for (Model model : swagger.getDefinitions().values()) {
            if (model instanceof ComposedModel) {
                ComposedModel composedModel = (ComposedModel) model;
                preprocessComposedModel(composedModel);
            }
            preprocessProperties(model);
        }
    }

    private void preprocessComposedModel(ComposedModel composedModel) {
        for (RefModel refModel : composedModel.getInterfaces()) {
            refModels.add(refModel.getSimpleRef());
        }
        Model parent = composedModel.getParent();
        if (parent instanceof RefModel) {
            refModels.add(((RefModel) parent).getSimpleRef());
        }
        Model child = composedModel.getChild();
        if (child instanceof RefModel) {
            refModels.add(((RefModel) child).getSimpleRef());
        }
    }

    private void preprocessProperties(Model model) {
        if (model.getProperties() != null) {
            for (Map.Entry<String, Property> entry : model.getProperties().entrySet()) {
                if (entry.getValue() instanceof RefProperty) {
                    refModels.add(((RefProperty) entry.getValue()).getSimpleRef());
                } else if (entry.getValue() instanceof ArrayProperty) {
                    ArrayProperty ap = (ArrayProperty) entry.getValue();
                    if (ap.getItems() instanceof RefProperty) {
                        refModels.add(((RefProperty) ap.getItems()).getSimpleRef());
                    }
                }
            }
        }
    }

    private void preprocessParameters(Swagger swagger) {
        for (Map.Entry<String, Parameter> entry : swagger.getParameters().entrySet()) {
            Parameter parameter = entry.getValue();
            String paramName = entry.getKey();
            refParameters.put(parameter.getName(), paramName);
            refModels.add(paramName);
        }
    }

    @Override
    public String toApiName(String name) {
        return name + "API";
    }

    @Override
    public String toModelName(String name) {
        String mappedName = modelNameMap.get(name);
        if (mappedName != null) {
            return super.toModelName(mappedName);
        }
        return super.toModelName(name);
    }

    @Override
    public void postProcessModelProperty(CodegenModel model, CodegenProperty property) {
        CdsCodegenProperty cdsCodegenProperty = new CdsCodegenProperty(property);
        if (property.items != null) {
            cdsCodegenProperty.items = new CdsCodegenProperty(property.items);
        }
        replaceProperty(model, cdsCodegenProperty);
        List<String> inheritedProperties = Arrays.asList("Links", "MetaPaginated", "LinksPaginated");
        if (inheritedProperties.contains(cdsCodegenProperty.datatype)) {
            cdsCodegenProperty.isInherited = true;
        } else if (cdsCodegenProperty.datatype.equals("Meta")) {
            if (hasLinksProperty(model)) cdsCodegenProperty.isInherited = true;
        }
        if (!cdsCodegenProperty.defaultValue.equals("null") &&
            !StringUtils.isBlank(cdsCodegenProperty.defaultValue) &&
            !cdsCodegenProperty.defaultValue.startsWith("new ")) {
            cdsCodegenProperty.isDefaultValueVisible = true;
        }
        if (model.interfaces != null && !model.interfaces.isEmpty()) {
            cdsCodegenProperty.isInherited = propertyExists(cdsCodegenProperty, model.interfaces);
            if (cdsCodegenProperty.isEnum) {
                findEnumType(cdsCodegenProperty, model.interfaces);
            } else if (cdsCodegenProperty.items != null && cdsCodegenProperty.items.isEnum) {
                findEnumType(cdsCodegenProperty.items, model.interfaces);
            }
        }
    }

    private boolean propertyExists(CodegenProperty property, List<String> interfaces) {
        for (String modelKey : interfaces) {
            Model model = swagger.getDefinitions().get(modelKey);
            if (model != null) {
                for (String propertyName : model.getProperties().keySet()) {
                    if (property.baseName.equals(propertyName)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean hasLinksProperty(CodegenModel model) {
        for (CodegenProperty cp : model.vars) {
            if (cp.datatype.equals("Links")) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    private void findEnumType(CodegenProperty cp, List<String> interfaces) {
        for (String modelKey : interfaces) {
            Model model = swagger.getDefinitions().get(modelKey);
            if (model != null) {
                List<String> values = (List<String>) cp.allowableValues.get("values");
                String enumType = findEnumType(cp.datatypeWithEnum, values, modelKey, model);
                if (enumType != null) {
                    cp.datatype = enumType;
                    cp.datatypeWithEnum = enumType;
                    ((CdsCodegenProperty) cp).isEnumTypeExternal = true;
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    private boolean isEnumTypeInternal(CodegenProperty cp, CodegenModel cm) {
        if (cm.interfaces != null && !cm.interfaces.isEmpty()) {
            for (String modelKey : cm.interfaces) {
                Model model = swagger.getDefinitions().get(modelKey);
                if (model != null) {
                    List<String> values = (List<String>) cp.allowableValues.get("values");
                    String enumType = findEnumType(cp.datatypeWithEnum, values, modelKey, model);
                    if (enumType != null) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private String findEnumType(String datatypeWithEnum, List<String> values, String modelKey, Model model) {
        for (Map.Entry<String, Property> entry : model.getProperties().entrySet()) {
            if (entry.getValue() instanceof StringProperty) {
                StringProperty sp = (StringProperty) entry.getValue();
                if (sp.getEnum() != null && isTheSame(values, sp.getEnum())) {
                    return modelKey + "." + datatypeWithEnum;
                }
            }
        }
        return null;
    }

    private boolean isTheSame(List<String> values1, List<String> values2) {
        if (values1.size() != values2.size()) {
            return false;
        }
        List<String> copy1 = new ArrayList<>(values1);
        Collections.sort(copy1);
        List<String> copy2 = new ArrayList<>(values2);
        Collections.sort(copy2);
        for (int i = 0; i < copy1.size(); i++) {
            if (!copy1.get(i).equals(copy2.get(i))) return false;
        }
        return true;
    }

    private void replaceProperty(CodegenModel model, CodegenProperty property) {
        replaceProperty(model.vars, property);
        replaceProperty(model.requiredVars, property);
        replaceProperty(model.optionalVars, property);
    }

    private void replaceProperty(List<CodegenProperty> properties, CodegenProperty property) {
        for (int i = 0; i < properties.size(); i++) {
            if (properties.get(i).baseName.equals(property.baseName)) {
                properties.set(i, property);
            }
        }
    }

    @Override
    public CodegenModel fromModel(String name, Model model, Map<String, Model> allDefinitions) {
        CdsCodegenModel codegenModel = new CdsCodegenModel(super.fromModel(name, model, allDefinitions));
        String subPackage = getSubPackage(name);
        if (model.getProperties() != null) {
            Property property = model.getProperties().get("links");
            if (property != null) {
                RefProperty refProperty = (RefProperty) property;
                if (refProperty.getSimpleRef().equals("Links")) {
                    codegenModel.isBaseResponse = true;
                    codegenModel.importingBaseResponse = !"common".equals(subPackage);
                } else if (refProperty.getSimpleRef().equals("LinksPaginated")) {
                    codegenModel.isPaginatedResponse = true;
                    codegenModel.importingPaginatedResponse = !"common".equals(subPackage);
                }
            }
        }
        if (model instanceof ComposedModel) {
            Model child = ((ComposedModel) model).getChild();
            codegenModel.vendorExtensions.putAll(child.getVendorExtensions());
        }
        for (CodegenProperty cp : codegenModel.vars) {
            if (cp.isEnum && isEnumTypeInternal(cp, codegenModel)) {
                codegenModel._enums.add(cp);
            } else if (cp.items != null && cp.items.isEnum && isEnumTypeInternal(cp.items, codegenModel)) {
                codegenModel._enums.add(cp.items);
            }
        }
        codegenModel.imports.remove("ApiModel");
        return codegenModel;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Map<String, Object> postProcessOperations(Map<String, Object> objs) {
        super.postProcessOperations(objs);
        Map<String, Object> obj = (Map<String, Object>) objs.get("operations");
        List<CodegenOperation> operations = (List<CodegenOperation>) obj.get("operation");
        List<CdsCodegenOperation> cdsCodegenOperations = operations.stream().map(CdsCodegenOperation::new).collect(Collectors.toList());
        obj.put("operation", cdsCodegenOperations);
        Set<String> addedImports = new HashSet<>();
        Set<String> addedEnums = new HashSet<>();
        List imports  = (List)objs.get("imports");
        List<Object> _enums = new ArrayList<>();
        for (CdsCodegenOperation co : cdsCodegenOperations) {
            for (CodegenParameter cp : co.allParams) {
                CdsCodegenParameter ccp = (CdsCodegenParameter) cp;
                if (ccp.isEnum) {
                    if (ccp.isReference) {
                        if (!addedImports.contains(ccp.referenceName)) {
                            imports.add(new HashMap<String, String>() {{
                                put("import", modelPackage + "." + ccp.referenceName);
                            }});
                            addedImports.add(ccp.referenceName);
                        }
                    } else if (!addedEnums.contains(ccp.datatypeWithEnum)) {
                        if (!ccp.datatypeWithEnum.startsWith("Param")) {
                            ccp.datatypeWithEnum = String.format("Param%s", ccp.datatypeWithEnum);
                        }
                        _enums.add(ccp);
                        addedEnums.add(ccp.datatypeWithEnum);
                    }
                }
            }
            for (CodegenResponse cr : co.responses) {
                ResponseCode responseCode = ResponseCode.of(cr.code);
                cr.code = "ResponseCode." + (responseCode == null ? cr.code : responseCode);
            }
        }
        String currentPackage = apiPackage + "." + operations.get(0).tags.get(0).getName().split(" ")[0].toLowerCase();
        objs.put("cdsApiPackage", currentPackage);
        objs.put("_enums", _enums);
        postProcessImports(objs);
        List<String> tagNames = operations.get(0).tags.stream().map(Tag::getName).collect(Collectors.toList());
        objs.put("tags", tagNames);
        objs.put("section", getGroupTag(operations.get(0)));
        objs.put("openBracket", "{");
        objs.put("closeBracket", "}");
        return objs;
    }

    @SuppressWarnings("unchecked")
    private void postProcessImports(Map<String, Object> objs) {
        String currentPackage = null;
        CdsCodegenModel model = null;
        List<Object> models = (List<Object>)objs.get("models");
        if (models != null) {
            Map<String, Object> map = (Map<String, Object>)models.get(0);
            model = (CdsCodegenModel) map.get("model");
            currentPackage = getSubPackage(model.classname);
        }
        List<Object> imports = (List) objs.get("imports");
        Iterator<Object> iterator = imports.iterator();
        while (iterator.hasNext()) {
            Map<String, String> importMap = (Map<String, String>) iterator.next();
            Iterator<Map.Entry<String, String>> iter = importMap.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<String, String> i = iter.next();
                String originalImport = i.getValue();
                String[] packages = originalImport.split("\\.");
                String importedModel = packages[packages.length - 1];
                if(Objects.equals(currentPackage, getSubPackage(importedModel))) {
                    iter.remove();
                } else if (model != null && model.isBaseResponse && (importedModel.equals("Links") || importedModel.equals("Meta"))) {
                    iter.remove();
                } else if (model != null && model.isPaginatedResponse && (importedModel.equals("LinksPaginated") || importedModel.equals("MetaPaginated"))) {
                    iter.remove();
                } else {
                    importMap.put(i.getKey(), transformImport(originalImport));
                }
            }
            if (importMap.isEmpty()) {
                iterator.remove();
            }
        }
    }


    @Override
    public Map<String, Object> postProcessModels(Map<String, Object> objs) {
        super.postProcessModels(objs);
        postProcessImports(objs);
        objs.put("openBracket", "{");
        objs.put("closeBracket", "}");
        return objs;
    }

    @Override
    public String toEnumName(CodegenProperty property) {
        return sanitizeName(camelize(property.name));
    }

    private String buildCdsTypeAnnotation(String cdsType) {
        return "@CDSDataType(CustomDataType." + cdsType.replace("String", "") + ")";
    }

    public class CdsCodegenOperation extends CodegenOperation {

        CdsCodegenOperation(CodegenOperation co) {

            // Copy relevant fields of CodegenOperation
            this.responseHeaders.addAll(co.responseHeaders);
            this.hasAuthMethods = co.hasAuthMethods;
            this.hasConsumes = co.hasConsumes;
            this.hasProduces = co.hasProduces;
            this.hasParams = co.hasParams;
            this.returnTypeIsPrimitive = co.returnTypeIsPrimitive;
            this.returnSimpleType = co.returnSimpleType;
            this.isMapContainer = co.isMapContainer;
            this.isListContainer = co.isListContainer;
            this.hasMore = co.hasMore;
            this.hasReference = co.hasReference;
            this.path = co.path;
            this.operationId = co.operationId;
            this.notes = co.notes;
            this.returnType = co.returnType;
            this.httpMethod = co.httpMethod;
            this.returnBaseType = co.returnBaseType;
            this.summary = co.summary;
            this.baseName = co.baseName;
            this.defaultResponse = co.defaultResponse;
            this.discriminator = co.discriminator;
            this.allParams = co.allParams.stream().map(CdsCodegenParameter::new).collect(Collectors.toList());
            this.vendorExtensions = co.vendorExtensions;
            this.authMethods = co.authMethods;
            this.tags = co.tags;
            this.responses = co.responses;
            this.imports = co.imports;
            this.examples = co.examples;
            this.externalDocs = co.externalDocs;

            // set cds specific properties
            this.vendorExtensions.remove("x-accepts");
            this.vendorExtensions.remove("x-contentType");
            Iterator<Map.Entry<String, Object>> iterator = this.vendorExtensions.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Object> next = iterator.next();
                Object value = next.getValue();
                if (value instanceof List && ((List) value).isEmpty()) {
                    iterator.remove();
                }
            }
        }

        @SuppressWarnings("unused")
        public Set<Map.Entry<String, Object>> getCdsExtensionSet() {
            return vendorExtensions.entrySet();
        }
    }

    private class CdsCodegenParameter extends CodegenParameter {
        public String cdsTypeAnnotation;
        public boolean isCdsType;
        public boolean isReference;
        public String referenceName;

        CdsCodegenParameter(CodegenParameter cp) {

            // copy relevant fields of CodegenParameter
            this.baseName = cp.baseName;
            this.description = cp.description;
            this.isHeaderParam = cp.isHeaderParam;
            this.isBodyParam = cp.isBodyParam;
            this.isPathParam = cp.isPathParam;
            this.isCookieParam = cp.isCookieParam;
            this.isFormParam = cp.isFormParam;
            this.isQueryParam = cp.isQueryParam;
            this.required = cp.required;
            this.defaultValue = cp.defaultValue;
            this.isEnum = cp.isEnum;
            this.datatypeWithEnum = cp.datatypeWithEnum;
            this.allowableValues = cp.allowableValues;
            this.dataType = cp.dataType;
            this.paramName = cp.paramName;
            this.hasMore = cp.hasMore;
            this.items = cp.items;

            // set cds specific properties
            this.isReference = refParameters.containsKey(this.baseName);
            this.referenceName = refParameters.get(this.baseName);
            if (!StringUtils.isBlank(referenceName)) {
                this.datatypeWithEnum = referenceName;
            }
            if (cp.vendorExtensions != null) {
                String cdsType = (String) cp.vendorExtensions.get(Extension.CDS_TYPE.getKey());
                if (!StringUtils.isBlank(cdsType)) {
                    this.cdsTypeAnnotation = buildCdsTypeAnnotation(cdsType);
                    this.isCdsType = true;
                }
            }
        }
    }

    private String getSubPackage(String modelName) {
        Set<String> packages = modelPackages.get(toModelName(modelName));
        if (packages != null && !packages.isEmpty()) {
            if (packages.size() == 1) {
                return packages.iterator().next();
            } else {
                return "common";
            }
        }
        return null;
    }

    public class CdsCodegenModel extends CodegenModel {

        public boolean isSimple;
        public boolean isReferenced;
        public boolean importingBaseResponse;
        public boolean importingPaginatedResponse;
        public boolean isBaseResponse;
        public boolean isPaginatedResponse;
        public List<CodegenProperty> _enums = new ArrayList<>();
        public String subPackage;

        CdsCodegenModel(CodegenModel cm) {

            // Copy relevant fields of CodegenModel
            this.name = cm.name;
            this.classname = cm.classname;
            this.interfaces = cm.interfaces;
            this.description = cm.description;
            this.classVarName = cm.classVarName;
            this.dataType = cm.dataType;
            this.classFilename = cm.classFilename;
            this.unescapedDescription = cm.unescapedDescription;
            this.defaultValue = cm.defaultValue;
            this.arrayModelType = cm.arrayModelType;
            this.vars = cm.vars;
            this.requiredVars = cm.requiredVars;
            this.optionalVars = cm.optionalVars;
            this.allowableValues = cm.allowableValues;
            this.mandatory = cm.mandatory;
            this.allMandatory = cm.allMandatory;
            this.hasEnums = cm.hasEnums;
            this.isEnum = cm.isEnum;
            this.isArrayModel = cm.isArrayModel;
            this.hasChildren = cm.hasChildren;
            this.externalDocs = cm.externalDocs;
            this.imports = cm.imports;
            this.vendorExtensions = cm.vendorExtensions;

            // set cds specific properties
            this.isReferenced = refModels.contains(this.classname);
            this.isSimple = (this.interfaces == null || this.interfaces.isEmpty())
                && StringUtils.isBlank(this.description) && this.isReferenced;
            this.subPackage = getSubPackage(this.name);
        }

        @SuppressWarnings("unused")
        public Set<Map.Entry<String, Object>> getCdsExtensionSet() {
            return vendorExtensions.entrySet();
        }

        public String getModelFileFolder() {
            return outputFolder + "/" + sourceFolder + "/" + getModelPackage().replace('.', '/');
        }

        public String getModelPackage() {
            return modelPackage.replace("models", subPackage + ".models");
        }

        @SuppressWarnings("unused")
        public boolean hasDescriptionOrNotReferenced() {
            return !StringUtils.isBlank(description) || !isReferenced;
        }
    }

    private String transformImport(String originalImport) {
        if(originalImport.startsWith(modelPackage)) {
            String modelName = originalImport.substring(modelPackage.length());
            String subPackage = getSubPackage(modelName);
            if (!StringUtils.isBlank(subPackage)) {
                return originalImport.replace("models", subPackage + ".models");
            }
        }
        return originalImport;
    }

    private class CdsCodegenProperty extends CodegenProperty {
        public String cdsTypeAnnotation;
        public boolean isCdsType;
        public boolean isDefaultValueVisible;
        public boolean isEnumTypeExternal;
        public boolean isSimple;

        CdsCodegenProperty(CodegenProperty cp) {

            // copy relevant fields of CodegenProperty
            this.description = cp.description;
            this.datatype = cp.datatype;
            this.datatypeWithEnum = cp.datatypeWithEnum;
            this.isContainer = cp.isContainer;
            this.required = cp.required;
            this.baseName = cp.baseName;
            this.defaultValue = cp.defaultValue;
            this.isEnum = cp.isEnum;
            this.enumName = cp.enumName;
            this.items = cp.items;
            this.allowableValues = cp.allowableValues;
            this.vendorExtensions = cp.vendorExtensions;

            // set cds specific properties
            if (cp.vendorExtensions != null) {
                String cdsType = (String) cp.vendorExtensions.get(Extension.CDS_TYPE.getKey());
                if (!StringUtils.isBlank(cdsType)) {
                    this.cdsTypeAnnotation = buildCdsTypeAnnotation(cdsType);
                    this.isCdsType = true;
                }
            }
            this.isSimple = (StringUtils.isBlank(description) && !required);
        }
    }

}
