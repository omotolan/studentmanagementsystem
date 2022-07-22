package africa.semicolon.studentmanagementsystem.services;

import africa.semicolon.studentmanagementsystem.data.models.Student;
import africa.semicolon.studentmanagementsystem.dto.request.RegisterStudentRequest;
import africa.semicolon.studentmanagementsystem.dto.response.RegisterStudentResponse;
import africa.semicolon.studentmanagementsystem.util.enums.StudentType;

import java.util.List;


public interface StudentService {
    RegisterStudentResponse saveStudent(RegisterStudentRequest registerStudentRequest);

    Student getStudentById(String studentId);

    List<Student> getAllStudent();

    List<Student> getStudentsByClass(String studentClass);

    List<Student> getStudentByStudentType(StudentType boarding);
}
