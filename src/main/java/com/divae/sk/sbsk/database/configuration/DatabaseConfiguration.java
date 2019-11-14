package com.divae.sk.sbsk.database.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

/**
 * https://info.michael-simons.eu/2018/01/13/spring-security-5-new-password-storage-format/
 * https://stackabuse.com/password-encoding-with-spring-security/
 */
@Configuration
public class DatabaseConfiguration {

    @Bean(name = "customDelegatingPasswordEncoder")
    public PasswordEncoder customDelegatingPasswordEncoder_Pbkdf2() {
        String idForEncoding = "pbkdf2";
        final Pbkdf2PasswordEncoder defaultEncoder = new Pbkdf2PasswordEncoder();

        final Map<String, PasswordEncoder> passwordEncoders = new HashMap<>();
        passwordEncoders.put(idForEncoding, defaultEncoder);
        passwordEncoders.put("bcrypt", new BCryptPasswordEncoder());

        final DelegatingPasswordEncoder dpe = new DelegatingPasswordEncoder(idForEncoding, passwordEncoders);
        dpe.setDefaultPasswordEncoderForMatches(defaultEncoder);

        return dpe;
    }
}
