package med.voll.api.infra.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component// usado para anotar classes genéricas
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenServices tokenServices;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var tokenJWT = recuperarToken(request);
        System.out.println("filtro chamado \n");
        System.out.println(tokenJWT);

        var subject = tokenServices.getSubject(tokenJWT);
        System.out.println(subject);


        filterChain.doFilter(request, response);// chama o próximo filtro
    }


    // Aqui eu faço a recuperação do JWT no cabeçalho
    private String recuperarToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader == null){
            throw new RuntimeException("Token não enviado no cabeçalho no authorization");
        }

        return authorizationHeader.replace("Bearer", "");
    }
}
