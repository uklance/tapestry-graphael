package org.lazan.t5.graphael.services;

import org.apache.tapestry5.ioc.Configuration;
import org.apache.tapestry5.services.LibraryMapping;
import org.slf4j.Logger;

public class GraphaelModule {
	public static void contributeComponentClassResolver(Configuration<LibraryMapping> configuration, Logger log)
	{
		log.info("Registering graphael component library");
		configuration.add(new LibraryMapping("graphael", "org.lazan.t5.graphael"));
	}
}
