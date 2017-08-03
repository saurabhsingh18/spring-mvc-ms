package com.saurabh.sample.springmvc.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@PropertySource(name = "bookStoreProps", value = { "classpath:/spring-mvc-ms/book-store-ms.properties" })
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.saurabh.sample.springmvc.dao")
public class DataBaseConfig {

	@Value("${bookstore.jdbc.driverClassName}")
	private String jdbcDriverClassName;

	@Value("${bookstore.jdbc.url}")
	private String jdbcUrl;

	@Value("${bookstore.jdbc.username}")
	private String jdbcUser;

	@Value("${bookstore.jdbc.password}")
	private String jdbcPassword;

	@Value("${bookstore.hibernate.dialect}")
	private String hibernateDialect;

	@Value("${bookstore.hibernate.show_sql}")
	private String hibernateShowSql;

	private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "bookstore.hibernate.dialect";
	private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "bookstore.hibernate.show_sql";
	private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "com.saurabh.sample.springmvc.entity";

	@Resource
	private Environment env;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(jdbcDriverClassName);
		dataSource.setUrl(jdbcUrl);
		dataSource.setUsername(jdbcUser);
		dataSource.setPassword(jdbcPassword);
		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactoryBean.setPackagesToScan(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN);
		entityManagerFactoryBean.setJpaProperties(hibProperties());
		return entityManagerFactoryBean;
	}

	private Properties hibProperties() {
		Properties properties = new Properties();
		properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, hibernateDialect);
		properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, hibernateShowSql);
		return properties;
	}

	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}

}