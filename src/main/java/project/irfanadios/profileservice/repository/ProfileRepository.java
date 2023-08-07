package project.irfanadios.profileservice.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import project.irfanadios.profileservice.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile, UUID> {
    
}
