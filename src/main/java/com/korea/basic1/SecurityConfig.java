package com.korea.basic1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

    @Configuration
    @EnableWebSecurity
    public class SecurityConfig {
        @Bean
        SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http.authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
                            .requestMatchers(new AntPathRequestMatcher("/**")).permitAll())
                    .headers((headers) -> headers.addHeaderWriter(
                            new XFrameOptionsHeaderWriter(XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN)))
                    //로그인
                    .formLogin((formLogin) -> formLogin
                    .loginPage("/user/login")
                    .defaultSuccessUrl("/"))
                    .oauth2Login(oauth2 -> oauth2
                            .loginPage("/user/login")
                            .defaultSuccessUrl("/")
                            .failureUrl("/user/login?error=true")
                    )
                    //로그아웃
                    .logout((logout) -> logout
                            .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                            .logoutSuccessUrl("/")
                            .invalidateHttpSession(true))
            ;
            return http.build();
        }

        @Bean
        PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

        @Bean
        AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
            return authenticationConfiguration.getAuthenticationManager();
        }
    }