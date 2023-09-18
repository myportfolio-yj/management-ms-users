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
  public List<UserEntity> getAllUsers() {
    return listAll();
  }

  @Override
  public UserEntity getUserById(String id) {
    return findById(new ObjectId(id));
  }

  @Override
  public UserEntity createUser(User user) {
    UserEntity userEntity = UserMapper.INSTANCE.UserToUserEntity(user);
    userEntity.persist();
    return userEntity;
  }

  @Override
  public UserEntity updateUser(String id, User user) {
    UserEntity userEntity = findById(new ObjectId(id));
    userEntity.name = user.getName();
    userEntity.lastname = user.getLastname();
    userEntity.email = user.getEmail();
    userEntity.password = user.getPassword();
    persist(userEntity);
    return userEntity;
  }

  @Override
  public UserEntity deleteUser(String id) {
    UserEntity userEntity = findById(new ObjectId(id));
    delete(userEntity);
    return userEntity;
  }
}
