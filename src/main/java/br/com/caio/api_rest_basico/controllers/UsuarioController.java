package br.com.caio.api_rest_basico.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("usuarios")
@RestController
public class UsuarioController {

    private int id;
    private List<Usuario> user = new ArrayList<>();

    @PostMapping("/novo")
    public ResponseEntity<Boolean> NovoUsuario(@RequestBody Usuario usuario) {

        usuario.setId(++id);
        user.add(usuario);
        return ResponseEntity.status(201).body(true);
    }

    @GetMapping("/lista")
    public List<Usuario> getUser() {
        return user;
    }
}
