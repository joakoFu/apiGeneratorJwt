package cl.nttdata.generatorjwt.apiGeneratorJwt.controller;

import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
public interface TokenGenerator {
    @PostMapping(value="/tokenGeneration",consumes = {"application/json"},produces = {"application/json"})
    public ResponseEntity<Object> tokenGeneration(
            @Parameter(description = "rut de  solicitante", required = true)
            @RequestHeader(value = "rut-client")
            String rut);

    @GetMapping(value="/tokenValidator",consumes = {"application/json"},produces = {"application/json"})
    public ResponseEntity<Object> tokenValidate(
            @Parameter(description = "Token generado previamente", required = true)
            @RequestHeader(value = "token")
            String token);
}
