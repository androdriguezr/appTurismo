package com.MisionTic.apirestturisapp.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MisionTic.apirestturisapp.models.dao.IPaisDao;
import com.MisionTic.apirestturisapp.models.entity.Pais;

@Service// esta anotacion, es una anotacion que permite poner esta clase como un servicio a nivel negocio y permite que corra dentro de la clase main
public class PaisServiceImpl implements IPaisService {
	@Autowired
    private IPaisDao paisDao;

    @Override
    @Transactional(readOnly = true)
    public Pais findByID(Integer id) {
        return paisDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pais> findAll() {
        return (List<Pais>) paisDao.findAll();
    }

    @Override
    @Transactional
    public Pais save(Pais pais) {
        return (Pais) paisDao.save(pais);
    }

    @Override
    @Transactional
    public Pais update(Pais pais) {
        return (Pais) paisDao.save(pais);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        paisDao.deleteById(id);
    }

    @Override
    public Pais findByName(String nombre) {
        List<Pais> paises = this.findAll();
        for (Pais pais : paises) {
            if (pais.getNombre().equalsIgnoreCase(nombre)) {
                return pais;
            }
        }
        return null;
    }

}