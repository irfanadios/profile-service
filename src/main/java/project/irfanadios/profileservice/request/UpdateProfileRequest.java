package project.irfanadios.profileservice.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProfileRequest {
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String occupation;
    private String bio;
}
