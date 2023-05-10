package usm.api.doctoral_registration.service.supervisor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import usm.api.doctoral_registration.dto.supervisor.SupervisorDto;

import java.util.List;

@SpringBootTest
class SupervisorServiceImplTest {

    @Autowired
    private SupervisorServiceImpl supervisorServiceImpl;

    @Test
    void test() {
        List<SupervisorDto> allByScienceSchool = supervisorServiceImpl.findAllByScienceSchool(1L);

        System.out.println(allByScienceSchool);
    }
}