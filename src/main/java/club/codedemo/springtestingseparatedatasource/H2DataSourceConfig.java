package club.codedemo.springtestingseparatedatasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:h2datasource.properties")
public class H2DataSourceConfig {

    @Autowired
    Environment environment;

    @Bean
    DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url(this.environment.getProperty("jdbc.url"));
        dataSourceBuilder.username(this.environment.getProperty("jdbc.user"));
        dataSourceBuilder.password(this.environment.getProperty("jdbc.password"));
        return dataSourceBuilder.build();
    }
}
