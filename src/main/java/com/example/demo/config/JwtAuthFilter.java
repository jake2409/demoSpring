package com.example.demo.config;

import com.example.demo.dao.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * Filtro responsável por interceptar requisições HTTP e validar o token JWT.
 * Se o token for válido e o usuário existir, define a autenticação no contexto do Spring Security.
 */
@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Executa o filtro uma vez por requisição, validando o token JWT presente no header Authorization.
     *
     * @param request     Requisição HTTP
     * @param response    Resposta HTTP
     * @param filterChain Cadeia de filtros
     * @throws ServletException Exceção de servlet
     * @throws IOException      Exceção de I/O
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String path = request.getRequestURI();

        if (
            path.equals("/api/auth/login") ||
            path.startsWith("/h2-console") ||
            path.startsWith("/swagger-ui") ||
            path.startsWith("/v3/api-docs")
        ) {
            filterChain.doFilter(request, response);
            return;
        }

        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.replace("Bearer ", "");
            String email = jwtUtil.getUsernameFromToken(token);

            if (email != null) {
                boolean usuarioExiste = usuarioRepository.findByEmail(email).isPresent();

                if (!usuarioExiste) {
                    response.setStatus(HttpStatus.UNAUTHORIZED.value());
                    response.getWriter().write("Usuário não encontrado");
                    return;
                }

                if (jwtUtil.validateToken(token)) {
                    UserDetails admin = User.withUsername(email)
                            .password("")
                            .roles("ADMIN")
                            .build();

                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(admin, null, admin.getAuthorities());

                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        } else {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.getWriter().write("Token não fornecido");
            return;
        }

        filterChain.doFilter(request, response);
    }
}
