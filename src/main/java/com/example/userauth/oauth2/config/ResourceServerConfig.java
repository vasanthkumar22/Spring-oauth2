package com.example.userauth.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private LogoutSuccessHandler customLogoutSuccessHandler;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .headers()
                .frameOptions()
                .disable()
                .and()
//                .logout()
//                .logoutUrl("/oauth/logout")
//                .logoutSuccessHandler(customLogoutSuccessHandler)
//                .and()
                .authorizeRequests()
                .antMatchers("/users/").authenticated()
                .antMatchers("/roles/").authenticated()
                .antMatchers("/private").permitAll()
                .anyRequest().permitAll();
    }
}
