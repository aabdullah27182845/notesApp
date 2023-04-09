package com.abdullah.notesApp.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    JdbcUserDetailsManager users(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.ignoringRequestMatchers("/sign-up"))
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/sign-up").permitAll();
                    auth.anyRequest().authenticated();
                }).headers(headers -> headers.frameOptions().sameOrigin())
                .formLogin(Customizer.withDefaults())
                .httpBasic();
        return http.build();
    }

//                .authorizeHttpRequests()
//                .requestMatchers("/sign-up").permitAll()
//                .and()
//                .headers().frameOptions().disable()
//                .and()
//                .httpBasic().disable()
//                .formLogin().disable();
//        http.sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
//                .maximumSessions(1);




}