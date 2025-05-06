package az.edu.turing.module03.hospital.exceptions;

public class PatientAlreadyExistsException extends Exception{
    public PatientAlreadyExistsException(String message){
        super(message);
    }
}
