package org.vsfamily.vslib.web;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.security.config.BeanIds;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * VSLib web application initializer class.
 */
public class VslibWebApplicationInitializer implements WebApplicationInitializer {

	private static final String DISPATCHER_SERVLET_NAME = "dispatcher";
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.setConfigLocation("org.vsfamily.vslib.config");
		
        servletContext.addListener(new ContextLoaderListener((WebApplicationContext)context));
        servletContext.addListener(new RequestContextListener());
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(DISPATCHER_SERVLET_NAME, new DispatcherServlet((WebApplicationContext)context));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
		registerSpringSecurityFilterChain(servletContext);
	}
	
	/**
	 * Implements spring security filter chain.
	 * @param servletContext - the servlet context
	 */
	private void registerSpringSecurityFilterChain(ServletContext servletContext) {
		FilterRegistration.Dynamic springSecurityFilterChain = servletContext.addFilter(
				BeanIds.SPRING_SECURITY_FILTER_CHAIN, new DelegatingFilterProxy());
		springSecurityFilterChain.addMappingForUrlPatterns(null, false, "/*");
	}
}
