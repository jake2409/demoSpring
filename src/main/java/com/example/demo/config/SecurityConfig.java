package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Classe de configuração de segurança da aplicação.
 * Define as regras de autenticação e autorização com Spring Security.
 */
@Configuration
public class SecurityConfig {

    /**
     * Define a cadeia de filtros de segurança HTTP da aplicação.
     *
     * - Libera acesso público às rotas de login e H2 console.
     * - Exige autenticação para qualquer outra requisição.
     * - Adiciona um filtro personalizado de autenticação JWT antes do filtro padrão.
     *
     * @param http Configuração de segurança HTTP
     * @param jwtAuthFilter Filtro personalizado de autenticação JWT
     * @return Objeto {@link SecurityFilterChain} configurado
     * @throws Exception em caso de erro na configuração
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtAuthFilter jwtAuthFilter) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/api/auth/login",
                                "/h2-console/**",
                                "/v3/api-docs/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html"
                        ).permitAll()
                        .anyRequest().authenticated()
                )
                .headers(headers -> headers
                        .frameOptions(frame -> frame.sameOrigin()) // necessário pro H2
                )
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    /**
     * Cria um usuário em memória com papel ADMIN.
     * Utilizado para autenticação de testes e acesso ao sistema.
     *
     * @return {@link UserDetailsService} com um usuário ADMIN
     */
    @Bean
    public UserDetailsService users() {
        UserDetails user = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin123"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    /**
     * Define o encoder de senha utilizado para criptografar senhas com BCrypt.
     *
     * @return {@link PasswordEncoder} que utiliza BCrypt
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
