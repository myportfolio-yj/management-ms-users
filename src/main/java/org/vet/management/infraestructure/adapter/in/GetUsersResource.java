package org.vet.management.infraestructure.adapter.in;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.vet.management.application.port.in.IGetUsers;
import org.vet.management.domain.service.UserService;

public class GetUsersResource implements IGetUsers {
  @Inject
  UserService userService;
  @Override
  public Response getUsers() {
    return Response.ok(userService.getAllUsers()).build();
  }
}
