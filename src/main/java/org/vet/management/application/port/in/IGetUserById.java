package org.vet.management.application.port.in;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")
public interface IGetUserById {
  /**
   * Este método debe retornar un usuario según el ID que le debe llegar como parámetro.
   *
   * @param idUser Identificador del usuario.
   * @return Un usuario.
   */
  @GET
  @Path("/{idUser}")
  @Produces(MediaType.APPLICATION_JSON)
  Response getUserById(@PathParam("idUser") String idUser);
}
