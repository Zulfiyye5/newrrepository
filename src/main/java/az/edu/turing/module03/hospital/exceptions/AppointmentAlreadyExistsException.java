package az.edu.turing.module03.hospital.exceptions;

public class AppointmentAlreadyExistsException extends  Exception{
    public AppointmentAlreadyExistsException(String message){
        super(message);
    }
}
