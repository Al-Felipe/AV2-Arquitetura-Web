package com.example.autenticacao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> request
                        .requestMatchers(HttpMethod.POST, "/login/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/username/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/user/**").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/gerente/**").hasRole("GERENTE")
                        .requestMatchers("/vendedor/**").hasRole("VENDEDOR")
                        .requestMatchers("/cliente/**").hasRole("CLIENTE")
                        .anyRequest()
                        .authenticated()
                ).httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.builder()
                .username("felipe")
                .password(passwordEncoder().encode("123"))
                .roles("ADMIN")
                .build();
        UserDetails gerente = User.builder()
                .username("fabio")
                .password(passwordEncoder().encode("gerente123"))
                .roles("GERENTE")
                .build();
        UserDetails vendedor = User.builder()
                .username("maria")
                .password(passwordEncoder().encode("vendedor123"))
                .roles("VENDEDOR")
                .build();
        UserDetails cliente = User.builder()
                .username("rose")
                .password(passwordEncoder().encode("cliente123"))
                .roles("CLIENTE")
                .build();



        return new InMemoryUserDetailsManager(admin, gerente, vendedor, cliente);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}


