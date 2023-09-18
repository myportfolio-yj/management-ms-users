package org.vet.management.application.port.in;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")
public interface IGetUsers {
  /**
   * Este método debe retornar todos los usuarios que están activos
   *
   * @return Una lista de usuarios.
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  Response getUsers();
}
