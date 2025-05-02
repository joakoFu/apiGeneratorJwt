package cl.nttdata.generatorjwt.apiGeneratorJwt.controller.impl;

import cl.nttdata.generatorjwt.apiGeneratorJwt.controller.TokenGenerator;
import cl.nttdata.generatorjwt.apiGeneratorJwt.service.TokenGeneratorService;
import cl.nttdata.generatorjwt.apiGeneratorJwt.service.TokenValidateService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
@RestController
@AllArgsConstructor
public class TokenGeneratorImpl implements TokenGenerator {
    private final TokenGeneratorService tokenGeneratorService;
    private final TokenValidateService tokenValidateService;

    @Override
    public ResponseEntity<Object> tokenGeneration(String rut) {

        HashMap<String,String> token = new HashMap<>();
        token.put("token",tokenGeneratorService.token(rut));
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> tokenValidate(String token) {
        HashMap<String,String> result = new HashMap<>();
        result.put("token",tokenValidateService.token(token));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
