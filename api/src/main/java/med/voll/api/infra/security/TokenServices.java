package med.voll.api.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import med.voll.api.domain.usuario.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenServices {
    @Value("${api.security.token.secrety}")
    private String secret;


    public String gerartoken(Usuario usuario) {
        System.out.println(secret + "Esse é o segredo");
        try {
            var algoritmo = Algorithm.HMAC256(secret);// criação do algotitimo de criptografia
            return JWT.create()
                    .withIssuer("API voll.med")
                    .withSubject(usuario.getLogin())// representa a pessoa proprietária do token
                    .withClaim("id", usuario.getId())
                    .withExpiresAt(dataExpiracao())
                    .sign(algoritmo);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro ao gerar o token JWT", exception);
        }
    }

    public String getSubject(String tokenJWT) {
        try {
            var algoritmo = Algorithm.HMAC256(secret);// criação do algotitimo de criptografia
            return JWT.require(algoritmo)
                    .withIssuer("API voll.med")//método utilizado para especificar o emissor (issuer)
                    .build()
                    .verify(tokenJWT)
                    .getSubject();

        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token JWT inválido ou expirado");
        }

    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(3).toInstant(ZoneOffset.of("-03:00"));
    }
}
