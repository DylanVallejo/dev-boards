package com.hiring.devs.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration//indicara que las clases estaran anotadas con bean
@EnableWebSecurity//notacion de security
public class SecurityConfig {


//    filtro para establecer rutas protegidas y no protegidas
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return  httpSecurity
                .cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authRequest -> {
                        authRequest
                            .requestMatchers("/auth/**").permitAll()
                            .anyRequest()
                            .authenticated();
                }).formLogin(Customizer.withDefaults()).build();
    }




}
