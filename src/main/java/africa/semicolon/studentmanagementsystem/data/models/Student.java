package africa.semicolon.studentmanagementsystem.data.models;

import africa.semicolon.studentmanagementsystem.util.enums.Department;
import africa.semicolon.studentmanagementsystem.util.enums.Gender;
import africa.semicolon.studentmanagementsystem.util.enums.StudentType;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document("students")
public class Student {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String studentId;
    private StudentType studentType;
    private Gender gender;
    private Set<String> subjects;
    private String dateOfBirth;
    private int age;
    private Department department;
    private String studentClass;
    private Instant dateCreated = Instant.now();


}

