package org.vet.management.application.port.out;

import org.vet.management.domain.model.User;
import org.vet.management.domain.model.UserEntity;

import java.util.List;

public interface IUserRepository {
  List<User> getAllUsers();
  User getUserById(String id);
  User createUser(User user);
  User updateUser(String id, User user);
  User deleteUser(String id);
}
