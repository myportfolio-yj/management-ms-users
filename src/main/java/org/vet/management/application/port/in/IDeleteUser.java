package org.vet.management.application.port.in;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")
public interface IDeleteUser {
  /**
   * Este método elimina un usuario buscándola por su ID.
   *
   * @param idUser Entero con el identificador del usuario en DB.
   * @return El objeto eliminado.
   */
  @DELETE
  @Path("/{idUser}")
  @Produces(MediaType.APPLICATION_JSON)
  Response deleteUser(@PathParam("idUser") String idUser);
}
