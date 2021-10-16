package com.MisionTic.apirestturisapp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.MisionTic.apirestturisapp.models.entity.Plato;
import com.MisionTic.apirestturisapp.models.services.IDepartamentoService;
import com.MisionTic.apirestturisapp.models.services.IPlatoService;


@CrossOrigin(origins = {"http://localhost:4200", "http://localhost"})
@RestController
@RequestMapping("/api")
public class PlatoRestController {
	
	@Autowired
    private IPlatoService platoService;

    @Autowired
    private IDepartamentoService departService;

    @GetMapping("/plato/listartodos")
    public List<Plato> getAllPlatos() {
        return platoService.findAll();
    }

    @GetMapping("/plato/buscarbyid/{id}")
    public Plato show(@PathVariable Integer id) {
        return platoService.findByID(id);
    }

    @GetMapping("/plato/buscarbyname/{nombre}")
    public List<Plato> findByName(@PathVariable String nombre) {
        List<Plato> resultado = new ArrayList<>();
        List<Plato> lista = getAllPlatos();
        for (Plato plato : lista) {
            if (plato.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                resultado.add(plato);
            }
        }
        return resultado;
    }

    @PostMapping("/plato/nuevo/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Plato create(@RequestBody Plato plato, @PathVariable Integer id) {
        plato.setDepartamento(departService.findByID(id));
        System.out.println("EL PLATO ES: " + plato);
        return platoService.save(plato);
    }

    @PutMapping("/plato/actualizar")
    @ResponseStatus(HttpStatus.CREATED)
    public Plato update(@RequestBody Plato plato) {
        return platoService.save(plato);
    }

    @DeleteMapping("/plato/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Integer id) {
        platoService.delete(id);
    }


}
