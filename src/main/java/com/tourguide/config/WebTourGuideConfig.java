package com.tourguide.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.tourguide"})
public class WebTourGuideConfig implements WebMvcConfigurer {

	
	   @Bean
	   // Helps in mapping the logical view names to directly view files under a certain pre-configured directory
	   public InternalResourceViewResolver resolver() {
	      InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	      resolver.setViewClass(JstlView.class);
	      resolver.setPrefix("/WEB-INF/views/");
	      resolver.setSuffix(".jsp");
	      return resolver;
	   }
	   
	   @Bean
	   // Accesses resource bundles using specified basenames (here it is messages)
	   public MessageSource messageSource() {
	      ResourceBundleMessageSource source = new ResourceBundleMessageSource();
	      source.setBasename("messages");
	      return source;
	   }
	 
	   @Override
	   // Bootstraps a javax.validation.ValidationFactory and exposes it through the 
	   // Spring Validator interface as well as through the JSR-303 Validator interface 
	   // and the ValidatorFactory interface itself.
	   public Validator getValidator() {
	      LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
	      validator.setValidationMessageSource(messageSource());
	      return validator;
	   }
	   
	   public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	        registry.addResourceHandler("/images/**").addResourceLocations("/images/");

//	        registry.setOrder(1);
	   }
	   
}
