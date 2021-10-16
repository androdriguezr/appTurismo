package com.MisionTic.apirestturisapp.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="platos")
public class Plato extends EntidadBase {
	@Column
    private String nombre;
	@Column
    private String descripcion;
    @ManyToOne
    private Departamento departamento;
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento depart) {
        this.departamento = depart;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
	
}
