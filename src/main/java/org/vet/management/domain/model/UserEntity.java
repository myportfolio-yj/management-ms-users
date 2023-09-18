package org.vet.management.domain.model;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import org.bson.types.ObjectId;

@MongoEntity(collection="collect-users")
public class UserEntity extends PanacheMongoEntity {
  public ObjectId id;
  public String name;
  public String lastname;
  public String email;
  public String password;
}
