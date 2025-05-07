package com.tallerwebi.presentacion;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("datosEnvio") // Mantiene el DTO
public class VentaController {

    @RequestMapping("/vistaVendedor")
    public ModelAndView irAvistaVendedor(){
        ModelMap modelMap = new ModelMap();
        modelMap.put("datosEnvio",new DatosEnvio());
        return new ModelAndView("vistaVendedor",modelMap);
    }

    @RequestMapping("/paso1")
    public ModelAndView irAlPaso2(@ModelAttribute("datosEnvio")DatosEnvio datosEnvio){
        ModelMap modelMap = new ModelMap();
        modelMap.put("datosEnvio",datosEnvio);
        return new ModelAndView("vistaVendedorPaso2",modelMap);
    }

    @RequestMapping("/paso2")
    public ModelAndView irAlPaso3(){

        return new ModelAndView("vistaVendedorPaso3");
    }

    @RequestMapping("/paso3")
    public ModelAndView irAlPaso4(@RequestParam("metodoPago")String metodoPago
            ,@ModelAttribute("datosEnvio")DatosEnvio datosEnvio){
        ModelMap modelMap = new ModelMap();
        modelMap.put("datosEnvio",datosEnvio);
        modelMap.put("precio",7000.0);
        modelMap.put("metodoPago",metodoPago);
        modelMap.put("tiempoEspera",12);

        return new ModelAndView("vistaVendedorPaso4",modelMap);
    }

    /// MOTO:
    @RequestMapping("/vistaMoto")
    public ModelAndView irAvistaMoto(@ModelAttribute("datosEnvio")DatosEnvio datosEnvio){
        ModelMap modelMap = new ModelMap();
        modelMap.put("datosEnvio",datosEnvio);
        return new ModelAndView("vistaMoto",modelMap);
    }

    @RequestMapping("/vistaMiPerfil")
    public ModelAndView irAVistaMiPerfil(){
        ModelMap modelMap = new ModelMap();
        return new ModelAndView("vistaMiPerfil",modelMap);
    }
}
