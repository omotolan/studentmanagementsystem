package africa.semicolon.studentmanagementsystem.services;

import africa.semicolon.studentmanagementsystem.data.models.Student;
import africa.semicolon.studentmanagementsystem.data.repositories.StudentRepository;
import africa.semicolon.studentmanagementsystem.exceptions.NoSuchStudentException;
import africa.semicolon.studentmanagementsystem.util.GenerateStudentId;
import africa.semicolon.studentmanagementsystem.util.ModelMapper;
import africa.semicolon.studentmanagementsystem.dto.request.RegisterStudentRequest;
import africa.semicolon.studentmanagementsystem.dto.response.RegisterStudentResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StudentServicesImpl implements StudentService {


    private final StudentRepository studentRepository;
    private final GenerateStudentId generateId;

    @Autowired
    public StudentServicesImpl(StudentRepository studentRepository, GenerateStudentId generateId) {
        this.studentRepository = studentRepository;
        this.generateId = generateId;
    }


    @Override
    public RegisterStudentResponse saveStudent(RegisterStudentRequest registerStudentRequest) {
        if (registerStudentRequest == null) {
            throw new IllegalArgumentException("can not be blank");
        }
        Student student = ModelMapper.map(registerStudentRequest);
        student.setStudentId(generateId.generateId());

        studentRepository.save(student);
        log.info("student with id:" + student.getStudentId() + " registered");
        return new RegisterStudentResponse("student " + student.getFirstName() +
                " created. StudentId is: " + student.getStudentId());
    }

    @Override
    public Student getStudentById(String studentId) {
        Student student = studentRepository.findByStudentId(studentId);
        if (student == null){
            throw new NoSuchStudentException("No student with id number: " + studentId);
        }
        return student;
    }

    @Override
    public List<Student> getAllStudent() {

        return studentRepository.findAll();
    }


}
