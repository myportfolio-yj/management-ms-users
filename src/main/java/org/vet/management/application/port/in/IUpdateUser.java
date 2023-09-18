package org.vet.management.application.port.in;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.vet.management.domain.model.User;

@Path("/users")
public interface IUpdateUser {
  /**
   * Este método busca un usuario por ID y lo actualiza
   * con la información del objeto User.
   *
   * @param idUser Entero con el identificador del usuario en DB.
   * @param user Objeto con los datos para actualizar el registro.
   * @return El objeto actualizado.
   */
  @PUT
  @Path("/{idUser}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  Response putUser(@PathParam("idUser") String idUser, User user);
}
