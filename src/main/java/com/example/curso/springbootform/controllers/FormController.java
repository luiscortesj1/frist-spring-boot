package com.example.curso.springbootform.controllers;

import com.example.curso.springbootform.editors.NombreMayusculaEditor;
import com.example.curso.springbootform.editors.PaisPropertyEditor;
import com.example.curso.springbootform.editors.RolesEditor;
import com.example.curso.springbootform.models.domain.Pais;
import com.example.curso.springbootform.models.domain.Rol;
import com.example.curso.springbootform.models.domain.Usuario;
import com.example.curso.springbootform.services.PaisService;
import com.example.curso.springbootform.services.RolService;
import com.example.curso.springbootform.validation.UsuarioValidador;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.text.SimpleDateFormat;
import java.util.*;


@Controller
@SessionAttributes("usuario") // Para mantener atributos que no están en el formulario
public class FormController {

    @Autowired
    private UsuarioValidador validador;

    @Autowired
    private PaisPropertyEditor paisEditor;

    @Autowired
    private PaisService paisService;

    @Autowired
    private RolesEditor rolesEditor;

    @Autowired
    private RolService rolService;

    @InitBinder//se pasa el validador y valida; se maneja con intercectores
    public void initBinder(WebDataBinder binder){
        binder.addValidators(validador);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false); // convertir la fecha
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));

        //TODO: Class editor propia creada, se hace un nuevo custom editor
        // segundo parametro va el nombre del campo, si se quiere otro campo se hace otro binder
        binder.registerCustomEditor(String.class, "nombre",new NombreMayusculaEditor());


        binder.registerCustomEditor(Pais.class, "pais",paisEditor);
        binder.registerCustomEditor(Rol.class, "roles",rolesEditor);


    }

    //TODO Metodo -ArraysList paises es el nombre que se pasa a la vista
    @ModelAttribute("paises")
    public List<String> paises() {
        // retorna una lista tipo list
        return Arrays.asList("España", "México", "Argentina", "Colombia", "Chile");
    }

    //TODO Metodo - paises es el nombre que se pasa a la vista
    @ModelAttribute("paisesMap")
    public Map<String, String> paisesMap() {
        // retorna una lista tipo list
        Map<String,String> paises = new HashMap<String,String>();
        paises.put("ES", "España");
        paises.put("CO", "Colombia");
        paises.put("MX", "México");
        return paises;
    }


    //TODO Metodo -ArraysList paises es el nombre que se pasa a la vista
    @ModelAttribute("listaPaises")
    public List<Pais> listaPaises() {
        // retorna una lista tipo list
        return paisService.listAll();
    }

    @ModelAttribute("listaRoles")
    public List<String> listaRoles() {
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_ADMIN");
        roles.add("ROLE_USER");
        return roles;
    }
    @ModelAttribute("listarRolesServices")
    public List<Rol> listarRolesServices() {
        return rolService.listAll();
    }

    @ModelAttribute("generos")
    public List<String> genero() {
        return Arrays.asList("Hombre","Mujer");
    }
    @GetMapping("/form")
    public String form(Model model) {
        Usuario usuario = new Usuario();
        usuario.setHabilitar(true);
        model.addAttribute("usuario",usuario);
        return "form";
    }

    @PostMapping("/form")
    /* TODO : Usuario = models;
     *   properties class usuario:
     *   - username, password, email
     *   Validations : @Valid - class usuario
     *   BindingResult: validations result errors, second argument*/

    public String processForm(@Valid Usuario usuario, BindingResult result, Model model) {

      //  validador.validate(usuario,result); // validar de forma explicita

        model.addAttribute("title", "Resultado del form");

        if (result.hasErrors()) {
            return "form";
        }



        return "redirect:/ver";
    }

    @GetMapping("/ver")
    public String ver (@SessionAttribute(name="usuario",required = false) Usuario usuario,Model model, SessionStatus status){
        if(usuario == null){
            return "redirect:/form";
        }
        status.setComplete(); // clean session attributes
        return "resultado";
    }

}
