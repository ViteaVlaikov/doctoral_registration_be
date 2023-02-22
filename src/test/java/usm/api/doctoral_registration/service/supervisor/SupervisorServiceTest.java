package usm.api.doctoral_registration.service.supervisor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import usm.api.doctoral_registration.dto.supervisor.SupervisorDto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SupervisorServiceTest {

    @Autowired
    private SupervisorService supervisorService;

    @Test
    void test() {
        List<SupervisorDto> allByScienceSchool = supervisorService.findAllByScienceSchool(1L);

        System.out.println(allByScienceSchool);
    }
}