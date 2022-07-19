package africa.semicolon.studentmanagementsystem.util;

import africa.semicolon.studentmanagementsystem.data.models.Student;
import africa.semicolon.studentmanagementsystem.dto.request.RegisterStudentRequest;

public class ModelMapper {
    public static Student map(RegisterStudentRequest registerStudentRequest) {
        Student student = new Student();

        student.setFirstName(registerStudentRequest.getFirstName());
        student.setLastName(registerStudentRequest.getLastName());
        student.setStudentClass(registerStudentRequest.getStudentClass());
        student.setGender(registerStudentRequest.getGender());
        student.setStudentType(registerStudentRequest.getStudentType());
        student.setAge(registerStudentRequest.getAge());
        student.setSubjects(registerStudentRequest.getSubjects());
        student.setDateOfBirth(registerStudentRequest.getDateOfBirth());
        student.setDepartment(registerStudentRequest.getDepartment());
        return student;

    }

}
