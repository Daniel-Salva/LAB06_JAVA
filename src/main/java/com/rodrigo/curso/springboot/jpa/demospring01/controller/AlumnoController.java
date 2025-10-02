package com.rodrigo.curso.springboot.jpa.demospring01.controller;

import com.rodrigo.curso.springboot.jpa.demospring01.model.entities.Alumno;
import com.rodrigo.curso.springboot.jpa.demospring01.services.AlumnoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Map;

@Controller
    @SessionAttributes("alumno")
@RequestMapping("/alumno")
public class AlumnoController {

    @Autowired
    private AlumnoService  alumnoService;

    @GetMapping("/listarAlumno")
    public String listar(Model model) {
        model.addAttribute("titulo", "Lista de Alumnos");
        model.addAttribute("Alumnos", alumnoService.listar());
        return "listarAlumno";
    }

    @GetMapping("/form")
    public String form(Map<String, Object> model) {
        Alumno alumno = new Alumno();
        model.put("alumno", alumno);
        model.put("titulo", "Formulario de Alumno");
        return "formViewAlumno";
    }

    @GetMapping("/form/{id}")
    public String editar(@PathVariable Integer id, Map<String, Object> model) {
        Alumno alumno = null;
        if (id > 0) {
            alumno = alumnoService.Buscar(id);
        } else {
            return "redirect:/alumno/listar";
        }
        model.put("alumno", alumno);
        model.put("titulo", "Editar Alumno");
        return "formViewAlumno";
    }

    @PostMapping("/form")
    public String guardar(@Valid Alumno alumno, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de Alumno");
            model.addAttribute("alumno", alumno); // 👈 IMPORTANTE
            return "formViewAlumno";
        }
        alumnoService.grabar(alumno);
        status.setComplete();
        return "redirect:/alumno/listarAlumno";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        if (id > 0) {
            alumnoService.eliminar(id);
        }
        return "redirect:/alumno/listarAlumno";
    }
}
