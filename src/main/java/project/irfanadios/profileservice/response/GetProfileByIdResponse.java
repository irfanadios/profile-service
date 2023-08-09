package project.irfanadios.profileservice.response;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetProfileByIdResponse {
    private UUID userId;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String occupation;
    private String bio;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
