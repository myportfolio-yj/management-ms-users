package org.vet.management.domain.model;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import org.bson.types.ObjectId;

@MongoEntity(collection="collect-users")
public class UserEntity extends PanacheMongoEntity {
  private ObjectId id;
  private String name;
  private String lastname;
  private String email;
  private String password;
}
