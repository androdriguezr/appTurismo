package com.MisionTic.apirestturisapp.models.services;

import java.util.List;


import com.MisionTic.apirestturisapp.models.entity.Pais;

public interface IPaisService {

	public List<Pais> findAll();

    public Pais findByID(Integer id);
    
    public Pais findByName(String nombre);

    //public Pais findByName(String nombrePais);
    public Pais save(Pais pais);

    public Pais update(Pais pais);

    public void delete(Integer id);
    
}
