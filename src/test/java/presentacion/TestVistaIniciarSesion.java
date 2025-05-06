package presentacion;

import com.tallerwebi.presentacion.ControladorLogin;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class TestVistaIniciarSesion {

    private final String contra ="12345678";
    private final String mail   = "cquipildor4@gmail.com";


    @Test
    public void siNoSeIngresanMailYContraseñaNoSePuedeIngresarYMandaUnMensajeDeError() {
            givenNoExisteUsuarioConEseMailYContraseña();
            ModelAndView view = whenNoSeIngresanLosDatos(null,null);
            thenNoSePuedeIngresar(view);
    }

    private void givenNoExisteUsuarioConEseMailYContraseña() {
    }



    private ModelAndView whenNoSeIngresanLosDatos(String mail, String contra) {
        ControladorLogin controladorLogin = new ControladorLogin();
        ModelAndView view = controladorLogin.irAIniciarSesion(mail, contra);
        return view;

    }

    private void thenNoSePuedeIngresar(ModelAndView view) {
        assertThat(view.getViewName(), equalToIgnoringCase("iniciarSesion"));
        assertThat(view.getModel().get("error").toString(), equalToIgnoringCase("faltan campos"));
    }

    @Test
    public void siSeIngresanElMailYLaContraseñaEnviaAHome(){
        givenExisteElUsuario();
        ModelAndView home = whenSeIngresanLosDatos();
        thenTeEnviaALaVistaDeHome(home);
    }

    private void givenExisteElUsuario() {
    }

    private ModelAndView whenSeIngresanLosDatos() {
        ControladorLogin controladorLogin = new ControladorLogin();
        ModelAndView home = controladorLogin.irAIniciarSesion(mail ,contra);
        return home;
    }

    private void thenTeEnviaALaVistaDeHome(ModelAndView home) {
        assertThat(home.getViewName(), equalToIgnoringCase("home"));


    }

    @Test
    public void siNoSeIngresaElCorreoNoSePuedeIngresar() {
        givenExisteElUsuario();
        ModelAndView view = whenSiNoSeIngresaElCorreoNoSePuedeIngresar();
        thenNoSePuedeIngresarSiFaltaMail(view);
    }

    private void thenNoSePuedeIngresarSiFaltaMail(ModelAndView view) {
        assertThat(view.getViewName(), equalToIgnoringCase("iniciarSesion"));
    }

    private ModelAndView whenSiNoSeIngresaElCorreoNoSePuedeIngresar() {
        ControladorLogin controladorLogin = new ControladorLogin();
        ModelAndView view = controladorLogin.irAIniciarSesion(null,contra);
        return view;
    }


}
