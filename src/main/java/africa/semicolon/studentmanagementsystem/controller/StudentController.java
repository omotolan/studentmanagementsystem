package africa.semicolon.studentmanagementsystem.controller;

import africa.semicolon.studentmanagementsystem.dto.ApiResponse;
import africa.semicolon.studentmanagementsystem.dto.request.RegisterStudentRequest;
import africa.semicolon.studentmanagementsystem.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;
    @PostMapping("/register")
    public ResponseEntity<?> registerStudent(@RequestBody RegisterStudentRequest registerStudentRequest){
        var serviceResponse = studentService.saveStudent(registerStudentRequest);
        ApiResponse apiResponse = new ApiResponse(true, serviceResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }
}
