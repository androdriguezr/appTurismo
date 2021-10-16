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

import com.MisionTic.apirestturisapp.models.entity.Departamento;

import com.MisionTic.apirestturisapp.models.services.IDepartamentoService;
import com.MisionTic.apirestturisapp.models.services.IRegionService;


@CrossOrigin(origins = {"http://localhost:4200", "http://localhost"})
@RestController
@RequestMapping("/api")
public class DepartamentoRestController {

    @Autowired
    private IDepartamentoService deparService;

    @Autowired
    private IRegionService regionService;

    @GetMapping("/departamento/listartodos")
    public List<Departamento> getAllDepartamentos() {
        return deparService.findAll();
    }

    @GetMapping("/departamento/buscarbyid/{id}")
    public Departamento show(@PathVariable Integer id) {
        return deparService.findByID(id);
    }

    @GetMapping("/departamento/buscarbyname/{nombre}")
    public List<Departamento> findByName(@PathVariable String nombre) {
        List<Departamento> resultado = new ArrayList<>();
        List<Departamento> lista = getAllDepartamentos();
        for (Departamento depar : lista) {
            if (depar.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                resultado.add(depar);
            }
        }
        return resultado;
    }

    @PostMapping("/departamento/nuevo/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Departamento create(@RequestBody Departamento departamento, @PathVariable Integer id) {
        departamento.setRegion(regionService.findByID(id));
        System.out.println("EL DEPARTAMENTO ES: " + departamento);
        return deparService.save(departamento);
    }

    @PutMapping("/departamento/actualizar")
    @ResponseStatus(HttpStatus.CREATED)
    public Departamento update(@RequestBody Departamento departamento) {
        return deparService.save(departamento);
    }

    @DeleteMapping("/departamento/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Integer id) {
        deparService.delete(id);
    }

}