package com.pngabo.hotelWebApi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    private final PasswordEncoder encoder;
//
//    public WebSecurityConfig(PasswordEncoder encoder) {
//        this.encoder = encoder;
//    }
    private final UserDetailsService userDetailsService;

    public WebSecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin").password(encoder.encode("pass")).authorities("ADMIN", "USER")
//                .and()
//                .withUser("user").password(encoder.encode("pass")).authorities("USER");
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.httpBasic();

        http.authorizeRequests()
                //Client
                .antMatchers(HttpMethod.POST, "/client/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PATCH, "/client/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/client/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT, "/client/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/client/**").hasAuthority("USER")
                .anyRequest().permitAll();
        //pour H2
        http.headers()
                .frameOptions()
                .disable();
    }
}
