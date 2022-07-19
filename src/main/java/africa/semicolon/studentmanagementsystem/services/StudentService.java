package africa.semicolon.studentmanagementsystem.services;

import africa.semicolon.studentmanagementsystem.data.models.Student;
import africa.semicolon.studentmanagementsystem.dto.request.RegisterStudentRequest;
import africa.semicolon.studentmanagementsystem.dto.response.RegisterStudentResponse;

import java.util.List;


public interface StudentService {
    RegisterStudentResponse saveStudent(RegisterStudentRequest registerStudentRequest);

    Student getStudentById(String studentId);

    List<Student> getAllStudent();
}
