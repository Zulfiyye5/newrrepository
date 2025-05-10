package az.edu.turing.module03.hospital.manager;

import az.edu.turing.module03.hospital.exceptions.*;
import az.edu.turing.module03.hospital.model.*;

import javax.print.Doc;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class HospitalManager {
    public static List<Patient> patients = new ArrayList<>();
    public static List<Doctor> doctors = new ArrayList<>();
    public static List<Appointment> appointments = new ArrayList<>();
    public static List<Room> rooms = new ArrayList<>();

    public void addPatient(Patient patient) throws PatientAlreadyExistsException {
        if (findPatientById(patient.getId()) != null) {
            throw new PatientAlreadyExistsException("Patient already exists.");
        }
        patients.add(patient);
        System.out.println("Patient " + patient.getId() + " added");
    }


    public void listAllPatients() {
        for (Patient p : patients) {
            System.out.println(p);
        }
    }

    public void savePatientsToFile(String filePath) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for (Patient p : patients) {
            bufferedWriter.write(p.toString());
            bufferedWriter.newLine();

        }
        bufferedWriter.close();
        System.out.println("Patients saved in patients.txt file");
    }

    public void loadPatientsFromFile(String filePath) throws FileNotFoundException {
        FileReader fileReader = new FileReader(filePath);
        patients.clear();
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> list = bufferedReader.lines().toList();
        for (String line : list) {
            patients.add(Patient.fromString(line));
        }

    }





    public void addDoctor(Doctor doctor) throws DoctorAlreadyExistsException {
        if (findDoctorById(doctor.getId()) != null) {
            throw new DoctorAlreadyExistsException("Doctor already exists.");
        }
        doctors.add(doctor);
        System.out.println("Doctor " + doctor.getId() + " added");
    }



    public void listAllDoctors() {
        for (Doctor c : doctors) {
            System.out.println(c);
        }
    }

    public void saveDoctorsToFile(String filePath) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for (Doctor d : doctors) {
            bufferedWriter.write(d.toString());
            bufferedWriter.newLine();

        }
        bufferedWriter.close();
        System.out.println("Patients saved in doctors.txt file");
    }

    public void loadDoctorsFromFile(String filePath) throws FileNotFoundException {
        FileReader fileReader = new FileReader(filePath);
        doctors.clear();
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> list = bufferedReader.lines().toList();
        for (String line : list) {
            doctors.add(Doctor.fromString(line));
        }

    }


    public void scheduleAppointment(Appointment appointment) throws DoctorNotFoundException, AppointmentAlreadyExistsException {



        boolean patientExists = findPatientById(appointment.getPatient().getId())!=null ;
        boolean doctorExists = findDoctorById(appointment.getDoctor().getId())!=null;
        boolean appointmentExists = findAppointmentByNumber(appointment.getId())!=null;

        if (!patientExists) {
            patients.add(appointment.getPatient());
        }

        if (!doctorExists) {
            throw new DoctorNotFoundException("Doctor " + appointment.getDoctor().getName() + " doesn't' exist in hospital");
        }
        if (appointmentExists) {
            throw new AppointmentAlreadyExistsException("Appointment " + appointment.getId() + " already exists");

        }

        appointments.add(appointment);
        System.out.println("Appointment added");
    }

    public void listAllAppointments() {
        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }

    }

    public void saveAppointmentsToFile(String filePath) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for (Appointment a : appointments) {
            bufferedWriter.write(a.toString());
            bufferedWriter.newLine();

        }
        bufferedWriter.close();
        System.out.println("Appointments saved in appointments.txt file");
    }

    public void loadAppointmentsFromFile(String filePath) throws FileNotFoundException, DoctorNotFoundException, PatientNotFoundException {
        FileReader fileReader = new FileReader(filePath);
        appointments.clear();
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> list = bufferedReader.lines().toList();
        for (String line : list) {
            appointments.add(Appointment.fromString(line, null, null));
        }

    }

    public void addRoom(int roomNumber) throws RoomAlreadyExistsException {

        for (Room r : rooms) {
            if (r.getRoomNumber() == roomNumber) {
                throw new RoomAlreadyExistsException("Room " + roomNumber + " already exists in hospital");
            }
        }


        rooms.add(new Room(roomNumber));
        System.out.println("Room " + roomNumber + " added");
    }

    public void listAvailableRooms() {
        for (Room room : rooms) {
            if (!room.isOccupied()) {
                System.out.println(room);
            }

        }
    }

    public void assignRoomToPatient(int roomNumber, Patient p) throws RoomOccupiedException, PatientNotFoundException {
        Patient patient = findPatientById(p.getId());
        if (patient == null) {
            throw new PatientNotFoundException("Patient " + p.getId() + " doesn't exist in hospital");
        }
        for(Room room:rooms){
            if(room.isOccupied()){
            if(room.getPatient().equals(p)) {
                throw new PatientAlreadyHasARoomException("Patient " + p.getId() + " already assigned to room " + room.getRoomNumber());
            }
            }
        }

        Room room = findRoomByNumber(roomNumber);
        if (room == null) {
            throw new RoomNotFoundException("Room " + roomNumber + " is doesn't exists in hospital.");
        }

        if (room.isOccupied()) {
            throw new RoomOccupiedException("Room " + roomNumber + " is already occupied.");
        }

        room.assignPatient(patient);
        System.out.println("Patient assigned to room " + roomNumber);




    }

    public void saveRoomsToFile(String filePath) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for (Room room : rooms) {
            bufferedWriter.write(room.toString());
            bufferedWriter.newLine();

        }
        bufferedWriter.close();
        System.out.println("Appointments saved in rooms.txt file");
    }

    public void loadRoomsFromFile(String filePath) throws FileNotFoundException, RoomOccupiedException {
        FileReader fileReader = new FileReader(filePath);
        rooms.clear();
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> list = bufferedReader.lines().toList();
        for (String line : list) {
            rooms.add(Room.fromString(line, null));
        }

    }
    private Patient findPatientById(String id) {
        return patients.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    private Doctor findDoctorById(String id) {
        return doctors.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    private Room findRoomByNumber(int roomNumber) {
        return rooms.stream()
                .filter(r -> r.getRoomNumber() == roomNumber)
                .findFirst()
                .orElse(null);
    }

    private Appointment findAppointmentByNumber(String id) {
        return appointments.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElse(null);
    }


}
