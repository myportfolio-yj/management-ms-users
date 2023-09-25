package org.vet.management.infraestructure.adapter.in;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.vet.management.application.port.in.IUpdateUser;
import org.vet.management.domain.model.User;
import org.vet.management.domain.service.UserService;

public class UpdateUserResource implements IUpdateUser {
  @Inject
  UserService userService;
  @Override
  public Response putUser(String idUser, User user) {
    return Response.ok(userService.updateUser(idUser, user)).build();
  }
}
