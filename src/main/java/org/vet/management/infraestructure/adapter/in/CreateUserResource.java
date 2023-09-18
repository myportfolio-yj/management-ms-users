package org.vet.management.infraestructure.adapter.in;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.vet.management.application.port.in.ICreateUser;
import org.vet.management.domain.model.User;
import org.vet.management.domain.service.UserService;

public class CreateUserResource implements ICreateUser {
  @Inject
  UserService userService;
  @Override
  public Response postUser(User use) {
    return Response.ok(userService.createUser(use)).build();
  }
}
