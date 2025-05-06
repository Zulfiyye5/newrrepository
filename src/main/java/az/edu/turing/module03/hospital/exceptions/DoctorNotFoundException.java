package az.edu.turing.module03.hospital.exceptions;

public class DoctorNotFoundException extends  Exception{
    public DoctorNotFoundException(String message){
        super(message);
    }
}
