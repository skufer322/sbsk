package com.divae.sk.sbsk.database.configuration;

import com.divae.sk.sbsk.database.UserEntity;
import com.divae.sk.sbsk.database.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Role vs Authority
 * -> https://www.baeldung.com/spring-security-granted-authority-vs-role
 * -> https://stackoverflow.com/questions/19525380/difference-between-role-and-grantedauthority-in-spring-security
 * <p>
 * Spring adds 'ROLE_' prefix to every role by default
 * -> remove it: https://developer.okta.com/blog/2018/10/05/build-a-spring-boot-app-with-user-authentication
 */
@Configuration
@Profile("!test")
public class CustomUserDetailsServiceConfig {

    @Bean
    GrantedAuthorityDefaults grantedAuthorityDefaults() {
        return new GrantedAuthorityDefaults(""); // Remove the ROLE_ prefix
    }

    @Bean
    public UserDetailsService getUserDetailsFromDb(final UserRepository userRepository) {
        return username ->
                userRepository.findOneByUserName(username)
                        .map(userEntity -> new User(userEntity.getUserName(), userEntity.getHashedPassword(), getUserRoles(userEntity)))
                        .orElseThrow(() -> new UsernameNotFoundException(username));
    }

    private Collection<GrantedAuthority> getUserRoles(UserEntity userEntity) {
        return userEntity.getUserRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.toString()))
                .collect(Collectors.toList());
    }
}
