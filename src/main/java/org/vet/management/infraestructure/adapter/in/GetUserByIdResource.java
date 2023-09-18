package org.vet.management.infraestructure.adapter.in;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.vet.management.application.port.in.IGetUserById;
import org.vet.management.domain.service.UserService;

public class GetUserByIdResource implements IGetUserById {
  @Inject
  UserService userService;
  @Override
  public Response getUserById(String idUser) {
    return Response.ok(userService.getUserById(idUser)).build();
  }
}
