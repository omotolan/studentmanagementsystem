package africa.semicolon.studentmanagementsystem.services;

import africa.semicolon.studentmanagementsystem.data.models.Staff;
import africa.semicolon.studentmanagementsystem.data.models.Student;
import africa.semicolon.studentmanagementsystem.data.repositories.StaffRepository;
import africa.semicolon.studentmanagementsystem.dto.request.RegisterStaffRequest;
import africa.semicolon.studentmanagementsystem.dto.response.RegisterStaffResponse;
import africa.semicolon.studentmanagementsystem.exceptions.EmailAlreadyExistException;
import africa.semicolon.studentmanagementsystem.exceptions.StaffDoesNotExistException;
import africa.semicolon.studentmanagementsystem.util.GenerateId;
import africa.semicolon.studentmanagementsystem.util.ModelMapper;
import africa.semicolon.studentmanagementsystem.util.enums.StaffType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StaffServiceImpl implements StaffService {
    private final StaffRepository staffRepository;
    private final GenerateId generateId;

    @Autowired
    public StaffServiceImpl(StaffRepository staffRepository, GenerateId generateId) {
        this.staffRepository = staffRepository;
        this.generateId = generateId;
    }

    @Override
    public RegisterStaffResponse saveStaff(RegisterStaffRequest registerStaffRequest) {
        if (registerStaffRequest == null) {
            throw new IllegalArgumentException("form can not be blank");
        }
        Staff staff = staffRepository.findByEmailAddress(registerStaffRequest.getEmailAddress().toLowerCase());
        if (staff != null) {
            throw new EmailAlreadyExistException("Email already taken");
        }
        staff = ModelMapper.map(registerStaffRequest);
        staff.setEmailAddress(registerStaffRequest.getEmailAddress().toLowerCase());
        staff.setStaffId(generateId.generateStaffId());
        staffRepository.save(staff);

        log.info("staff created, id: " + staff.getStaffId());

        return new RegisterStaffResponse("staff created. Staff id is: " + staff.getStaffId() +
                " staff name: " + staff.getFirstName());
    }

    @Override
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    @Override
    public Staff getStaffById(String staffId) {
        Staff staff = staffRepository.findByStaffId(staffId);
        if (staff == null) {
            throw new StaffDoesNotExistException("No student with id number: " + staffId);
        }

        return staff;
    }

    @Override
    public List<Staff> getStaffByStaffType(StaffType staffType) {
        List<Staff> staffList = staffRepository.findByStaffType(staffType);
        if (staffList == null) {
            throw new IllegalArgumentException("Incorrect details");
        }
        return staffList;
    }
}
