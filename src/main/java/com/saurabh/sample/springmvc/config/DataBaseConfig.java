package com.saurabh.sample.springmvc.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.saurabh.sample.springmvc.dao")
public class DataBaseConfig {
         
    private static final String PROPERTY_NAME_DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String PROPERTY_NAME_DATABASE_USERNAME = "root";
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "root";
    private static final String PROPERTY_NAME_DATABASE_URL = "jdbc:mysql://localhost:3306/bookstore";
         
    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "org.hibernate.dialect.MySQLDialect";
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "com.saurabh.sample.springmvc.entity";
     
        @Resource
        private Environment env;
         
        @Bean
        public DataSource dataSource() {
                DriverManagerDataSource dataSource = new DriverManagerDataSource();
                 
/*                dataSource.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
                dataSource.setUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
                dataSource.setUsername(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
                dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));*/
                
                dataSource.setDriverClassName(PROPERTY_NAME_DATABASE_DRIVER);
                dataSource.setUrl(PROPERTY_NAME_DATABASE_URL);
                dataSource.setUsername(PROPERTY_NAME_DATABASE_USERNAME);
                dataSource.setPassword(PROPERTY_NAME_DATABASE_PASSWORD);
                 
                return dataSource;
        }
         
        @Bean
        public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
                LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
                entityManagerFactoryBean.setDataSource(dataSource());
                //entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);
                entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
                //entityManagerFactoryBean.setPackagesToScan(env.getRequiredProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));
                entityManagerFactoryBean.setPackagesToScan(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN);
                                 
                entityManagerFactoryBean.setJpaProperties(hibProperties());
                 
                return entityManagerFactoryBean;
        }
         
        private Properties hibProperties() {
                Properties properties = new Properties();
/*                properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
                properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));*/
                properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, PROPERTY_NAME_HIBERNATE_DIALECT);
                properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, PROPERTY_NAME_HIBERNATE_SHOW_SQL);
                return properties;        
        }
         
        @Bean
        public JpaTransactionManager transactionManager() {
                JpaTransactionManager transactionManager = new JpaTransactionManager();
                transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
                return transactionManager;
        }
 
}