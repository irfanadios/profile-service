package project.irfanadios.profileservice.util.response;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataResponseBuilder<T> {
    private HttpStatus status;
    private String message;
    private T data;
}
