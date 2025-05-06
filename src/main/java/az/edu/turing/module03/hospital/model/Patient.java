package az.edu.turing.module03.hospital.model;

import java.time.LocalDate;
import java.util.Arrays;

public class Patient extends Person {
    private String diagnosis;

    public Patient(String id, String name, LocalDate birthDate, String gender, String diagnosis) {
        super(id, name, birthDate, gender);
        this.diagnosis = diagnosis;
    }

    public String getInfo() {
        return toString();
    }

    @Override
    public String toString() {

        return "ID: " + id + " | " + "Name: " + name + " | " + "Birth: " + birthDate + " | " +
                "Gender: " + gender + " | " + "Diagnosis: " + diagnosis;
    }

    public static Patient fromString(String line) {
        String[] infos = line.split("\\|");
        String id = infos[0].split(":")[1].trim();
        String name = infos[1].split(":")[1].trim();
        LocalDate birthDate = LocalDate.parse(infos[2].split(":")[1].trim());
        String gender = infos[3].split(":")[1].trim();
        String diagnosis = infos[4].split(":")[1].trim();

        return new Patient(id, name, birthDate, gender, diagnosis);
    }

}
