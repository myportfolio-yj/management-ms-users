package org.vet.management.infraestructure.adapter;
import jakarta.enterprise.context.ApplicationScoped;
import org.mindrot.jbcrypt.BCrypt;
import org.vet.management.application.port.IPasswordEncryption;

@ApplicationScoped
public class PasswordEncryption implements IPasswordEncryption {
  @Override
  public String encryptPassword(String password) {
    return BCrypt.hashpw(password, BCrypt.gensalt());
  }
}
