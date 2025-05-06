package az.edu.turing.module03.hospital.exceptions;

public class RoomAlreadyExistsException extends Exception{
    public RoomAlreadyExistsException(String message){
        super(message);
    }
}
