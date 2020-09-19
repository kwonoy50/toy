package com.toy.common.config.web;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.Ordered;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Configuration
@EnableWebMvc
@ComponentScan(
        useDefaultFilters = false,
        basePackages   = "com.toy",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ASPECTJ, pattern = "*..config.web.*"),
                @ComponentScan.Filter(Controller.class),
        })
public class DispatchConfig implements WebMvcConfigurer {

    private static final String DEFAULT_RESOURCES_URI = "/resources";
    private static final String DEFAULT_VIEW_URI_PREFIX = "/WEB-INF/views/";
    private static final String DEFAULT_VIEW_URI_SUFFIX = ".jsp";


    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(DEFAULT_RESOURCES_URI + "/**").addResourceLocations(DEFAULT_RESOURCES_URI + "/");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }


    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        RequestMappingHandlerMapping handlerMapping = new RequestMappingHandlerMapping();
        handlerMapping.setAlwaysUseFullPath(true);
        handlerMapping.setUseTrailingSlashMatch(false);
        handlerMapping.setOrder(1);
        return handlerMapping;
    }

    @Bean
    public ViewResolver urlBasedViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix(DEFAULT_VIEW_URI_PREFIX);
        resolver.setSuffix(DEFAULT_VIEW_URI_SUFFIX);
        resolver.setOrder(1);
        return resolver;
    }


    @Bean
    public View jsonView() {
        return new MappingJackson2JsonView();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new Jackson2ObjectMapperBuilder().build();
    }

}

