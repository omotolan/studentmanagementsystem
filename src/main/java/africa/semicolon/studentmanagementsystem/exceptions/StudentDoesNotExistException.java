package africa.semicolon.studentmanagementsystem.exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StudentDoesNotExistException extends RuntimeException {
    public StudentDoesNotExistException(String message) {
    }
}
