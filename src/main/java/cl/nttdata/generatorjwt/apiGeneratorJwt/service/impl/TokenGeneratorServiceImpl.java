package cl.nttdata.generatorjwt.apiGeneratorJwt.service.impl;

import cl.nttdata.generatorjwt.apiGeneratorJwt.service.TokenGeneratorService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class TokenGeneratorServiceImpl implements TokenGeneratorService {
    @Value("${spring.security.key}")
    private String SECRET_KEY;
    @Value("${spring.security.time}")
    private long EXPIRATION_TIME;
    @Value("${spring.security.group.app}")
    private  String APP_GROUP;
    @Override
    public String token(String rut) {
        return JWT.create()
                .withSubject(rut)
                .withIssuer(APP_GROUP)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC256(SECRET_KEY));
    }
}
