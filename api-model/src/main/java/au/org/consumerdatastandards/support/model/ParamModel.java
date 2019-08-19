package au.org.consumerdatastandards.support.model;

import au.org.consumerdatastandards.support.Param;
import au.org.consumerdatastandards.support.data.CDSDataType;
import au.org.consumerdatastandards.support.data.IntegerRange;
import au.org.consumerdatastandards.support.data.Pattern;
import au.org.consumerdatastandards.support.data.StringFormat;

import java.lang.reflect.Parameter;

public class ParamModel extends ModelBase implements Comparable<ParamModel> {

    private Param param;

    private String name;

    private Class<?> paramDataType;

    private CDSDataType cdsDataType;

    private StringFormat stringFormat;

    private Pattern pattern;

    private IntegerRange integerRange;
    
    public ParamModel(Parameter parameter) {
        this.param = parameter.getAnnotation(Param.class);
        this.name = this.param.name();
        this.paramDataType = parameter.getType();
        this.cdsDataType = parameter.getAnnotation(CDSDataType.class);
        this.stringFormat = parameter.getAnnotation(StringFormat.class);
        this.pattern = parameter.getAnnotation(Pattern.class);
        this.integerRange = parameter.getAnnotation(IntegerRange.class);
    }

    public StringFormat getStringFormat() {
        return stringFormat;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public IntegerRange getIntegerRange() {
        return integerRange;
    }

    public Param getParam() {
        return param;
    }

    public Class<?> getParamDataType() {
        return paramDataType;
    }

    public CDSDataType getCDSDataType() {
        return cdsDataType;
    }

    @Override
    public int compareTo(ParamModel paramModel) {

        return name.compareTo(paramModel.name);
    }
    
    public String getName() {
        return name;
    }
}
