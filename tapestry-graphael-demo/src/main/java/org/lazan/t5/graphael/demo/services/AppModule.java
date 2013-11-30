package org.lazan.t5.graphael.demo.services;

import org.apache.tapestry5.ComponentParameterConstants;
import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.annotations.SubModule;
import org.lazan.t5.graphael.services.GraphaelModule;

@SubModule(GraphaelModule.class)
public class AppModule {
	public static void contributeApplicationDefaults(MappedConfiguration<String, String> configuration) {
		configuration.add(SymbolConstants.PRODUCTION_MODE, "false");
		configuration.add(ComponentParameterConstants.ZONE_UPDATE_METHOD, "show");
	}
}
