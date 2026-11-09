package com.informaticonfig.spring.app1.springboot_applications.controllers;

import com.informaticonfig.spring.app1.springboot_applications.models.ProductoDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/tienda")
public class ProductoController {

    @Value("${app.nombre}")
    private String nombreApp;

    private List<ProductoDTO> getListaProductos() {
        return new ArrayList<>(Arrays.asList(
            new ProductoDTO("Laptop HP", 15000.50, "Electrónica"),
            new ProductoDTO("Mouse Inalámbrico", 350.00, "Electrónica"),
            new ProductoDTO("Silla Ergonómica", 3200.00, "Muebles"),
            new ProductoDTO("Escritorio", 4500.00, "Muebles")
        ));
    }

    @GetMapping("/productos")
    public String listarProductos(Model model) {
        model.addAttribute("productos", getListaProductos());
        model.addAttribute("nombreApp", nombreApp); 
        return "tienda/lista"; 
    }

    @GetMapping("/filtrar")
    public String filtrarPorCategoria(@RequestParam(name = "categoria", required = false) String categoria, Model model) {
        List<ProductoDTO> lista = getListaProductos();
        if (categoria != null && !categoria.isEmpty()) {
            lista.removeIf(p -> !p.getCategoria().equalsIgnoreCase(categoria));
        }
        model.addAttribute("productos", lista);
        model.addAttribute("nombreApp", nombreApp);
        return "tienda/lista";
    }

    @GetMapping("/productos/{id}")
    public String detalleProducto(@PathVariable("id") int id, Model model) {
        List<ProductoDTO> lista = getListaProductos();
        if (id >= 0 && id < lista.size()) {
            model.addAttribute("producto", lista.get(id));
            model.addAttribute("nombreApp", nombreApp);
            return "tienda/detalle";
        }
        return "redirect:/tienda/productos";
    }

    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        model.addAttribute("producto", new ProductoDTO());
        model.addAttribute("nombreApp", nombreApp);
        return "tienda/formulario";
    }

    @PostMapping("/guardar")
    public String guardarProducto(@ModelAttribute("producto") ProductoDTO producto, Model model) {
        model.addAttribute("nombreApp", nombreApp);
        return "tienda/resultado";
    }
}