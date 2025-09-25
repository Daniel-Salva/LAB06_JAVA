package com.rodrigo.curso.springboot.jpa.demospring01.model.dao;

import com.rodrigo.curso.springboot.jpa.demospring01.model.entities.Curso;
import org.springframework.data.repository.CrudRepository;

public interface CursoRepository extends CrudRepository<Curso,Integer> {

}
