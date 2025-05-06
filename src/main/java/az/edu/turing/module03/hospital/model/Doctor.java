package az.edu.turing.module03.hospital.model;

import java.time.LocalDate;

public class Doctor extends Person {
    private Specialization specialization;
    private LocalDate employmentDate;

    public Doctor(String id, String name, LocalDate birthDate, String gender, Specialization specialization, LocalDate employmentDate) {
        super(id, name, birthDate, gender);
        this.specialization = specialization;
        this.employmentDate = employmentDate;
    }

    public String getInfo() {
        return toString();
    }

    @Override
    public String toString() {
        return "ID: " + id + " | " + "Name: " + name + " | " + "Birth: " + birthDate + " | " +
                "Gender: " + gender + " | " + "Specialization: " + specialization
                + " | " + "Employed: " + employmentDate;
    }

    public static Doctor fromString(String line) {
        String[] infos = line.split("\\|");
        String id = infos[0].split(":")[1].trim();
        String name = infos[1].split(":")[1].trim();
        LocalDate birthDate = LocalDate.parse(infos[2].split(":")[1].trim());
        String gender = infos[3].split(":")[1].trim();
        Specialization specialization = Specialization.valueOf(infos[4].split(": ")[1].trim());
        LocalDate employed = LocalDate.parse(infos[5].split(":")[1].trim());

        return new Doctor(id, name, birthDate, gender, specialization, employed);
    }

}
