package au.org.consumerdatastandards.holder.configuration;

import com.google.common.base.Strings;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReqParamNamesDiscoverer implements ParameterNameDiscoverer {

	@Nullable
	public String[] getParameterNames(Method method) {
		return doGetParameterNames(method);
	}

	@Override
	@Nullable
	public String[] getParameterNames(Constructor<?> constructor) {
		return doGetParameterNames(constructor);
	}

	private static String[] doGetParameterNames(Executable executable) {
		Parameter[] parameters = executable.getParameters();
		String[] parameterNames = new String[parameters.length];
		for (int i = 0; i < parameters.length; ++i) {
			Parameter param = parameters[i];
			String paramName = param.getName();
			if (param.isAnnotationPresent(RequestParam.class)) {
				RequestParam requestParamAnnotation = param.getAnnotation(RequestParam.class);
				if (!Strings.isNullOrEmpty(requestParamAnnotation.value())) {
					paramName = requestParamAnnotation.value();
				}
			}
			parameterNames[i] = paramName;
		}
		return parameterNames;
	}
}
