package project.irfanadios.profileservice.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import project.irfanadios.profileservice.model.Profile;
import project.irfanadios.profileservice.repository.ProfileRepository;
import project.irfanadios.profileservice.request.UpdateProfileRequest;
import project.irfanadios.profileservice.response.GetProfileByIdResponse;
import project.irfanadios.profileservice.util.response.DataResponseBuilder;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    public DataResponseBuilder<GetProfileByIdResponse> getProfileByUUID(UUID uuid) {
        if (!profileRepository.existsById(uuid)) {
            return DataResponseBuilder.<GetProfileByIdResponse>builder()
                .status(HttpStatus.NOT_FOUND)
                .message("Get Profile By Id Fail. Profile with UUID " + uuid + " Not Found.")
            .build();
        }

        Profile profile = profileRepository.getReferenceById(uuid);

        GetProfileByIdResponse response = GetProfileByIdResponse.builder()
            .userId(profile.getUserId())
            .firstName(profile.getFirstName())
            .lastName(profile.getLastName())
            .mobileNumber(profile.getMobileNumber())
            .occupation(profile.getOccupation())
            .bio(profile.getBio())
            .createdTime(profile.getCreatedTime())
            .updatedTime(profile.getUpdatedTime())
        .build();

        return DataResponseBuilder.<GetProfileByIdResponse>builder()
            .status(HttpStatus.OK)
            .message("Get Profile By Id Success.")
            .data(response)
        .build();
    }

    public DataResponseBuilder<Object> updateProfileByUUID(UUID uuid, UpdateProfileRequest requestBody) {
        if (!profileRepository.existsById(uuid)) {
            return DataResponseBuilder.<Object>builder()
                .status(HttpStatus.NOT_FOUND)
                .message("Update Profile By Id Fail. Profile with UUID " + uuid + " Not Found.")
            .build();
        }

        Profile profile = profileRepository.getReferenceById(uuid);

        profile.setFirstName(requestBody.getFirstName());
        profile.setLastName(requestBody.getLastName());
        profile.setMobileNumber(requestBody.getMobileNumber());
        profile.setOccupation(requestBody.getOccupation());
        profile.setBio(requestBody.getBio());

        profileRepository.save(profile);

        return DataResponseBuilder.builder()
            .status(HttpStatus.OK)
            .message("Update Profile By Id Success.")
        .build();
    }
}
