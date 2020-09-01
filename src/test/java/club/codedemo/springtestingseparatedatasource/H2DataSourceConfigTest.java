package club.codedemo.springtestingseparatedatasource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {SpringTestingSeparateDataSourceApplication.class,
        H2DataSourceConfig.class})
public class H2DataSourceConfigTest {
    @Autowired
    StudentRepository studentRepository;

    @Test
    void contextLoads() {
        this.studentRepository.findAll();
    }
}