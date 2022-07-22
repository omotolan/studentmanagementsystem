package africa.semicolon.studentmanagementsystem.services;

import africa.semicolon.studentmanagementsystem.data.models.Staff;
import africa.semicolon.studentmanagementsystem.dto.request.RegisterStaffRequest;
import africa.semicolon.studentmanagementsystem.dto.response.RegisterStaffResponse;
import africa.semicolon.studentmanagementsystem.util.enums.Gender;
import africa.semicolon.studentmanagementsystem.util.enums.StaffType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ImportAutoConfiguration(exclude = EmbeddedMongoAutoConfiguration.class)
public class StaffServiceImplTest {
    @Autowired
    private StaffService staffService;

    @Test
    public void testThatStaffCanBeAdded() {
        RegisterStaffRequest registerStaffRequest = RegisterStaffRequest.builder()
                .firstName("Alakija")
                .lastName("Emimimo")
                .gender(Gender.FEMALE)
                .staffType(StaffType.TEACHING)
                .emailAddress("love1@yahoo.com")
                .subjectTaught("maths")
                .build();

        RegisterStaffResponse registerStaffResponse = staffService.saveStaff(registerStaffRequest);

        assertEquals("staff created. Staff id is: STA004 staff name: Alakija", registerStaffResponse.toString());
    }

    @Test
    public void testToGetAllStaff() {
        List<Staff> staffs = staffService.getAllStaff();
        assertEquals(" ", staffs);
    }

    @Test
    public void testToGetStaffById() {
        Staff staff = staffService.getStaffById("STA004");
        assertEquals(" ", staff);

    }

    @Test
    public void testToGetStaffByStaffType() {
        List<Staff> staffList = staffService.getStaffByStaffType(StaffType.TEACHING);
        assertEquals(" ", staffList);

    }

}