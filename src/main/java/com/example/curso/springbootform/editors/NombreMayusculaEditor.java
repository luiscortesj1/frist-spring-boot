package com.example.curso.springbootform.editors;

import java.beans.PropertyEditorSupport;


// Poperties editor
public class NombreMayusculaEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {

        setValue(text.toUpperCase().trim());

    }
}
