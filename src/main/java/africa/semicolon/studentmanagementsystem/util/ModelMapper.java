package africa.semicolon.studentmanagementsystem.util;

import africa.semicolon.studentmanagementsystem.data.models.Staff;
import africa.semicolon.studentmanagementsystem.data.models.Student;
import africa.semicolon.studentmanagementsystem.dto.request.RegisterStaffRequest;
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
    public static Staff map(RegisterStaffRequest registerStaffRequest){
        Staff staff = new Staff();

        staff.setFirstName(registerStaffRequest.getFirstName());
        staff.setLastName(registerStaffRequest.getLastName());
        staff.setStaffType(registerStaffRequest.getStaffType());
        staff.setSubjectTaught(registerStaffRequest.getSubjectTaught());
        staff.setGender(registerStaffRequest.getGender());
        staff.setEmailAddress(registerStaffRequest.getEmailAddress());

        return staff;
    }

}
