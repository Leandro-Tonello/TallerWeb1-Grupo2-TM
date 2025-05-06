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
       ModelMap model = new ModelMap();

        if(contra.isEmpty() && mail.isEmpty()){
            model.put("mensaje", "Debe ingresar la contraseña y el mail");
            return new ModelAndView("iniciarSesion", model);
        }

       if(mail.isEmpty()){
           model.put("mensaje", "Debe ingresar el mail");
           return new ModelAndView("iniciarSesion", model);
       }
       if(contra.isEmpty()){
           model.put("mensaje", "Debe ingresar la comtraseña");
           return new ModelAndView("iniciarSesion", model);
       }


        return new ModelAndView("home"); }

}

