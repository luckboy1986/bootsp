package com.zhaomlb.club.bootsp;

import org.beetl.core.resource.WebAppResourceLoader;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;

import java.io.IOException;

@SpringBootApplication
public class BootspApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootspApplication.class, args);

	}

	@Bean(initMethod = "init")
	public BeetlGroupUtilConfiguration beetlConfiguration() {

		BeetlGroupUtilConfiguration configuration = new BeetlGroupUtilConfiguration();
		ResourcePatternResolver patternResolver = ResourcePatternUtils.getResourcePatternResolver(new DefaultResourceLoader());

		String path = null;
		try {
			path = patternResolver.getResource("classpath:/").getFile().getPath();
			System.out.println("==================path:" + path);
			WebAppResourceLoader resourceLoader = new WebAppResourceLoader(path);
			configuration.setResourceLoader(resourceLoader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return configuration;
	}

	@Bean
	public BeetlSpringViewResolver getBeetlSpringViewResolver() {
		BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
		beetlSpringViewResolver.setPrefix("/templates/");
		beetlSpringViewResolver.setSuffix(".btl");
		beetlSpringViewResolver.setContentType("text/html;charset=UTF-8");
		beetlSpringViewResolver.setOrder(0);
		beetlSpringViewResolver.setConfig(beetlConfiguration());

		return beetlSpringViewResolver;
	}
}
