package com.example.CafeAPP.JWT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration //would create a bean whenever project is started
public class SecurityConfig  {

    @Autowired
    CustomerUserDetailsService customerUserDetailsService;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(cors->cors.configurationSource(
                        request -> new CorsConfiguration().applyPermitDefaultValues()))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/user/login","/user/register","/user/forgotPassword")
                        .permitAll()  // Allows access to paths under /public
                        .anyRequest().authenticated()  // All other paths require authentication
                )
                .formLogin(withDefaults())  // Default form login configuration
                .logout(withDefaults());    // Default logout configuration
        return http.build();
    }




}
