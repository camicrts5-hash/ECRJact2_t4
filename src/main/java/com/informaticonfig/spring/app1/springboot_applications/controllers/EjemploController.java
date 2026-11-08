package com.informaticonfig.spring.app1.springboot_applications.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller 
public class EjemploController {

    @GetMapping("/detalle_info")
    
    public String info(Model model) {
        model.addAttribute("Titulo","Servidor en linea RJEC");
        model.addAttribute("Servidor","Informaticonfig");
        model.addAttribute("Ip","192.168.1.1");

        return "detalle_info";
    }

}
