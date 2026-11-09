package com.informaticonfig.spring.app1.springboot_applications.controllers;

import com.informaticonfig.spring.app1.springboot_applications.models.ProductoDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productos")
public class ProductoRestController {

    @PostMapping
    public ProductoDTO recibirProducto(@RequestBody ProductoDTO producto) {
        return producto;
    }
}
