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
            ModelAndView view = whenNoSeIngresanLosDatos("","");
            thenNoSePuedeIngresar(view, "Debe ingresar la contraseña y el mail");
    }

    private void givenNoExisteUsuarioConEseMailYContraseña() {
    }



    private ModelAndView whenNoSeIngresanLosDatos(String mail, String contra) {
        ControladorLogin controladorLogin = new ControladorLogin();
        ModelAndView view = controladorLogin.irAIniciarSesion(mail, contra);
        return view;

    }

    private void thenNoSePuedeIngresar(ModelAndView view, String mensaje) {
        assertThat(view.getViewName(), equalToIgnoringCase("iniciarSesion"));
        assertThat(view.getModel().get("mensaje").toString(), equalToIgnoringCase(mensaje));
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
        thenNoSePuedeIngresarSiFaltaMail(view, "falta el mail");
    }

    private void thenNoSePuedeIngresarSiFaltaMail(ModelAndView view, String mensaje) {
        assertThat(view.getViewName(), equalToIgnoringCase("iniciarSesion"));
        assertThat(view.getModel().get("error").toString(), equalToIgnoringCase(mensaje));
    }

    private ModelAndView whenSiNoSeIngresaElCorreoNoSePuedeIngresar() {
        ControladorLogin controladorLogin = new ControladorLogin();
        ModelAndView view = controladorLogin.irAIniciarSesion(null,contra);
        return view;
    }


}
