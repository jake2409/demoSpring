package com.example.demo.config;

import com.example.demo.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

/**
 * Classe utilitária para geração, extração e validação de tokens JWT.
 */
@Component
public class JwtUtil {

    /** Chave secreta usada para assinar o token. */
    private static final String SECRET_KEY = "YRWZmdaSKaDVltzSz4pYtG3dCcJZqqUr!";

    /**
     * Gera um token JWT com base nos dados do usuário.
     *
     * @param usuario Objeto {@link Usuario} que contém o e-mail a ser usado como subject do token
     * @return token JWT assinado e com tempo de expiração de 1 dia
     */
    public String gerarToken(Usuario usuario) {
        Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

        String jwt = Jwts.builder()
            .setSubject(usuario.getEmail())
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 dia
            .signWith(key, SignatureAlgorithm.HS256)
            .compact();

        return jwt;
    }

    /**
     * Extrai o e-mail (subject) do usuário a partir do token.
     *
     * @param token JWT válido
     * @return e-mail do usuário
     */
    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    /**
     * Valida se o token é válido e se não está expirado.
     *
     * @param token JWT a ser validado
     * @return true se for válido e não expirado, false caso contrário
     */
    public boolean validateToken(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8)))
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            return !claims.getExpiration().before(new Date());

        } catch (ExpiredJwtException | SignatureException | IllegalArgumentException e) {
            return false;
        }
    }
}
