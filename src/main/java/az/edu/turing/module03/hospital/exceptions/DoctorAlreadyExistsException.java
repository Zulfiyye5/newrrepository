package az.edu.turing.module03.hospital.exceptions;

public class DoctorAlreadyExistsException extends Exception{
    public  DoctorAlreadyExistsException(String message){
        super(message);
    }
}
