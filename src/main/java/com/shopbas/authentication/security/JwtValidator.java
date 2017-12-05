package com.shopbas.authentication.security;

        import com.shopbas.authentication.domain.JwtUser;
        import io.jsonwebtoken.Claims;
        import io.jsonwebtoken.Jwts;
        import org.springframework.stereotype.Component;

@Component
public class JwtValidator {
   private String secret="youtube";

    public JwtUser validate (String token){
        JwtUser jwtUser = null;
        try {
            Claims body = Jwts.parser().setSigningKey(secret.getBytes("UTF-8")).parseClaimsJws(token).getBody();
            jwtUser = new JwtUser();

            jwtUser.setUserName(body.getSubject());
            jwtUser.setId(Long.parseLong((String) body.get("userId")));
            jwtUser.setRole((String) body.get("role"));
            System.out.println("body.getSubject()" +jwtUser.getUserName());
            System.out.println("body.setId()" +jwtUser.getId());
            System.out.println("body.setRole()" +jwtUser.getRole());
        }
        catch (Exception ex){
            System.out.println(ex);
        }

        return jwtUser;
    }

}
