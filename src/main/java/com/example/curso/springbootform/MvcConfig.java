package com.example.curso.springbootform;

import com.example.curso.springbootform.interceptors.TiempoTranscurridoInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// TODO, interfas web mvcConfig

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    // HandleInterceptor
    @Autowired
    private TiempoTranscurridoInterceptor tiempoTranscurridoInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // aplica para todas las rutas
        //registry.addInterceptor(tiempoTranscurridoInterceptor);
        //Ruta determinada
        registry.addInterceptor(tiempoTranscurridoInterceptor).addPathPatterns("/form/**");
    }
}
