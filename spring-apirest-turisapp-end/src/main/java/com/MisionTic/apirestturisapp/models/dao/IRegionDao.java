package com.MisionTic.apirestturisapp.models.dao;

import org.springframework.data.repository.CrudRepository;


import com.MisionTic.apirestturisapp.models.entity.Region;

public interface IRegionDao extends CrudRepository<Region,Integer> {

	

}
