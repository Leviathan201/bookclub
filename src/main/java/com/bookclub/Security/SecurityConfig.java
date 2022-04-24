package com.bookclub.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder(); //Creates a random password to login to the bookclub web

        auth
                .inMemoryAuthentication()
                .withUser("user").password(encoder.encode("password")).roles("USER")
                .and()
                .withUser("testuser01").password(encoder.encode("password02")).roles("USER", "ADMIN"); //Created a password and username here
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated() //Authenticates a request
                .and()
                .formLogin()
                .loginPage("/login") //Brings you to the login page
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout=true") //Logs the user out successfully
                .invalidateHttpSession(true) //Creates a invalid session if user inputs wrong password or user
                .permitAll();
    }
}