package usm.api.doctoral_registration.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ScienceSchoolControllerTest {

    @Autowired
    ScienceSchoolController scienceSchoolController;



    @Test
    void test() {
        System.out.println(scienceSchoolController.getSciences());
    }
}