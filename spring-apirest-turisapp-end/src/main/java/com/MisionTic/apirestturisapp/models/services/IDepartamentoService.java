package com.MisionTic.apirestturisapp.models.services;

import java.util.List;

import com.MisionTic.apirestturisapp.models.entity.Departamento;

public interface IDepartamentoService {
	
	   public List<Departamento> findAll();

	    public Departamento findByID(Integer id);

	    //public Departamento findByName(String nombreDepartamento);
	    public Departamento save(Departamento departamento);

	    public Departamento update(Departamento departamento);

	    public void delete(Integer id);

}
