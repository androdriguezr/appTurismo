package com.MisionTic.apirestturisapp.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MisionTic.apirestturisapp.models.dao.IUsuarioDao;
import com.MisionTic.apirestturisapp.models.entity.Usuario;




/**
 *
 * @author SISMACOM
 */
@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private IUsuarioDao dataRepo;
    
    /*@Autowired
    private JpaUtil jpaUtil=new JpaUtil();*/

    

    @Override
    @Transactional(readOnly = true)
    public Usuario findByID(Integer id) {
        return dataRepo.findById(id).orElse(null);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return (List<Usuario>) dataRepo.findAll();
    }

    

    @Override
    @Transactional
    public Usuario save(Usuario u) {
        return (Usuario) dataRepo.save(u);
    }

    @Override
    @Transactional
    public Usuario update(Usuario u) {
        return (Usuario) dataRepo.save(u);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        dataRepo.deleteById(id);
    }
/*
    @Override
    public Usuario findUser(String nombreUsuario) {
        return jpaUtil.findByName(nombreUsuario);
    }*/

    

}
