package com.rodrigo.curso.springboot.jpa.demospring01.services;

import com.rodrigo.curso.springboot.jpa.demospring01.model.entities.Alumno;

import java.util.List;

public interface AlumnoService {
    public List<Alumno> listar();
    public void grabar(Alumno alumno);
    public Alumno Buscar(Integer id);
    public void eliminar(Integer id);
}
