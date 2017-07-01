package com.pawan.config.web;

import static com.pawan.utility.constants.AppConstants.CONFIG_LOCATION;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class WebConfigurer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.setConfigLocation(CONFIG_LOCATION);

		servletContext.addListener(new ContextLoaderListener(appContext));
		ServletRegistration.Dynamic dispatcherServlet = servletContext.addServlet("dispatcherServlet",
				new DispatcherServlet(appContext));

		dispatcherServlet.setLoadOnStartup(1);
		dispatcherServlet.addMapping("/*");
		

	}

}
