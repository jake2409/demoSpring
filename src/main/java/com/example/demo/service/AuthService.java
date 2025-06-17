package com.example.demo.service;

import com.example.demo.config.JwtUtil;
import com.example.demo.dao.UsuarioRepository;
import com.example.demo.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Serviço responsável pela autenticação de usuários.
 * Realiza validação de credenciais e geração de token JWT.
 */
@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtUtil jwtUtil;

    /**
     * Autentica um usuário pelo email e senha.
     *
     * @param email  Email do usuário que deseja autenticar.
     * @param senha  Senha em texto plano para validação.
     * @return Token JWT gerado para o usuário autenticado.
     * @throws RuntimeException Se o usuário não for encontrado ou a senha for inválida.
     */
    public String autenticar(String email, String senha) {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!encoder.matches(senha, usuario.getSenha())) {
            throw new RuntimeException("Senha inválida");
        }

        return jwtUtil.gerarToken(usuario);
    }
}
