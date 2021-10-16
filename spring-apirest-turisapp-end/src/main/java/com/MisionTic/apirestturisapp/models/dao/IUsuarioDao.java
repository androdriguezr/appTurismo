package com.MisionTic.apirestturisapp.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.MisionTic.apirestturisapp.models.entity.Usuario;


/**
 *
 * @author SISMACOM
 */

public interface IUsuarioDao extends CrudRepository<Usuario, Integer> {
}