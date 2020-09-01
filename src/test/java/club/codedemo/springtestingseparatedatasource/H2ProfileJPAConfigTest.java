package club.codedemo.springtestingseparatedatasource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


@SpringBootTest(classes = {
        SpringTestingSeparateDataSourceApplication.class,
        H2ProfileJPAConfig.class
})
@ActiveProfiles("test")
class H2ProfileJPAConfigTest {
    @Autowired
    StudentRepository studentRepository;

    @Test
    void dataSource() {
        this.studentRepository.findAll();
    }
}