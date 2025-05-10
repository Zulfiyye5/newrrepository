package az.edu.turing.module03.hospital.model;

import az.edu.turing.module03.hospital.exceptions.RoomOccupiedException;
import az.edu.turing.module03.hospital.manager.HospitalManager;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Room {
    private int roomNumber;
    private boolean isOccupied;
    private Patient patient;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        isOccupied = false;
    }

    public void assignPatient(Patient patient) throws RoomOccupiedException {
        if (this.isOccupied) {
            throw new RoomOccupiedException("Room " + this.roomNumber + " is already occupied.");
        }
        this.patient = patient;
        this.isOccupied = true;
    }

    public void clearRoom() {
        isOccupied = false;
        System.out.println("Room is empty");
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    @Override
    public String toString() {

        if (isOccupied && patient != null) {
            return "Room: " + roomNumber + " | " + "Occupied: " + "YES"
                    + " | " +"PatientId: "+ patient.getId();
        } else {
            return "Room: " + roomNumber + " | " + "Occupied: " + "NO";

        }

    }

    public static Room fromString(String line, Patient p) throws RoomOccupiedException {
        String[] infos = line.split("\\|");

        int roomNumber = Integer.parseInt(infos[0].split(":")[1].trim());
        String isOccupied = infos[1].split(":")[1].trim();
        Room room = new Room(roomNumber);
        if (p != null) {
            room.assignPatient(p);
        } else {
            if (infos.length == 3) {

                String patientString = infos[2].split(":")[1].trim();
                for (Patient patient : HospitalManager.patients) {
                    if ( patient.getId().equals(patientString) ) {
                        p = patient;
                    }
                }
                room.assignPatient(p);
            } else {
                room.clearRoom();
            }

        }
        return room;
    }

    public Patient getPatient() {
        return patient;
    }
}
