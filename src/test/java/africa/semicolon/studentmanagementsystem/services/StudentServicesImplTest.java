package africa.semicolon.studentmanagementsystem.services;

import africa.semicolon.studentmanagementsystem.data.models.Student;
import africa.semicolon.studentmanagementsystem.dto.request.RegisterStudentRequest;
import africa.semicolon.studentmanagementsystem.dto.response.RegisterStudentResponse;
import africa.semicolon.studentmanagementsystem.exceptions.NoSuchStudentException;
import africa.semicolon.studentmanagementsystem.util.enums.Gender;
import africa.semicolon.studentmanagementsystem.util.enums.StudentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
@ImportAutoConfiguration(exclude = EmbeddedMongoAutoConfiguration.class)
public class StudentServicesImplTest {
    @Autowired
    private StudentService studentService;


    @Test
    public void testThatStudentCanBeAdded(){
        Set<String> subjects = new HashSet<>();
        subjects.add("english");
        subjects.add("biology");
        subjects.add("chemistry");
        RegisterStudentRequest registerStudentRequest = RegisterStudentRequest
                .builder()
                .firstName("tolani")
                .lastName("akinsola")
                .dateOfBirth("january/ 05/ 2005")
                .age(20)
                .gender(Gender.MALE)
                .studentType(StudentType.BOARDING)
                .subjects(subjects)
                .build();


       RegisterStudentResponse registerStudentResponse = studentService.saveStudent(registerStudentRequest);
       assertEquals("student tolani created. StudentId is: null", registerStudentResponse.toString());

    }
    @Test
    public void testThatStudentCanBeFoundById(){
        Student student = studentService.getStudentById("ST0039");
        assertThat("ST0039").isEqualTo(student.getStudentId());

    }
    @Test
    public void testThatStudentCanBeFoundByIdThrowsException(){

        assertThrows(NoSuchStudentException.class, ()->{studentService.getStudentById("ST00390");});

    }
    @Test()
    public void testThatAllStudentsCanBeGotten(){
        List<Student> studentList = studentService.getAllStudent();
    }

}