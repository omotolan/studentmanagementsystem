package africa.semicolon.studentmanagementsystem.util;

import africa.semicolon.studentmanagementsystem.data.repositories.StaffRepository;
import africa.semicolon.studentmanagementsystem.data.repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class GenerateId {
    private final StudentRepository studentRepository;
    private final StaffRepository staffRepository;

    public GenerateId(StudentRepository studentRepository, StaffRepository staffRepository) {
        this.studentRepository = studentRepository;
        this.staffRepository = staffRepository;
    }

    public String generateStudentId() {
        long number = studentRepository.count() + 1;
        String id = String.format("%04d", number);
        return "ST" + id;

    }

    public String generateStaffId() {
        long number = staffRepository.count() + 1;
        String id = String.format("%03d", number);
        return "STA" + id;

    }

}
