package project.irfanadios.profileservice.util.response;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListResponseBuilder<T> {
    private HttpStatus status;
    private String message;
    private List<T> data;
}
