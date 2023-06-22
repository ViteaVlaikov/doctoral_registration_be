//package usm.api.doctoral_registration.repository;
//
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.context.junit4.SpringRunner;
//import usm.api.doctoral_registration.model.student.Student;
//import usm.api.doctoral_registration.repository.student.StudentRepository;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//class StudentRepositoryTest {
//
//    @Autowired
//    private StudentRepository studentRepository;
//
////    @Autowired
////    private TestEntityManager entityManager;
//
//    //    @Test
////    void testSaveStudent() {
////        // Создание объекта Student
////        Student student = new Student();
////        student.setCorporateEmail("example@example.com");
////        student.setFirstName("John");
////        student.setLastName("Doe");
////        // Установка остальных полей...
////
////        // Сохранение студента в репозитории
////        Student savedStudent = studentRepository.save(student);
////
////        // Проверка сохранения
////        assertNotNull(savedStudent.getId()); // Убедитесь, что ID был сгенерирован
////
////        // Проверка, что сохраненный студент соответствует ожиданиям
////        Optional<Student> retrievedStudent = studentRepository.findById(savedStudent.getId());
////        assertTrue(retrievedStudent.isPresent());
////        assertEquals("example@example.com", retrievedStudent.get().getCorporateEmail());
////        assertEquals("John", retrievedStudent.get().getFirstName());
////        assertEquals("Doe", retrievedStudent.get().getLastName());
////        // Проверьте остальные поля...
////
////        // Удаление студента из репозитория
////        studentRepository.delete(savedStudent);
////
////        // Проверка удаления
////        assertFalse(studentRepository.existsById(savedStudent.getId()));
////    }
//
//    // Дополнительные тесты CRUD операций и других методов репозитория могут быть добавлены по аналогии.
//}
//
