package com.example.curso.springbootform.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

@Component
public class TiempoTranscurridoInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(TiempoTranscurridoInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("TiempoTranscurrido: preHandle() entrando..." );
        logger.info("Interceptando:"+ handler);
        // Tiempo de inicio
        long tiempoInicio= System.currentTimeMillis();
        request.setAttribute("tiempoInicio",tiempoInicio);

        Random random = new Random();
        Integer demora = random.nextInt(500);
        Thread.sleep(demora);
        return true;
    }

    //TODO ModelAndView : permite pasar datos a la vista
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {


        // Tiempo de final
        long tiempoFinal= System.currentTimeMillis();
        // cast
        long tiempoInicio= (Long) request.getAttribute("tiempoInicio");
        long tiempoTranscurrido = tiempoFinal - tiempoInicio;

        if(modelAndView != null) {
            // TODO , Guardar tiempoTranscurrido en la vista
            modelAndView.addObject("tiempoTranscurrido", tiempoTranscurrido);
        }
        logger.info("TiempoTranscurrido: "+tiempoTranscurrido + " miliseconds");
        logger.info("TiempoTranscurrido: postHandle() saliendo...");
    }
}
