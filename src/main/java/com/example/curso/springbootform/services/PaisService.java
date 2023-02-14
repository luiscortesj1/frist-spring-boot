package com.example.curso.springbootform.services;

import com.example.curso.springbootform.models.domain.Pais;

import java.util.List;

public interface PaisService {

    public List<Pais> listAll ();
    public Pais getById (Integer id);

}
