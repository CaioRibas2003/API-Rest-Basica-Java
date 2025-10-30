package br.com.caio.api_rest_basico.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    private int id;
    private List<Usuario> user = new ArrayList<>();

    @PostMapping("/usuarios/novo")
    public boolean NovoUsuario(@RequestBody Usuario usuario) {

        usuario.setId(++id);
        user.add(usuario);
        return true;
    }

    @GetMapping("/usuarios/lista")
    public List<Usuario> getUser() {
        return user;
    }

}
