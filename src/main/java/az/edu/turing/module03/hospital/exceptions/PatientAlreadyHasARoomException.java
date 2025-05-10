package az.edu.turing.module03.hospital.exceptions;

public class PatientAlreadyHasARoomException extends RuntimeException {
  public PatientAlreadyHasARoomException(String message) {
    super(message);
  }
}
