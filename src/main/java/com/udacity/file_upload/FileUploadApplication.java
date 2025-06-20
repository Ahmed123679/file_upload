package com.udacity.file_upload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.udacity.file_upload.filter.HelloFilter;
import com.udacity.file_upload.servlet.HelloServlet;

@SpringBootApplication

public class FileUploadApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileUploadApplication.class, args);
	}
	@Bean
	public ServletRegistrationBean<HelloServlet> getServletRegistrationBean()
	{
		ServletRegistrationBean<HelloServlet> helloServlet = new ServletRegistrationBean<>(new HelloServlet());
		helloServlet.addUrlMappings("/servlet","/helloServlet");
		return helloServlet;
	}
	@Bean
	public FilterRegistrationBean<HelloFilter> getFilterRegistrationBean()
	{
		FilterRegistrationBean<HelloFilter> helloFilter = new FilterRegistrationBean<>(new HelloFilter());
		helloFilter.addUrlPatterns("/servlet","/helloServlet");
		return helloFilter;
	}

}
