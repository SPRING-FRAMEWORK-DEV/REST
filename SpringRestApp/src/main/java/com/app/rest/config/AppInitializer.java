package com.app.rest.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer 
//extends AbstractAnnotationConfigDispatcherServletInitializer
{

	public AppInitializer() {
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

	protected String[] getServletMappings() {
		return new String[] { "/rest/*" };
	}
}