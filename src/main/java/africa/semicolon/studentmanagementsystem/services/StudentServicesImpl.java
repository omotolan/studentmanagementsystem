package africa.semicolon.studentmanagementsystem.services;

import africa.semicolon.studentmanagementsystem.data.models.Student;
import africa.semicolon.studentmanagementsystem.data.repositories.StudentRepository;
import africa.semicolon.studentmanagementsystem.exceptions.StudentDoesNotExistException;
import africa.semicolon.studentmanagementsystem.util.GenerateId;
import africa.semicolon.studentmanagementsystem.util.ModelMapper;
import africa.semicolon.studentmanagementsystem.dto.request.RegisterStudentRequest;
import africa.semicolon.studentmanagementsystem.dto.response.RegisterStudentResponse;
import africa.semicolon.studentmanagementsystem.util.enums.StudentType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StudentServicesImpl implements StudentService {


    private final StudentRepository studentRepository;
    private final GenerateId generateId;

    @Autowired
    public StudentServicesImpl(StudentRepository studentRepository, GenerateId generateId) {
        this.studentRepository = studentRepository;
        this.generateId = generateId;
    }


    @Override
    public RegisterStudentResponse saveStudent(RegisterStudentRequest registerStudentRequest) {
        if (registerStudentRequest == null) {
            throw new IllegalArgumentException("form can not be blank");
        }
        Student student = ModelMapper.map(registerStudentRequest);
        student.setStudentId(generateId.generateStudentId());

        studentRepository.save(student);
        log.info("student with id:" + student.getStudentId() + " registered");
        return new RegisterStudentResponse("student " + student.getFirstName() +
                " created. StudentId is: " + student.getStudentId());
    }

    @Override
    public Student getStudentById(String studentId) {
        Student student = studentRepository.findByStudentId(studentId);
        if (student == null){
            throw new StudentDoesNotExistException("No student with id number: " + studentId);
        }
        return student;
    }

    @Override
    public List<Student> getAllStudent() {

        return studentRepository.findAll();
    }

    @Override
    public List<Student> getStudentsByClass(String studentClass) {
      List<Student> studentList =  studentRepository.findByStudentClass(studentClass);
      if (studentList == null){
          throw new IllegalArgumentException("Incorrect details");
      }
        return studentList;
    }

    @Override
    public List<Student> getStudentByStudentType(StudentType studentType) {
        List<Student> studentList =  studentRepository.findByStudentType(String.valueOf(studentType));
        if (studentList == null){
            throw new IllegalArgumentException("Incorrect details");
        }
        return studentList;
    }


}
