package africa.semicolon.studentmanagementsystem.exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NoSuchStudentException extends RuntimeException {
    public NoSuchStudentException(String message) {
    }
}
