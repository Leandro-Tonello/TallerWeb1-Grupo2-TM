package com.tallerwebi.presentacion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    public ModelAndView irAIniciarSesion(String mail, String contra) {
      ;

        if(mail != null && contra != null) {
            return new ModelAndView("home");
        }
        ModelMap model = new ModelMap();
        model.put("error","faltan campos");

        return new ModelAndView("iniciarSesion", model); }

}

