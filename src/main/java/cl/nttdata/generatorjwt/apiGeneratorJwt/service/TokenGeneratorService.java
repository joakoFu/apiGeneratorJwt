package cl.nttdata.generatorjwt.apiGeneratorJwt.service;

import org.springframework.stereotype.Service;

@Service
public interface TokenGeneratorService {
    public String token(String rut);
}
