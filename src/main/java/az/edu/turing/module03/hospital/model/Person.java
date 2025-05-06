package az.edu.turing.module03.hospital.model;

import java.time.LocalDate;

public abstract class Person {
    protected String id;
    protected String name;
    protected LocalDate birthDate;
    protected String gender;

    public Person(String id, String name, LocalDate birthDate, String gender) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", gender='" + gender + '\'' +
                '}';
    }

    abstract String getInfo();

    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }


}
