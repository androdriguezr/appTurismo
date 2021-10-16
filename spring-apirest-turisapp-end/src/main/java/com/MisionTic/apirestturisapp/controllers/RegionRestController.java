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
import com.MisionTic.apirestturisapp.models.entity.Region;
import com.MisionTic.apirestturisapp.models.services.IPaisService;
import com.MisionTic.apirestturisapp.models.services.IRegionService;


@CrossOrigin(origins = {"http://localhost:4200", "http://localhost"})
@RestController
@RequestMapping("/api")
public class RegionRestController {

    @Autowired
    private IRegionService regionService;

    @Autowired
    private IPaisService paisServ;

    @GetMapping("/region/listartodos")
    public List<Region> getAllRegiones() {
        return regionService.findAll();
    }

    @GetMapping("/region/buscarbyid/{id}")
    public Region show(@PathVariable Integer id) {
        return regionService.findByID(id);
    }

    @GetMapping("/region/buscarbyname/{nombre}")
    public List<Region> findByName(@PathVariable String nombre) {
        List<Region> resultado = new ArrayList<>();
        List<Region> lista = getAllRegiones();
        for (Region region : lista) {
            if (region.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                resultado.add(region);
            }
        }
        return resultado;
    }

    @PostMapping("/region/nuevo/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Region create(@RequestBody Region region, @PathVariable Integer id) {
        Pais p = paisServ.findByID(id);
        region.setPais(p);
        return regionService.save(region);
    }

    @PutMapping("/region/actualizar")
    @ResponseStatus(HttpStatus.CREATED)
    public Region update(@RequestBody Region region) {
        return regionService.save(region);
    }

    @DeleteMapping("/region/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Integer id) {
        regionService.delete(id);
    }

}