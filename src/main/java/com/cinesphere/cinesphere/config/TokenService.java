package com.cinesphere.cinesphere.config;

import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.cinesphere.cinesphere.entity.User;

@Component
public class TokenService {
    @Value("${cinesphere.security.secret}")
    private String secret;

   public String generationToken(User user){
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.create()
                  .withSubject(user.getEmail())
                  .withClaim("userId", user.getId())
                  .withClaim("name", user.getName())
                  .withExpiresAt(Date.from(Instant.now().plusSeconds(86400)))
                  .withIssuedAt(Date.from(Instant.now()))
                  .withIssuer("API cinesphere")
                  .sign(algorithm);
    }

}