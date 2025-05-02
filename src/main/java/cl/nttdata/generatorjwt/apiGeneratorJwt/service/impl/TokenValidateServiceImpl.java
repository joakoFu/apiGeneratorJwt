package cl.nttdata.generatorjwt.apiGeneratorJwt.service.impl;

import cl.nttdata.generatorjwt.apiGeneratorJwt.service.TokenValidateService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenValidateServiceImpl implements TokenValidateService {
    @Value("${spring.security.key}")
    private String SECRET_KEY;
    @Value("${spring.security.group.app}")
    private  String APP_GROUP;
    @Override
    public String token(String token) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
        return JWT.require(algorithm)
                .withIssuer(APP_GROUP)
                .build()
                .verify(token)
                .getSubject();
    }
}
