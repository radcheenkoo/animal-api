package org.animal_api.services.exceptions;

public class EntityIsNullException extends IllegalArgumentException {
  public EntityIsNullException(String message) {
    super(message);
  }
}
