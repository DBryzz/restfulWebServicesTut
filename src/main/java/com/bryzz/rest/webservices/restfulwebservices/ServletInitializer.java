package com.bryzz.rest.webservices.restfulwebservices;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	/*
	 * @Override protected SpringApplicationBuilder
	 * configure(SpringApplicationBuilder builder) { // TODO Auto-generated method
	 * stub return super.configure(builder); }
	 * 
	 * protected SpringApplicationBuilder createSpringApplicationBuilder() { return
	 * new SpringApplicationBuilder(); }
	 */
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RestfulWebServicesApplication.class);
	}

}
