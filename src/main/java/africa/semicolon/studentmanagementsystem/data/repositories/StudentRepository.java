package africa.semicolon.studentmanagementsystem.data.repositories;

import africa.semicolon.studentmanagementsystem.data.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    Student findByFirstName(String firstName);

    Student findByStudentId(String studentId);
}
