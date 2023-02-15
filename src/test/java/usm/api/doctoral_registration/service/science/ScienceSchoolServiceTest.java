package usm.api.doctoral_registration.service.science;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;
import usm.api.doctoral_registration.DoctoralRegistrationApplication;

@SpringJUnitConfig(classes = {DoctoralRegistrationApplication.class})
@Transactional
class ScienceSchoolServiceTest {

    @Autowired
    private ScienceSchoolService scienceSchoolService;

    @Test
    void test() {
        System.out.println(scienceSchoolService.getScienceSchoolByYears());
    }
}