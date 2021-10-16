package com.MisionTic.apirestturisapp.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.MisionTic.apirestturisapp.models.dao.IPlatoDao;
import com.MisionTic.apirestturisapp.models.entity.Plato;


@Service
public class PlatoServiceImp implements IPlatoService {
	@Autowired
    private IPlatoDao platoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Plato> findAll() {
        return (List<Plato>) platoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Plato findByID(Integer id) {
        return platoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional()
    public Plato save(Plato plato) {
        return platoDao.save(plato);
    }

    @Override
    @Transactional()
    public Plato update(Plato plato) {
        return platoDao.save(plato);
    }

    @Override
    @Transactional()
    public void delete(Integer id) {
        platoDao.deleteById(id);
    }


}
