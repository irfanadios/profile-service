package project.irfanadios.profileservice.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.irfanadios.profileservice.request.UpdateProfileRequest;
import project.irfanadios.profileservice.response.GetProfileByIdResponse;
import project.irfanadios.profileservice.service.ProfileService;
import project.irfanadios.profileservice.util.response.DataResponseBuilder;

@RestController
@RequestMapping("/api/profile-service/v1/profile-management")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/profile/{uuid}")
    public ResponseEntity<DataResponseBuilder<GetProfileByIdResponse>> getProfileByUUID(@PathVariable(name = "uuid") String stringUUID) {
        UUID uuid = UUID.fromString(stringUUID);
        DataResponseBuilder<GetProfileByIdResponse> response = profileService.getProfileByUUID(uuid);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PutMapping("/profile/{uuid}")
    public ResponseEntity<DataResponseBuilder<Object>> updateProfileByUUID(@PathVariable(name = "uuid") String stringUUID, @RequestBody UpdateProfileRequest requestBody) {
        UUID uuid = UUID.fromString(stringUUID);
        DataResponseBuilder<Object> response = profileService.updateProfileByUUID(uuid, requestBody);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
