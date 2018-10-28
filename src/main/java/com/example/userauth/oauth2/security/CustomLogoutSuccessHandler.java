package com.example.userauth.oauth2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

    @Autowired
    private TokenStore tokenStore;
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        String token = httpServletRequest.getHeader("Authorization");
        if(token == null){
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
        else if(token != null && token.startsWith("Bearer")){
            OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(token.split(" ")[1]);
            if(oAuth2AccessToken != null){
                tokenStore.removeAccessToken(oAuth2AccessToken);
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            }
            else{
                httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
            }
        }
    }
}
