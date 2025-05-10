package az.edu.turing.module03.hospital.model;

import az.edu.turing.module03.hospital.exceptions.DoctorNotFoundException;
import az.edu.turing.module03.hospital.exceptions.PatientNotFoundException;
import az.edu.turing.module03.hospital.manager.HospitalManager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Appointment {
    private String id;
    private Patient patient;
    private Doctor doctor;
    private LocalDateTime dateTime;
    private String note;

    public Appointment(String id, Patient patient, Doctor doctor, LocalDateTime dateTime, String note) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.dateTime = dateTime;
        this.note = note;
    }


    @Override
    public String toString() {
        return "ID: " + id + " | " + "PatientID: " + patient.getId() + " | " + "DoctorID: " + doctor.getId() + " | " +
                "DateTime: " + dateTime + " | " + "Note: " + note;
    }

    public static Appointment fromString(String line, Patient patient, Doctor doctor)
            throws PatientNotFoundException, DoctorNotFoundException {

        String[] infos = line.split("\\|");

        String id = infos[0].split(":")[1].trim();

        if (patient == null) {
            String patientId = infos[1].split(":")[1].trim();
            boolean found = false;
            for (Patient p : HospitalManager.patients) {
                if (Objects.equals(p.getId(), patientId)) {
                    patient = p;
                    found = true;
                    break;
                }
            }
            if (!found) {
                throw new PatientNotFoundException("Patient does not exist");
            }
        }

        if (doctor == null) {
            String doctorId = infos[2].split(":")[1].trim();
            boolean found = false;
            for (Doctor d : HospitalManager.doctors) {
                if (Objects.equals(d.getId(), doctorId)) {
                    doctor = d;
                    found = true;
                    break;
                }
            }
            if (!found) {
                throw new DoctorNotFoundException("Doctor does not exist");
            }
        }

        LocalDateTime dateTime = LocalDateTime.parse(infos[3].split(":")[1].trim());
        String note = infos[4].split(":")[1].trim();

        return new Appointment(id, patient, doctor, dateTime, note);
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
