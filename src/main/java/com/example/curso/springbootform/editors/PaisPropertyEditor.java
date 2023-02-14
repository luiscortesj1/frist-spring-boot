package com.example.curso.springbootform.editors;

import com.example.curso.springbootform.services.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;
@Component
public class PaisPropertyEditor extends PropertyEditorSupport {
    @Autowired
    private PaisService service;

    @Override
    public void setAsText(String idString) throws IllegalArgumentException {

            try {
                Integer id = Integer.parseInt(idString);
                this.setValue(service.getById(id));
            }catch (Exception e) {
                setValue(null);
            }

    }
}
