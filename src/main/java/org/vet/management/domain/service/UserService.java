package org.vet.management.domain.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.vet.management.application.port.IPasswordEncryption;
import org.vet.management.application.port.out.IUserRepository;
import org.vet.management.domain.model.User;
import org.vet.management.domain.model.UserEntity;

import java.util.List;

@ApplicationScoped
public class UserService {
  @Inject
  IUserRepository userRepository;
  @Inject
  IPasswordEncryption passwordEncryption;
  public List<User> getAllUsers() {
    return userRepository.getAllUsers();
  }

  public User getUserById(String id) {
    return userRepository.getUserById(id);
  }

  public User createUser(User user) {
    user.setPassword(passwordEncryption.encryptPassword(user.getPassword()));
    return userRepository.createUser(user);
  }

  public User updateUser(String id, User user) {
    user.setPassword(passwordEncryption.encryptPassword(user.getPassword()));
    return userRepository.updateUser(id, user);
  }

  public User deleteUser(String id) {
    return userRepository.deleteUser(id);
  }
}
