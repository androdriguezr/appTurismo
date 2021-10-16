package com.MisionTic.apirestturisapp.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.MisionTic.apirestturisapp.models.entity.Usuario;
import com.MisionTic.apirestturisapp.models.services.IUsuarioService;


/**
 *
 * @author SISMACOM
 */
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost"})
@RestController
@RequestMapping("/api")
public class UsuarioRestController {

    @Autowired
    private IUsuarioService usuarioService;
    
    
    @GetMapping("/usuario")
    public List<Usuario> getAllUsers() {
        return usuarioService.findAll();
    }

    @GetMapping("/usuario/{id}")
    public Usuario show(@PathVariable Integer id) {
        return usuarioService.findByID(id);
    }
    
    /*@GetMapping("login/{nombre}")
    public Usuario getUsuario(@PathVariable String nombre) {
        return daoService.findUser(nombre);
    }*/
    

    @PostMapping("/usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario create(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    @PutMapping("/usuario/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario update(@RequestBody Usuario usuario, @PathVariable Integer id) {
        //Usuario usactual=service.findByID(id);
        return usuarioService.save(usuario);

    }

}
