package org.vet.management.infraestructure.adapter.out;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.bson.types.ObjectId;
import org.vet.management.application.port.out.IUserRepository;
import org.vet.management.domain.model.User;
import org.vet.management.domain.model.UserEntity;

import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class UserRepository implements PanacheMongoRepository<UserEntity>, IUserRepository {
  @Override
  public List<User> getAllUsers() {
    return listAll().stream().map(p -> {
      User user = new User();
      user.setId(p.id.toString());
      user.setName(p.name);
      user.setLastname(p.lastname);
      user.setEmail(p.email);
      user.setPassword(p.password);
      return user;
    }).toList();
  }

  @Override
  public User getUserById(String id) {
    UserEntity userEntity = findById(new ObjectId(id));
    if (Objects.isNull(userEntity)){
      return new User();
    }
    User user = new User();
    user.setId(userEntity.id.toString());
    user.setName(userEntity.name);
    user.setLastname(userEntity.lastname);
    user.setEmail(userEntity.email);
    user.setPassword(userEntity.password);
    return user;
  }

  @Override
  public User createUser(User user) {
    UserEntity userEntity = new UserEntity();
    userEntity.setName(user.name);
    userEntity.setLastname(user.lastname);
    userEntity.setEmail(user.email);
    userEntity.setPassword(user.password);
    userEntity.persist();
    User user2 = new User();
    user2.setId(userEntity.id.toString());
    user2.setName(userEntity.name);
    user2.setLastname(userEntity.lastname);
    user2.setEmail(userEntity.email);
    user2.setPassword(userEntity.password);
    return user2;
  }

  @Override
  public User updateUser(String id, User user) {
    UserEntity userEntity = findById(new ObjectId(id));
    userEntity.name = user.getName();
    userEntity.lastname = user.getLastname();
    userEntity.email = user.getEmail();
    userEntity.password = user.getPassword();
    update(userEntity);
    UserEntity userEntity2 = findById(new ObjectId(id));
    if (Objects.isNull(userEntity2)){
      return new User();
    }
    User user2 = new User();
    user2.setId(userEntity.id.toString());
    user2.setName(userEntity.name);
    user2.setLastname(userEntity.lastname);
    user2.setEmail(userEntity.email);
    user2.setPassword(userEntity.password);
    return user2;
  }

  @Override
  public User deleteUser(String id) {
    UserEntity userEntity = findById(new ObjectId(id));
    delete(userEntity);
    User user = new User();
    user.setId(userEntity.id.toString());
    user.setName(userEntity.name);
    user.setLastname(userEntity.lastname);
    user.setEmail(userEntity.email);
    user.setPassword(userEntity.password);
    return user;
  }
}
