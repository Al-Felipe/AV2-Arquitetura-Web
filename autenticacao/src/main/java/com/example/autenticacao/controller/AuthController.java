package com.example.autenticacao.controller;

import com.example.autenticacao.model.LoginRequest;
import com.example.autenticacao.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        String token = authService.generateToken(request.getUsername());
        return token;
    }

    @GetMapping("/username/{token}")
    public String extractUsername(@PathVariable String token) {
        String username = authService.extractUsername(token);
        return username;
    }

    // Somente o administrador irá acessar
    @Secured("ADMIN")
    @GetMapping("/admin/user")
    public String onlyAdmin(Authentication authentication) {
        return "Admin " + authentication.getName() + " pode administrar os usuários";
    }

    // Somente o gerente irá acessar
    @Secured("GERENTE")
    @GetMapping("/gerente/produtos")
    public String onlyGerente(Authentication authentication) {return "Gerente responsável pelos produtos: " + authentication.getName();}

    // Somente o vendedor irá acessar
    @Secured("VENDEDOR")
    @GetMapping("/vendedor/pedidos")
    public String onlyVendedor(Authentication authentication){return "Vendedor responsável pelos pedidos: " + authentication.getName();}

    // Somente o cliente irá acessar
    @GetMapping("/cliente/produtos")
    public String getCliente(Authentication authentication){return "Olá " + authentication.getName() + " de uma olhada no nosso catalago... ";}

}
