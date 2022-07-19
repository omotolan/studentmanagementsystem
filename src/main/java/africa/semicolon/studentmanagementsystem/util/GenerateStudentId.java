package africa.semicolon.studentmanagementsystem.util;

import africa.semicolon.studentmanagementsystem.data.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenerateStudentId {

    @Autowired
    private StudentRepository studentRepository;
    public  String generateId() {
        long number = studentRepository.count() + 1;
        String id = String.format("%04d", number);
        return "ST" + id;

    }
}
