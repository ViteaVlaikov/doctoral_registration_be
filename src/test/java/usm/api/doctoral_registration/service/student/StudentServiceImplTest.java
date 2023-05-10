package usm.api.doctoral_registration.service.student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentServiceImplTest {

    @Autowired
    private StudentServiceImpl studentService;

    @Test
    void test() {
        System.out.println(studentService.findById(1L));
    }
}