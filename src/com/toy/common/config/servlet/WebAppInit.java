package com.toy.common.config.servlet;

import com.toy.common.config.context.AppConfig;
import com.toy.common.config.web.DispatchConfig;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;


public class WebAppInit extends AbstractDispatcherServletInitializer {

    private static final String DEFAULT_DISPATCHER_MAPPING_URI = "/";


    @Override
    protected WebApplicationContext createServletApplicationContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(DispatchConfig.class);
        return context;
    }


    @Override
    protected WebApplicationContext createRootApplicationContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(AppConfig.class);
        return context;
    }

    @Override
    protected FilterRegistration.Dynamic registerServletFilter(ServletContext servletContext, Filter filter) {
        FilterRegistration.Dynamic regist = super.registerServletFilter(servletContext, filter);

        if (filter instanceof CharacterEncodingFilter) {
            regist.addMappingForUrlPatterns(null, false, "/*");
        }

        return regist;
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter("utf-8");
        return new Filter[] { encodingFilter };
    }


    @Override
    protected String[] getServletMappings() {
        return new String[] { DEFAULT_DISPATCHER_MAPPING_URI };
    }

}
