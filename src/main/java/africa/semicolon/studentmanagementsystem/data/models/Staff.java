package africa.semicolon.studentmanagementsystem.data.models;

import africa.semicolon.studentmanagementsystem.util.enums.Gender;
import africa.semicolon.studentmanagementsystem.util.enums.StaffType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("staffs")
public class Staff {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String staffId;
    private StaffType staffType;
    private String subjectTaught;
    private Gender gender;
    private String emailAddress;
    private Instant dateCreated = Instant.now();

}
