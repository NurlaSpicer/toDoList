package kz.iitu.itse1910.sagyndykov.todo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "kz.iitu.itse1910.sagyndykov.todo")
@Resource(description = "classpath:application.properties")
@EnableTransactionManagement
@EnableJpaAuditing
public class AppConfig {
    private static Logger logger = LoggerFactory.getLogger(AppConfig.class);

    @Bean
    public DataSource dataSource() {
        try {
            DriverManagerDataSource driver = new DriverManagerDataSource();
            driver.setDriverClassName("org.postgresql.Driver");
            driver.setUrl("jdbc:postgresql://localhost:5432/Sagyndykov");
            driver.setUsername("postgres");
            driver.setPassword("Nurik-2018");
            return driver;
        } catch (Exception e) {
            logger.error("Embedded DataSource bean cannot be created!", e);
            return null;
        }
    }

    private Properties hibernateProperties() {
        Properties hibernateProp = new Properties();
        hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        hibernateProp.put("hibernate.show_sql", false);
        hibernateProp.put("hibernate.connection.driver_class", "org.postgresql.Driver");
        hibernateProp.put("hibernate.connection.URL", "jdbc:postgresql://localhost:5432/Sagyndykov");
        hibernateProp.put("hibernate.hbm2ddl.auto", "update");
        return hibernateProp;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory());
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPackagesToScan("kz.iitu.itse1910.sagyndykov.todo");
        factoryBean.setDataSource(dataSource());
        factoryBean.setJpaProperties(hibernateProperties());
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        factoryBean.afterPropertiesSet();
        return factoryBean.getNativeEntityManagerFactory();
    }


    @Bean
    public OpenAPI openAPIConfig(){
        return new OpenAPI().info(apiInfo());
    }

    public Info apiInfo() {
        Info info = new Info();
        info.
                title("Task Manager API").description("Simple REST Spring boot project with CRUD logic");
        return info;
    }
}
