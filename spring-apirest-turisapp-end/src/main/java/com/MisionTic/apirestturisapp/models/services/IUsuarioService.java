package com.MisionTic.apirestturisapp.models.services;

import java.util.List;

import com.MisionTic.apirestturisapp.models.entity.Usuario;

public interface IUsuarioService {
	public List<Usuario> findAll();

    public Usuario findByID(Integer id);
    
    //public Usuario findUser(String nombreUsuario);

    public Usuario save(Usuario u);

    public Usuario update(Usuario u);

    public void delete(Integer id);

}
