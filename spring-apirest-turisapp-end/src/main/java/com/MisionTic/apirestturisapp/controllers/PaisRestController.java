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

import com.MisionTic.apirestturisapp.models.entity.Pais;
import com.MisionTic.apirestturisapp.models.services.IPaisService;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost"})
@RestController
@RequestMapping("/api")
public class PaisRestController {

    @Autowired
    private IPaisService paisService;

    @GetMapping("/pais/listartodos")
    public List<Pais> getAllPaises() {
        return paisService.findAll();
    }

    @GetMapping("/pais/buscarbyid/{id}")
    public Pais show(@PathVariable Integer id) {
        return paisService.findByID(id);
    }

    @GetMapping("/pais/buscarbyname/{nombre}")
    public List<Pais> findByName(@PathVariable String nombre) {
        //System.out.println("EL NOMBRE PARA BUSCAR ES: " + nombre);
        List<Pais> resultado = new ArrayList<>();
        List<Pais> lista = getAllPaises();
        for (Pais pais : lista) {
            if (pais.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                resultado.add(pais);
            }
        }
        return resultado;
    }

    @PostMapping("/pais/nuevo")
    @ResponseStatus(HttpStatus.CREATED)
    public Pais create(@RequestBody Pais pais) {
        System.out.println("EL PAIS ES: " + pais);
        return paisService.save(pais);
    }

    @PutMapping("/pais/actualizar")
    @ResponseStatus(HttpStatus.CREATED)
    public Pais update(@RequestBody Pais pais) {
        return paisService.save(pais);
    }

    @DeleteMapping("/pais/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Integer id) {
        paisService.delete(id);
    }

}