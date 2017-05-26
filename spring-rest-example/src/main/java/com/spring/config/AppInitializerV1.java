package com.spring.config;

public class AppInitializerV1 {

	public AppInitializerV1() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("AppInitializer");
	}

	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { AppConfig.class,

				// SecurityConfig.class
		};
	}

	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { DispatcherConfig.class };
	}

	protected String[] getServletMappings1() {
		return new String[] { "/" };
	}
}