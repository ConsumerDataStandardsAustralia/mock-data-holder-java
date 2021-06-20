package au.org.consumerdatastandards.holder.configuration;

import org.springframework.core.KotlinReflectionParameterNameDiscoverer;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.PrioritizedParameterNameDiscoverer;
import org.springframework.core.StandardReflectionParameterNameDiscoverer;
import org.springframework.util.ClassUtils;

public class CustomParamNamesDiscoverer extends PrioritizedParameterNameDiscoverer {
	private static final boolean kotlinPresent = ClassUtils.isPresent("kotlin.Unit", CustomParamNamesDiscoverer.class.getClassLoader());

	public CustomParamNamesDiscoverer() {
		if (kotlinPresent) {
			this.addDiscoverer(new KotlinReflectionParameterNameDiscoverer());
		}

		this.addDiscoverer(new ReqParamNamesDiscoverer());
		this.addDiscoverer(new StandardReflectionParameterNameDiscoverer());
		this.addDiscoverer(new LocalVariableTableParameterNameDiscoverer());
	}
}
