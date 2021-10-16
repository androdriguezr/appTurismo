package com.MisionTic.apirestturisapp.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.MisionTic.apirestturisapp.models.dao.IRegionDao;

import com.MisionTic.apirestturisapp.models.entity.Region;
@Service /* agregar la clase al contexto del spring*/
public class RegionServiceImp implements IRegionService {
	@Autowired
    private IRegionDao regionDao;

    @Override
    @Transactional(readOnly = true)
    public List<Region> findAll() {
        return (List<Region>) regionDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Region findByID(Integer id) {
        return regionDao.findById(id).orElse(null);
    }

    @Override
    @Transactional()
    public Region save(Region region) {
        return regionDao.save(region);
    }

    @Override
    @Transactional()
    public Region update(Region region) {
        return regionDao.save(region);
    }

    @Override
    @Transactional()
    public void delete(Integer id) {
        regionDao.deleteById(id);
    }

}