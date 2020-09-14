package br.com.prova.dataprev.demo.config;

import br.com.prova.dataprev.demo.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${prova.jwt.expiration}")
    private String expiration;

    @Value("${prova.jwt.secret}")
    private String secret;

    public String buildtoken(Authentication authenticate) {

        Date today = new Date();
        Date dateExpired = new Date(today.getTime() + Long.parseLong(expiration));

        User user = (User) authenticate.getPrincipal();
        return Jwts.builder().setIssuer("Api Prova").setSubject(user.getId().toString()).setIssuedAt(today).setExpiration(dateExpired).signWith(SignatureAlgorithm.HS256,secret).compact();
    }

    public boolean isTokenValido(String token) {
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Long getIdUsuario(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }
}
