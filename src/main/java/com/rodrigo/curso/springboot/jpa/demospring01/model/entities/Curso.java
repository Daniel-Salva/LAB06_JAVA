package com.rodrigo.curso.springboot.jpa.demospring01.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    @Size(min = 2, max = 30)
    private String nombre;

    @Column
    @Min(0)
    @Max(5)
    private int creditos;

    public Curso() {
    }

    public Curso(Long id, String string, int creditos) {
        this.id = id;
        this.nombre = string;
        this.creditos = creditos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", string='" + nombre +
                ", creditos=" + creditos +
                '}';
    }
}
