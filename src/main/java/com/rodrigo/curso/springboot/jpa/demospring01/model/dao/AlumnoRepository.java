package com.rodrigo.curso.springboot.jpa.demospring01.model.dao;

import com.rodrigo.curso.springboot.jpa.demospring01.model.entities.Alumno;
import org.springframework.data.repository.CrudRepository;

public interface AlumnoRepository extends CrudRepository<Alumno,Integer> {
}
