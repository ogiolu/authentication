package com.shopbas.authentication.Controllers;

import com.shopbas.authentication.domain.JwtUser;
import com.shopbas.authentication.security.JwtTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/token")
public class TokenController {
    @Autowired
    private JwtTokenGenerator jwtTokenGenerate;

    @PostMapping("/generate")
    public String generate(@RequestBody JwtUser jwtUser) throws UnsupportedEncodingException {
        String token =jwtTokenGenerate.generate(jwtUser);
                System.out.println("token generated >>>>>> "+token);
       return  token;

    }
}
