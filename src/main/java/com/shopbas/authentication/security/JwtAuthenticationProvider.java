package com.shopbas.authentication.security;

import com.shopbas.authentication.domain.JwtAuthenticationToken;
import com.shopbas.authentication.domain.JwtUser;
import com.shopbas.authentication.domain.JwtUserDatails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
    @Autowired
   private JwtValidator jwtValidator;
    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

    }

    @Override
    protected UserDetails retrieveUser(String userName, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        JwtAuthenticationToken jwtAuthenticationToken =(JwtAuthenticationToken)usernamePasswordAuthenticationToken;
        String token =jwtAuthenticationToken.getToken();
        System.out.println("token >>>>>>>>>>>>>>>>>>>>>>>"+token);
        JwtUser jwtUser = jwtValidator.validate(token);

        if (jwtUser==null){
            throw new RuntimeException("JWT token is invalid");
        }
       List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(jwtUser.getRole());
       return  new JwtUserDatails(jwtUser.getUserName(),jwtUser.getId(),token,grantedAuthorities);

    }

    @Override
    public boolean supports(Class<?> aClass) {
        return JwtAuthenticationToken.class.isAssignableFrom(aClass);
    }
}
