package com.divae.sk.sbsk.testdata;

import com.divae.sk.sbsk.database.UserEntity;
import com.divae.sk.sbsk.database.UserRepository;
import com.divae.sk.sbsk.database.UserRole;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;

@Component
@Profile("local-with-mssql")
@RequiredArgsConstructor
@Slf4j
public class CreateTestData {

    private final UserRepository userRepository;
    private final PasswordEncoder customDelegatingPasswordEncoder;
    private final PasswordEncoder defaultDelegatingPasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @PostConstruct
    public void triggerTestDataCreation() {
        log.info("STARTING TO CREATE TEST DATA...");
        createUsers();
    }

    private void createUsers() {
        UserEntity user1 = new UserEntity();
        user1.setUserName("FR");
        user1.setHashedPassword(customDelegatingPasswordEncoder.encode("123abc"));
        user1.setUserRoles(List.of(UserRole.USER, UserRole.ADMIN));

        UserEntity user2 = new UserEntity();
        user2.setUserName("SK");
        user2.setHashedPassword(defaultDelegatingPasswordEncoder.encode("456def"));
        user2.setUserRoles(Collections.singletonList(UserRole.USER));

        userRepository.save(user1);
        userRepository.save(user2);
    }
}
