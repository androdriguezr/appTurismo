package com.MisionTic.apirestturisapp.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MisionTic.apirestturisapp.models.dao.IDepartamentoDao;

import com.MisionTic.apirestturisapp.models.entity.Departamento;


@Service
public class DepartamentoServiceImp implements IDepartamentoService {
	
	@Autowired
    private IDepartamentoDao deparDao;

    @Override
    @Transactional(readOnly = true)
    public List<Departamento> findAll() {
        return (List<Departamento>) deparDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Departamento findByID(Integer id) {
        return deparDao.findById(id).orElse(null);
    }

    @Override
    @Transactional()
    public Departamento save(Departamento departamento) {
        return deparDao.save(departamento);
    }

    @Override
    @Transactional()
    public Departamento update(Departamento departamento) {
        return deparDao.save(departamento);
    }

    @Override
    @Transactional()
    public void delete(Integer id) {
        deparDao.deleteById(id);
    }

}
