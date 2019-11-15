package com.divae.sk.sbsk.controller.httpsecurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Profile("!disable-security")
public class CustomHttpSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .csrf()
                .and()
                .headers()
                    .frameOptions().disable()
                    .cacheControl().disable()
                .and()
                .antMatcher("/**")
                .authorizeRequests()
                    .antMatchers("/secured/admin/**")
                    .hasAuthority("ADMIN")
                    .antMatchers("/secured/authenticated/**")
                    .authenticated()
                    .antMatchers("/secured/free/**")
                    .permitAll()
                    .antMatchers("/**")
                    .authenticated();
    }
}
