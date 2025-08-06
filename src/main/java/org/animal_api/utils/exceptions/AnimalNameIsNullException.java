package org.animal_api.utils.exceptions;

public class AnimalNameIsNullException extends IllegalArgumentException {
    public AnimalNameIsNullException(String message) {
        super(message);
    }
}
