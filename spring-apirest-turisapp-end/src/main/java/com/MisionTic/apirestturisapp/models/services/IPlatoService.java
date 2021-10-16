package com.MisionTic.apirestturisapp.models.services;

import java.util.List;


import com.MisionTic.apirestturisapp.models.entity.Plato;

public interface IPlatoService {
	
	   public List<Plato> findAll();

	    public Plato findByID(Integer id);

	    //public Departamento findByName(String nombreDepartamento);
	    public Plato save(Plato plato);

	    public Plato update(Plato plato);

	    public void delete(Integer id);

}
