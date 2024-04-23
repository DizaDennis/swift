package com.sales.swift.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
@Configuration
public class WebSecurityConfiguration implements WebSecurityConfigurer {

    @Autowired
    UserDetailsService userDetailsService;
    @Bean
    PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

protected void configure(AuthenticationManagerBuilder auth) throws Exception{


    auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(getPasswordEncoder());

}
    protected void configure(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests()
                .requestMatchers("/login.html").permitAll()
                .requestMatchers("/admin").hasRole("ADMIN")
                .anyRequest().hasRole("USER").and()
                .formLogin(login -> login
                        .loginPage("/login.html")
                        .defaultSuccessUrl("/login.html")
                        .permitAll())
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .permitAll());


    }

    @Override
    public void init(SecurityBuilder builder) throws Exception {

    }

    @Override
    public void configure(SecurityBuilder builder) throws Exception {

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




