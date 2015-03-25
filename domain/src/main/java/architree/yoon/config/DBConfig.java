package architree.yoon.config;

import architree.yoon.util.Constant;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by yoon on 15. 3. 25..
 */
@Configuration
@PropertySource("classpath:/db.properties")
@EnableJpaRepositories(basePackages = "architree.yoon.repository")
@EnableTransactionManagement
public class DBConfig {

    Environment environment;

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {

        BasicDataSource dataSource = new BasicDataSource();

        String driverClassName = environment.getProperty(Constant.PROPERTY_KEY_DB_DRIVERCLASSNAME);
        String url = environment.getProperty(Constant.PROPERTY_KEY_DB_URL);
        String username = environment.getProperty(Constant.PROPERTY_KEY_DB_USERNAME);
        String password = environment.getProperty(Constant.PROPERTY_KEY_DB_PASSWORD);

        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("architree.yoon.domain");
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);

        String jpaDialect = Constant.PROPERTY_KEY_JPA_DIALECT;
        String jpaFormatSql = Constant.PROPERTY_KEY_DB_FORMATSQL;
        String jpaNamingStrategy = Constant.PROPERTY_KEY_DB_NAMING_STRATEGY;
        String jpaShowSql = Constant.PROPERTY_KEY_DB_SHOWSQL;
        String jpaOperationMode=Constant.PROPERTY_KEY_DB_JPATODDL;

        Properties jpaProperties = new Properties();
        jpaProperties.put(jpaDialect, environment.getProperty(jpaDialect));
        jpaProperties.put(jpaFormatSql, environment.getProperty(jpaFormatSql));
        jpaProperties.put(jpaNamingStrategy, environment.getProperty(jpaNamingStrategy));
        jpaProperties.put(jpaShowSql, environment.getProperty(jpaShowSql));
        jpaProperties.put(jpaOperationMode, environment.getProperty(jpaOperationMode));

        entityManagerFactoryBean.setJpaProperties(jpaProperties);
        return entityManagerFactoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                entityManagerFactory().getObject()
        );

        return transactionManager;
    }

}
