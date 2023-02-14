package com.example.curso.springbootform.models.domain;

//import com.example.curso.springbootform.validation.IdentificadorRegex;
import com.example.curso.springbootform.validation.Requerido;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
//import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
//import jakarta.validation.constraints.Pattern;


public class Usuario {
    // [\\d] = identificar un numero de 0-9
    //@Pattern(regexp = "[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")
    //@IdentificadorRegex()
    private  String identificador;
    //@NotEmpty(message = "El nombre no puede estar vacio")
    private String nombre;
    //@NotEmpty
    @Requerido
    private String apellido;
    @NotBlank // no este vacio y no tenga espacio en blanco
    @Size(min =3, max=8, message = "El usuario debe tener entre 3 y 8 caracteres")
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    @Email
    private String email;
    @NotNull // Para integer
    @Min(5)
    @Max(100)
    private Integer cuenta;

    @NotNull
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    //@Past  // fechas pasadas a la actual
    @Future //fechas futuro a la actual
    private Date fechaNacimiento;
    @NotNull
    private Pais pais;

    @NotEmpty
    private List<Rol> roles;

    private Boolean habilitar;

    @NotEmpty
    private String genero;


    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setCuenta(Integer cuenta) {
        this.cuenta = cuenta;
    }
    public Integer getCuenta() {
        return cuenta;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public Boolean getHabilitar() {
        return habilitar;
    }

    public void setHabilitar(Boolean habilitar) {
        this.habilitar = habilitar;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
