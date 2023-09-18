package org.vet.management.application.port.in;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.vet.management.domain.model.User;

@Path("/users")
public interface ICreateUser {
  /**
   * Este método recibe un objeto tipo User con los datos
   * para guardar en BD un nuevo usuario.
   *
   * @param use Objeto que se va a guardar en la BD.
   * @return El objeto creado.
   */
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  Response postUser(User use);
}
