package com.example.curso.springbootform.services;

import com.example.curso.springbootform.models.domain.Pais;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PaisServiceImple implements PaisService {

    private List<Pais> lista;
    public PaisServiceImple() {
        this.lista = Arrays.asList(
                new Pais(1,"ES","España"),
                new Pais(2,"CO","Colombia"),
                new Pais(3,"CH","Chile")
        );
    }

    @Override
    public List<Pais> listAll() {
        return lista;
    }

    @Override
    public Pais getById(Integer id) {
        Pais resultado= null;
        for(Pais pais : this.lista){
            if(id == pais.getId()){
               resultado = pais;
               break;
            }
        }
        return resultado;
    }
}
