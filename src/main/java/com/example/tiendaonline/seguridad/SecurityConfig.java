package com.example.tiendaonline.seguridad;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	InMemoryUserDetailsManager inMemoryUserDetailsManager() {
		UserDetails admin = User.withDefaultPasswordEncoder().username("admin").password("admin").roles("ADMIN")
				.build();
		return new InMemoryUserDetailsManager(admin);
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(auth -> auth.requestMatchers(AntPathRequestMatcher.antMatcher("/webjars/**"))
				.permitAll().requestMatchers(AntPathRequestMatcher.antMatcher("/css/**")).permitAll()
				.requestMatchers(AntPathRequestMatcher.antMatcher("/assets/**")).permitAll()
				.requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll().anyRequest()
				.authenticated()).formLogin(login -> login.loginPage("/login").permitAll());
		http.csrf(csrf -> csrf.disable());
		http.headers(headers -> headers.frameOptions(frame -> frame.disable()));
		return http.build();
	}

}
