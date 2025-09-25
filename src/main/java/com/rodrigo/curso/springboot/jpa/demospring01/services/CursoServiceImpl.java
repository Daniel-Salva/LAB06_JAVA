package com.rodrigo.curso.springboot.jpa.demospring01.services;

import com.rodrigo.curso.springboot.jpa.demospring01.model.dao.CursoRepository;
import com.rodrigo.curso.springboot.jpa.demospring01.model.entities.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository dao;

    @Override
    @Transactional(readOnly = false)
    public List<Curso> listar() {
        return (List<Curso>) dao.findAll();
    }

    @Override
    public void grabar(Curso curso) {
        dao.save(curso);
    }

    @Override
    public Curso Buscar(Integer id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        dao.deleteById(id);
    }
}
