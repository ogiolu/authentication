package com.shopbas.authentication.security;

import com.shopbas.authentication.domain.JwtAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {

    private AuthenticationManager authenticationManager;

    private JwtSuccessHandler authenticationSuccessHandler;

     public JwtAuthenticationTokenFilter(){
         super("/rest/**");
     }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        String header =httpServletRequest.getHeader("Authorization");
       // if (header== null && !header.startsWith("Token")){

        ///
        if (header== null ){
            throw new RuntimeException("JWT Token Missing");
        }
        //String authenticationToken=header.substring(6);
        String authenticationToken=header;
        JwtAuthenticationToken token =new JwtAuthenticationToken(authenticationToken);
        return getAuthenticationManager().authenticate(token);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        System.out.println("Authentication Successful >>>>>>>>>>>>>>>>>>>>>>>>.");
        chain.doFilter(request,response);
    }
}
