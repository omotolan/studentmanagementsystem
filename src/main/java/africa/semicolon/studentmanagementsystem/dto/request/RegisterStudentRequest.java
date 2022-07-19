package africa.semicolon.studentmanagementsystem.dto.request;

import africa.semicolon.studentmanagementsystem.util.enums.Department;
import africa.semicolon.studentmanagementsystem.util.enums.Gender;
import africa.semicolon.studentmanagementsystem.util.enums.StudentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterStudentRequest {

    @NotNull
    private String firstName;
    @NotNull(message = "can not be null")
    @NotEmpty(message = "not empty")
    private String lastName;
    private StudentType studentType;
    private Department department;
    private String studentClass;
    private Gender gender;
    private Set<String> subjects;
    private String dateOfBirth;
    private int age;



}
