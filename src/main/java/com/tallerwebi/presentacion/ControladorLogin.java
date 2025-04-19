package com.tallerwebi.presentacion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ControladorLogin {


    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public ModelAndView irAHome() {
        return new ModelAndView("home");
    }

    @RequestMapping(path = "/iniciarSesion", method = RequestMethod.GET)
    public ModelAndView irAIniciarSesion() { return new ModelAndView("iniciarSesion"); }

}

