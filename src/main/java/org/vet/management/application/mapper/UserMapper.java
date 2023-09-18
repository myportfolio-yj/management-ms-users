package org.vet.management.application.mapper;

import org.bson.types.ObjectId;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.vet.management.domain.model.User;
import org.vet.management.domain.model.UserEntity;

@Mapper
public interface UserMapper {
  UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );
  default String map(ObjectId value) {
    return value != null ? value.toString() : null;
  }
  default ObjectId map(String value) {
    return value != null ? new ObjectId(value) : null;
  }
  @Mapping(source = "id", target = "id")
  @Mapping(source = "name", target = "name")
  @Mapping(source = "lastname", target = "lastname")
  @Mapping(source = "email", target = "email")
  @Mapping(source = "password", target = "password")
  User UserEntityToUser(UserEntity userEntity);

  @InheritInverseConfiguration
  UserEntity UserToUserEntity(User user);
}
