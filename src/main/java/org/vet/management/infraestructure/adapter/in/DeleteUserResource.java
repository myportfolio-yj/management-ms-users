package org.vet.management.infraestructure.adapter.in;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.vet.management.application.port.in.IDeleteUser;
import org.vet.management.domain.service.UserService;

public class DeleteUserResource implements IDeleteUser {
  @Inject
  UserService userService;
  @Override
  public Response deleteUser(String idUser) {
    return Response.ok(userService.deleteUser(idUser)).build();
  }
}
