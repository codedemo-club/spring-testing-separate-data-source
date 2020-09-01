package club.codedemo.springtestingseparatedatasource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

/**
 * H2 Profile配置
 */
@Configuration
public class H2ProfileJPAConfig {

    /**
     * 定义数据源
     * @return
     */
    @Bean("h2ProfileDataSource")
    @Profile("test")
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:h2:mem:db_example");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("");
        return dataSourceBuilder.build();
    }
}
