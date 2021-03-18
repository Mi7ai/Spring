package com.demo.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.demo.")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {
//	holds data from property file
	@Autowired
	private Environment env;
	
	
//	define bean for ViewResolver
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	@Bean
	public DataSource securityDataSource() {
		
//		create connection pool
		ComboPooledDataSource ds = new ComboPooledDataSource();
		
//		set jdbc
		try {
			ds.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
		
//		log connection
		System.out.println("url: "+env.getProperty("jdbc.url"));
		System.out.println("user: "+env.getProperty("jdbc.user"));
		
//		set db connection props
		ds.setJdbcUrl(env.getProperty("jdbc.url"));
		ds.setUser(env.getProperty("jdbc.user"));
		ds.setPassword(env.getProperty("jdbc.password"));
		
//		set connection pool props
		ds.setInitialPoolSize(getProp("connection.pool.initialPoolSize"));
		ds.setMinPoolSize(getProp("connection.pool.minPoolSize"));
		ds.setMaxPoolSize(getProp("connection.pool.maxPoolSize"));
		ds.setMaxIdleTime(getProp("connection.pool.maxIdleTime"));
		
		return ds;
	}
	
//	helper method, reads env property and converts to int
	
	public int getProp(String propName) {
		int propVal = Integer.parseInt(env.getProperty(propName));
		
		return propVal;
	}
}
