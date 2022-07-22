package africa.semicolon.studentmanagementsystem.data.repositories;

import africa.semicolon.studentmanagementsystem.data.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    Student findByFirstName(String firstName);

    Student findByStudentId(String studentId);

    List<Student> findByStudentClass(String studentClass);

    List<Student> findByStudentType(String valueOf);
}
