package com.example.curso.springbootform.services;

import com.example.curso.springbootform.models.domain.Rol;


import java.util.List;

public interface RolService {

    public List<Rol> listAll ();
    public Rol getById(Integer id);
}
