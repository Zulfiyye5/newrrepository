package az.edu.turing.module03.hospital.exceptions;

public class PatientNotFoundException extends Exception{
    public PatientNotFoundException(String message){
        super(message);
    }
}
