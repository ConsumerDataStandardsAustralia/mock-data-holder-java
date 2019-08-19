package au.org.consumerdatastandards.support.model;

import au.org.consumerdatastandards.support.Endpoint;
import au.org.consumerdatastandards.support.Param;
import au.org.consumerdatastandards.support.Section;
import au.org.consumerdatastandards.support.util.CustomAttributesUtil;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Set;

public class ModelBuilder {

    public final static String BASE_PACKAGE = "au.org.consumerdatastandards.api";

    private ModelBuilderOptions options;

    public ModelBuilder() {
    }

    public ModelBuilder(ModelBuilderOptions options) {
        this.options = options;
    }

    public APIModel build() {
        APIModel apiModel = new APIModel();
        Reflections reflections = new Reflections(BASE_PACKAGE);
        Set<Class<?>> sectionClasses = reflections.getTypesAnnotatedWith(Section.class);
        for (Class<?> sectionClass : sectionClasses) {
            Section section = sectionClass.getAnnotation(Section.class);
            if (options == null || options.isSectionIncluded(section.name())) {
                apiModel.add(buildSectionModel(section, sectionClass));
            }
        }
        return apiModel;
    }

    private SectionModel buildSectionModel(Section section, Class<?> sectionClass) {
        SectionModel sectionModel = new SectionModel(section);
        CustomAttributesUtil.addCustomAttributes(sectionClass, sectionModel);
        for (Method method : MethodUtils.getMethodsListWithAnnotation(sectionClass, Endpoint.class, true, true)) {
            EndpointModel endpointModel = buildEndpointModel(method);
            sectionModel.add(endpointModel);
        }
        return sectionModel;
    }

    private EndpointModel buildEndpointModel(Method method) {        
        Endpoint endpoint = method.getAnnotation(Endpoint.class);
        EndpointModel endpointModel = new EndpointModel(endpoint);
        CustomAttributesUtil.addCustomAttributes(method, endpointModel);
        Parameter[] parameters = method.getParameters();
        for (Parameter parameter : parameters) {
            if (parameter.isAnnotationPresent(Param.class)) {
                ParamModel paramModel = new ParamModel(parameter);
                CustomAttributesUtil.addCustomAttributes(parameter, paramModel);
                endpointModel.addParamModel(paramModel);
            }
        }
        return endpointModel;
    }
}


