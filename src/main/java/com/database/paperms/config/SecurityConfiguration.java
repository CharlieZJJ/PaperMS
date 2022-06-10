package com.database.paperms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

/**
 * ClassName: com.database.paperms.config.SecurityConfiguration
 * Created by zjj
 * Date: 2022-05-06 17:39
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final String PRIVATE_KEY = "47ec0603-f7ee-4c24-b72d-b07dd7cacee2";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**")
                .permitAll().anyRequest()
                .authenticated()
                .and().csrf().disable();
    }

    @Bean
    public Pbkdf2PasswordEncoder bcryptPasswordEncoder() {
        return new Pbkdf2PasswordEncoder(PRIVATE_KEY);
    }
}
