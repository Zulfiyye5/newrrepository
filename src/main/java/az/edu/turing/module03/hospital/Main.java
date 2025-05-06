package az.edu.turing.module03.hospital;

import az.edu.turing.module03.hospital.exceptions.*;
import az.edu.turing.module03.hospital.manager.HospitalManager;
import az.edu.turing.module03.hospital.model.*;

import javax.print.Doc;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws IOException, DoctorNotFoundException, PatientNotFoundException, PatientAlreadyExistsException, DoctorAlreadyExistsException, AppointmentAlreadyExistsException, RoomAlreadyExistsException {
        Patient patient1 = new Patient("P001", "Emma", LocalDate.parse("2020-10-10"),
                "Female", "Flu");
        Patient patient2 = new Patient("P002", "Tom", LocalDate.parse("2022-11-12"),
                "Male", "Headache");
        Patient patient3 = new Patient("P003", "Sophia", LocalDate.parse("1995-06-18"), "Female", "Cough");
        Patient patient4 = new Patient("P004", "John", LocalDate.parse("1988-04-25"), "Male", "Flu");
        Patient patient5 = new Patient("P005", "Lily", LocalDate.parse("2000-02-20"), "Female", "Fever");

        Doctor doctor1 = new Doctor("D001", "Jane", LocalDate.of(1980, 5, 12), "Female",
                Specialization.CARDIOLOGIST, LocalDate.of(2010, 6, 1)
        );
        Doctor doctor2 = new Doctor("DOO2", "Mike", LocalDate.of(1979, 03, 03), "Male",
                Specialization.NEUROLOGIST, LocalDate.of(2015, 1, 1));

        Doctor doctor3 = new Doctor("DOO3", "Luna", LocalDate.of(1979, 5, 5), "Female",
                Specialization.PEDIATRICIAN, LocalDate.of(2016, 2, 12));
        Appointment appointment1 = new Appointment("A001", patient1, doctor1,
                LocalDateTime.of(2025, 5, 10, 10, 0), "Checkup");
        Appointment appointment2 = new Appointment("A002", patient2, doctor2,
                LocalDateTime.of(2024, 5, 12, 11, 0), "Some notes.....");
        Appointment appointment3 = new Appointment("A003", patient3, doctor3,
                LocalDateTime.of(2025, 2, 10, 15, 0), "Some notes.....");


        HospitalManager hospitalManager = new HospitalManager();

        hospitalManager.addDoctor(doctor1);
        hospitalManager.addDoctor(doctor2);
        hospitalManager.addDoctor(doctor3);

        hospitalManager.scheduleAppointment(appointment1);

        hospitalManager.addPatient(patient2);
        hospitalManager.addPatient(patient3);
        hospitalManager.addPatient(patient4);
        hospitalManager.addPatient(patient5);

        hospitalManager.addRoom(1);
        hospitalManager.addRoom(2);
        hospitalManager.addRoom(3);
        hospitalManager.addRoom(4);
        hospitalManager.addRoom(5);

        hospitalManager.scheduleAppointment(appointment2);
        hospitalManager.scheduleAppointment(appointment3);


        hospitalManager.savePatientsToFile("src/main/java/az/edu/turing/module03/hospital/data/patients.txt");
        hospitalManager.saveDoctorsToFile("src/main/java/az/edu/turing/module03/hospital/data/doctors.txt");
        hospitalManager.saveRoomsToFile("src/main/java/az/edu/turing/module03/hospital/data/rooms.txt");
        hospitalManager.saveAppointmentsToFile("src/main/java/az/edu/turing/module03/hospital/data/appointments.txt");

        hospitalManager.loadPatientsFromFile("src/main/java/az/edu/turing/module03/hospital/data/patients.txt");

    }
}
