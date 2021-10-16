package com.MisionTic.apirestturisapp.models.services;

import java.util.List;

import com.MisionTic.apirestturisapp.models.entity.Pais;
import com.MisionTic.apirestturisapp.models.entity.Region;



public interface IRegionService {
    public List<Region> findAll();

    public Region findByID(Integer id);

    //public Region findByName(String nombreRegion);
    public Region save(Region region);

    public Region update(Region region);

    public void delete(Integer id);

}