package club.codedemo.springtestingseparatedatasource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.persistence.EntityManager;

@SpringBootTest
class SpringTestingSeparateDataSourceApplicationTests {
	@Autowired
	StudentRepository studentRepository;

	@Test
	void contextLoads() {
		this.studentRepository.findAll();
	}
}
