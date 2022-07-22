package africa.semicolon.studentmanagementsystem.services;

import africa.semicolon.studentmanagementsystem.data.models.Staff;
import africa.semicolon.studentmanagementsystem.dto.request.RegisterStaffRequest;
import africa.semicolon.studentmanagementsystem.dto.response.RegisterStaffResponse;
import africa.semicolon.studentmanagementsystem.util.enums.StaffType;

import java.util.List;

public interface StaffService {
    RegisterStaffResponse saveStaff(RegisterStaffRequest registerStaffRequest);

    List<Staff> getAllStaff();

    Staff getStaffById(String staffId);

    List<Staff> getStaffByStaffType(StaffType staffType);
}
