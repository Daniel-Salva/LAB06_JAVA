package com.rodrigo.curso.springboot.jpa.demospring01.services;

import com.rodrigo.curso.springboot.jpa.demospring01.model.dao.AlumnoRepository;
import com.rodrigo.curso.springboot.jpa.demospring01.model.dao.CursoRepository;
import com.rodrigo.curso.springboot.jpa.demospring01.model.entities.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoServiceImp implements AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;


    @Override
    public List<Alumno> listar() {
        return (List<Alumno>) alumnoRepository.findAll();
    }

    @Override
    public void grabar(Alumno alumno) {
        alumnoRepository.save(alumno);
    }

    @Override
    public Alumno Buscar(Integer id) {
        return alumnoRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        alumnoRepository.deleteById(id);
    }


}
