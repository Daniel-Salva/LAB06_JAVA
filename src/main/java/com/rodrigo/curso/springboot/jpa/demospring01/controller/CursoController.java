package com.rodrigo.curso.springboot.jpa.demospring01.controller;

import com.rodrigo.curso.springboot.jpa.demospring01.model.entities.Curso;
import com.rodrigo.curso.springboot.jpa.demospring01.services.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Map;

@Controller
@SessionAttributes("curso")
@RequestMapping("/cursos") // Prefijo para todas las rutas
public class CursoController {

    @Autowired
    private CursoService service;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de cursos CJAVA");
        model.addAttribute("cursos", service.listar());
        return "listar";
    }

    @GetMapping("/form")
    public String crear(Map<String, Object> model) {
        Curso curso = new Curso();
        model.put("curso", curso);
        model.put("titulo", "Formulario de curso");
        return "formView";
    }

    @GetMapping("/form/{id}")
    public String editar(@PathVariable Integer id, Map<String, Object> model) {
        Curso curso = null;
        if (id > 0) {
            curso = service.Buscar(id);
        } else {
            return "redirect:/cursos/listar";
        }
        model.put("curso", curso);
        model.put("titulo", "Editar Curso");
        return "formView";
    }

    @PostMapping("/form")
    public String guardar(@Valid Curso curso, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de curso");
            return "formView";
        }
        service.grabar(curso);
        status.setComplete();
        return "redirect:/cursos/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        if (id > 0) {
            service.eliminar(id);
        }
        return "redirect:/cursos/listar";
    }
}