package org.vet.management.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
  private String id;
  private String name;
  private String lastname;
  private String email;
  private String password;
}
