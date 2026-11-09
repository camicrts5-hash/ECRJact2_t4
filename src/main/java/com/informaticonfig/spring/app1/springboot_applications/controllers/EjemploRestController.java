package com.informaticonfig.spring.app1.springboot_applications.controllers;
import com.informaticonfig.spring.app1.springboot_applications.models.Empleados;
import com.informaticonfig.spring.app1.springboot_applications.models.dto.ClaseDTO;

import java.util.Map;
import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;



@RestController 
@RequestMapping ("/api")

public class EjemploRestController {

    @GetMapping(path= "/detalle_info2")
    
    
    public ClaseDTO detalle_info2() {
        ClaseDTO usuario1 = new ClaseDTO();
        usuario1.setTitulo("Adminidtrador");
        usuario1.setUsuario("Erandi Camila");
        /*
        Empleados empleado1 = new Empleados("Juan", "Rodriguez", "Calle 1 No 2", "Gerente", 35, 123456789, 001);

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("Empleado", empleado1);
        */
        

        return usuario1;

    }
    /*
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

     */
    

}
