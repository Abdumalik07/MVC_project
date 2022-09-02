package peaksoft.Configuration;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.security.PublicKey;
import java.util.Objects;
import java.util.Properties;

@Configuration
@PropertySource("classpath:datasource.properties")
@EnableTransactionManagement(proxyTargetClass = true)
@ComponentScan(basePackages = "peaksoft")
public class HibernateConfig {
   public final Environment environment;
    @Autowired
    public HibernateConfig(Environment environment) {
        this.environment = environment;
    }


    @Bean
    public LocalContainerEntityManagerFactoryBean managerFactoryBean(){
        LocalContainerEntityManagerFactoryBean manager =
                new LocalContainerEntityManagerFactoryBean();
        manager.setJpaVendorAdapter(jpaVendorAdapter());
        manager.setDataSource(dataSource());
        manager.setPackagesToScan("peaksoft.entity");
        manager.setJpaProperties(properties());
        return manager;
    }
    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        return new HibernateJpaVendorAdapter();
    }
    @Bean
    public DataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(environment.getProperty("datasource.driverName"));
        dataSource.setUrl(environment.getProperty("datasource.url"));
        dataSource.setUsername(environment.getProperty("datasource.userName"));
        dataSource.setPassword(environment.getProperty("datasource.password"));
        return dataSource;
    }
    @Bean
    public PlatformTransactionManager transactionManager(){
        return new JpaTransactionManager(Objects.requireNonNull
                (managerFactoryBean().getObject()));
    }
    public Properties properties(){
        Properties properties = new Properties();
        properties.put("hibernate.dialect",environment.getProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql",environment.getProperty("hibernate.show_sql"));
        properties.put("hibernate.hbm2ddl.auto",environment.getProperty("hibernate.hbm2ddl.auto"));
        return properties;
    }
}