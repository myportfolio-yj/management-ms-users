package org.vet.management.application.port.out;

import org.vet.management.domain.model.User;
import org.vet.management.domain.model.UserEntity;

import java.util.List;

public interface IUserRepository {
  List<UserEntity> getAllUsers();
  UserEntity getUserById(String id);
  UserEntity createUser(User user);
  UserEntity updateUser(String id, User user);
  UserEntity deleteUser(String id);
}
