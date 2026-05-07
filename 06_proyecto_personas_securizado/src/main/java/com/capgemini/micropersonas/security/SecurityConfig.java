package com.capgemini.micropersonas.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }
    //Crea un método para configurar usuarios en memoria con roles ADMIN y USER. Inventa dos usuarios USER y un usuario ADMIN
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
    			UserDetails user1 = User.withUsername("user1")
				.password("{noop}password1")
				.roles("USER")
				.build();

		UserDetails user2 = User.withUsername("user2")
				.password("{noop}password2")
				.roles("USER")
				.build();

		UserDetails admin = User.withUsername("admin")
				.password("{noop}adminpass")
				.roles("ADMIN")
				.build();

		return new InMemoryUserDetailsManager(user1, user2, admin);
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/personas").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/personas/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/personas/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/personas/**").hasAnyRole("ADMIN", "USER")
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}