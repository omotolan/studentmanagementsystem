package africa.semicolon.studentmanagementsystem.dto.request;

import africa.semicolon.studentmanagementsystem.util.enums.Gender;
import africa.semicolon.studentmanagementsystem.util.enums.StaffType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterStaffRequest {

    private String firstName;
    private String lastName;
    private String staffId;
    private StaffType staffType;
    private String subjectTaught;
    private Gender gender;
    private String emailAddress;

}
