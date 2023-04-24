package com.gtbackend.gtbackend;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@ConfigurationProperties(prefix = "spring.user.datasource")
public class SecurityConfig {

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//        http.cors().and().csrf().disable().authorizeRequests()
//                .antMatchers("/api/v1/**")
//                .permitAll() // allow access without authentication
//                .anyRequest().authenticated(); // require authentication for all other requests
//        return http.build();
//    }
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
    http.cors().and().csrf().disable().authorizeRequests().antMatchers("/api/v1/getAirlineAll").permitAll()
            .antMatchers("/api/v1/**").authenticated().and()
            .rememberMe(); // todo: enable csrf protection after testing
    return http.build();
}

}
