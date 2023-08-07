package project.irfanadios.profileservice.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import project.irfanadios.profileservice.model.Profile;
import project.irfanadios.profileservice.repository.ProfileRepository;

@Service
public class KafkaConsumer {
    private static Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @Autowired
    private ProfileRepository profileRepository;

    @KafkaListener(topics = "auth-profile-topics", groupId = "mygroup")
    public void consume(String message) {
        logger.info(message);
        Profile profile = Profile.builder().userId(UUID.fromString(message)).build();
        profileRepository.save(profile);
    }
}
