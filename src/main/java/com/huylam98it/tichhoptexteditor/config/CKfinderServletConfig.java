package com.huylam98it.tichhoptexteditor.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ckfinder.connector.ConnectorServlet;

@Configuration
public class CKfinderServletConfig {

	@Value("${ckeditor.storage.image.path}")
	private String baseDir;
	@Value("${ckeditor.access.image.url}")
	private String baseUrl;

	@Bean
	public ServletRegistrationBean connectCKFinder() {
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(new ConnectorServlet(),
				"/ckfinder/core/connector/java/connector.java");
		registrationBean.addInitParameter("XMLConfig", "classpath:/static/ckfinder.xml");
		registrationBean.addInitParameter("debug", "false");
		registrationBean.addInitParameter("configuration", "com.huylam98it.tichhoptexteditor.config.CKfinderConfig");
		// ckfinder.xml
		registrationBean.addInitParameter("baseDir", baseDir);
		registrationBean.addInitParameter("baseURL", baseUrl);
		return registrationBean;
	}
}
