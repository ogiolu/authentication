package com.shopbas.authentication.Controllers;

import com.shopbas.authentication.domain.JwtUser;
import com.shopbas.authentication.security.JwtTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/token")
public class TokenController {
    @Autowired
    private JwtTokenGenerator jwtTokenGenerate;
    //private TokenController jwtTokenGenerate;
/*
    public TokenController(TokenController jwtTokenGenerate) {
        this.jwtTokenGenerate = jwtTokenGenerate;
    }
*/
    @PostMapping
    public String generate(@RequestBody JwtUser jwtUser){
       return  jwtTokenGenerate.generate(jwtUser);

    }
}
