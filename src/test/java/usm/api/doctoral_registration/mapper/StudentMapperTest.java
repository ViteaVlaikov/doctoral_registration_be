package usm.api.doctoral_registration.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(classes = {StudentMapper.class})
class StudentMapperTest {

    @Autowired
    StudentMapper studentMapper;

    @Test
    void test() {

    }
}