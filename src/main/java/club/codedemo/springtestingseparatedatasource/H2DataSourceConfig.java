package club.codedemo.springtestingseparatedatasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * @Profile("default") 的存在是由于在H2ProfileJPAConfig同样有类型DataSource
 * 的bean。
 * 如果不加@Profile("default")，则会发生bean命名冲突。
 * 加入@Profile("default")表明：
 * H2DataSourceConfig 应用于default情景，而H2ProfileJPAConfig应于于test情景
 * 这样一来，两个DataSource属于两个情景，便不会发生冲突了。
 *
 * 在文章中讲到H2DataSourceConfig时H2ProfileJPAConfig还不存在
 * 所以即使没有加入@Profile("default")，文章中的代码也不会出错
 */
@Configuration
@PropertySource("classpath:h2datasource.properties")
@Profile("default")
public class H2DataSourceConfig {

    @Autowired
    Environment environment;

    /**
     * 定义数据源
     *
     * @return
     */
    @Bean
    DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url(this.environment.getProperty("jdbc.url"));
        dataSourceBuilder.username(this.environment.getProperty("jdbc.user"));
        dataSourceBuilder.password(this.environment.getProperty("jdbc.password"));
        return dataSourceBuilder.build();
    }
}