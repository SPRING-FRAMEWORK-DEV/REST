package com.spring.config;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@Configuration
//@Import(DispatcherConfig.class)
//@ImportResource({ "/WEB-INF/persistence-context.xml"})
public class AppConfig extends WebMvcConfigurerAdapter {

  public AppConfig() {
      super();
      // TODO Auto-generated constructor stub
      System.out.println("AppConfig");
  }

}
