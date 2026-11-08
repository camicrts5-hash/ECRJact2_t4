package com.informaticonfig.spring.app1.springboot_applications.controllers;

import java.util.Map;
import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController 
public class EjemploRestController {

    @GetMapping("/detalle_info2")
    
    public Map<String, Object> detalle_info2() {
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("Titulo", "Servidor en linea RJEC");
        respuesta.put("Servidor", "Informaticonfig");
        respuesta.put("Ip", "192.168.1.1");

        return respuesta;
    }

    @GetMapping("/mis_materias")

    public String[] misMaterias() {
        return new String[]{
            "Programación Web",
            "Taller de Base de Datos",
            "Fundamentos de Telecomunicaciones",
        };
    }

    @GetMapping("/proyecto")

    public String nombreProyecto() {
        return "Proyecto de RJEC - Actividad Tema 4";
    }

}
