package br.com.caio.api_rest_basico.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("usuarios")
@RestController
public class UsuarioController {

    private int id;
    private List<Usuario> users = new ArrayList<>();

    @PostMapping("/novo")
    public ResponseEntity<Boolean> NovoUsuario(@RequestBody Usuario usuario) {

        usuario.setId(++id);
        users.add(usuario);
        return ResponseEntity.status(201).body(true);
    }

    @GetMapping("/lista")
    public List<Usuario> getUsers() {
        return users;
    }

    @PutMapping("/editar")
    public ResponseEntity<Boolean> editarUsuario(@RequestBody Usuario usuario) {

        boolean atualizarUsuario = false;
        int index = 0;

        for (Usuario usuarioAux: users) {

            if (!atualizarUsuario) {
                index++;
            }
            if (usuarioAux.getId() == usuario.getId()) {
                atualizarUsuario = true;
            }
        }

        if (atualizarUsuario) {
            users.set(index - 1, usuario);
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.badRequest().body(false);
        }
    }
}
