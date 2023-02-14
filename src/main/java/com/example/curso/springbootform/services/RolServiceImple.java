package com.example.curso.springbootform.services;

import com.example.curso.springbootform.models.domain.Rol;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class RolServiceImple implements RolService {

    private List<Rol> roles;

    public RolServiceImple() {
        this.roles= new ArrayList<>();
        this.roles.add( new Rol(1,"ADMIN","ROLE_ADMIN"));
        this.roles.add( new Rol(2,"USUARIO","ROLE_USER"));
    }

    @Override
    public List<Rol> listAll() {
        return roles;
    }

    @Override
    public Rol getById(Integer id) {
        Rol resultado = null;
        for(Rol role : roles) {
            if(id==role.getId()) {
                resultado = role;
                break;
            }
        }
        return resultado;
    }
}
