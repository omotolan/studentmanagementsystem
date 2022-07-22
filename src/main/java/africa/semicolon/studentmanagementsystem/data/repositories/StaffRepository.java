package africa.semicolon.studentmanagementsystem.data.repositories;

import africa.semicolon.studentmanagementsystem.data.models.Staff;
import africa.semicolon.studentmanagementsystem.util.enums.StaffType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends MongoRepository<Staff, String> {
    Staff findByEmailAddress(String emailAddress);

    Staff findByStaffId(String staffId);

    List<Staff> findByStaffType(StaffType staffType);
}
