package co.edu.uniandes.csw.mueblesdelosalpes.servicios;

import co.edu.uniandes.csw.mueblesdelosalpes.dto.Usuario;
import co.edu.uniandes.csw.mueblesdelosalpes.excepciones.OperacionInvalidaException;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioRegistroMockLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Registro")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RegistroService {

    @EJB
    private IServicioRegistroMockLocal registroEjb;

    @GET
    @Path("usuarios/")
    public List<Usuario> darUsuarios() {
        return registroEjb.darClientes();
    }

    @POST
    @Path("usuario/")
    public void registrarUsuario(Usuario usuario)
            throws OperacionInvalidaException {

        registroEjb.registrar(usuario);
    }

    @PUT
    @Path("{login}")
    public void actualizarCliente(
            @PathParam("login") String login,
            Usuario usuario)
            throws OperacionInvalidaException {

        usuario.setLogin(login);
        registroEjb.actualizarCliente(usuario);
    }

    @DELETE
    @Path("{login}")
    public void eliminarCliente(
            @PathParam("login") String login)
            throws OperacionInvalidaException {

        registroEjb.eliminarCliente(login);
    }
}
