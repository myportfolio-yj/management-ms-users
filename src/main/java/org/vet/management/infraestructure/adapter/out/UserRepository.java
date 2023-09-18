package org.vet.management.infraestructure.adapter.out;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.bson.types.ObjectId;
import org.vet.management.application.mapper.UserMapper;
import org.vet.management.application.port.out.IUserRepository;
import org.vet.management.domain.model.User;
import org.vet.management.domain.model.UserEntity;

import java.util.List;

@ApplicationScoped
public class UserRepository implements PanacheMongoRepository<UserEntity>, IUserRepository {
  @Override
  public List<User> getAllUsers() {
    return listAll().stream().map(UserMapper.INSTANCE::UserEntityToUser).toList();
  }

  @Override
  public User getUserById(String id) {
    return UserMapper.INSTANCE.UserEntityToUser(findById(new ObjectId(id)));
  }

  @Override
  public User createUser(User user) {
    UserEntity userEntity = UserMapper.INSTANCE.UserToUserEntity(user);
    userEntity.persist();
    return UserMapper.INSTANCE.UserEntityToUser(userEntity);
  }

  @Override
  public User updateUser(String id, User user) {
    UserEntity userEntity = findById(new ObjectId(id));
    userEntity.name = user.getName();
    userEntity.lastname = user.getLastname();
    userEntity.email = user.getEmail();
    userEntity.password = user.getPassword();
    persist(userEntity);
    return UserMapper.INSTANCE.UserEntityToUser(userEntity);
  }

  @Override
  public User deleteUser(String id) {
    UserEntity userEntity = findById(new ObjectId(id));
    delete(userEntity);
    return UserMapper.INSTANCE.UserEntityToUser(userEntity);
  }
}
