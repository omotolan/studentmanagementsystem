package africa.semicolon.studentmanagementsystem.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
//@NoArgsConstructor
public class Response {


    private String message;
    @Override
    public String toString(){
        return message;
    }
}
