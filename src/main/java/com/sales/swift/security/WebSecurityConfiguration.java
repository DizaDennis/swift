package com.sales.swift.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


/***
 * Incomplete security config class instead of having to use XML
 * Uses BCrypt to encrypt passwords in the DB
 * This class can be used to set RBAC
 * @author dennisdiza
 */

@Configuration
public class WebSecurityConfiguration {

    private UserDetailsService userDetailsService;
    @Bean
    public PasswordEncoder getPasswordEncoder() {

        return new BCryptPasswordEncoder();
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.
                userDetailsService(userDetailsService)
                .passwordEncoder(getPasswordEncoder());
    }
    /*
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/login").permitAll()
                .anyRequest().hasRole("USER")
             //   .requestMatchers("/admin").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and().build();


    }
*/
}








/*

Udemy Config
@Bean
public InMemoryUserDetailsManager userDetailsManager(){

    UserDetails Dennis = User.builder()
            .username("dennis")
            .password("test")
            .roles("ADMIN")
            .build();
return new InMemoryUserDetailsManager(Dennis);

}
}
 */




