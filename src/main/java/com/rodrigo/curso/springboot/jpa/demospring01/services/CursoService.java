package com.rodrigo.curso.springboot.jpa.demospring01.services;

import com.rodrigo.curso.springboot.jpa.demospring01.model.entities.Curso;

import java.util.List;

public interface CursoService {

    public List<Curso> listar();
    public void grabar(Curso curso);
    public Curso Buscar(Integer id);
    public void eliminar(Integer id);
}
