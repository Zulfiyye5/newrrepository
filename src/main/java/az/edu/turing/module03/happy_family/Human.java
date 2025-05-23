package az.edu.turing.module03.happy_family;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Human {
    private String name;
    private String surname;
    private int yearOfBirth;
    private int IQ;
    private Family family;
    private String[] schedule;

    public Human() {
        this.schedule = new String[7];

    }

    public Human(String name, String surname, int yearOfBirth) {
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
        this.schedule = new String[7];
    }


    public Human(String name, String surname, int yearOfBirth, int IQ, String[] schedule, Family family) {
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
        this.IQ = IQ;
        this.schedule = schedule;
        this.family = family;
    }


    public void greetPet() {
        if (family.getPet() != null && family.getPet().getNickname() != null) {
            System.out.println("Hello, " + family.getPet().getNickname());
        } else {
            System.out.println("I don't have a pet to greet.");
        }
    }

    public void describePet() {
        if (family.getPet() != null) {
            System.out.print("I have an " + family.getPet().getSpecies() + ", it is " + family.getPet().getAge() + " years old, and it is ");
            if (family.getPet().getTrickLevel() >= 50) {
                System.out.println("very sly.");
            } else {
                System.out.println("almost not sly.");
            }
        } else {
            System.out.println("I don't have a pet to describe.");
        }
    }

    public void printSchedule() {
        for (DayOfWeek day : DayOfWeek.values()) {
            String activity = (schedule[day.ordinal()] == null) ? "No activity" : schedule[day.ordinal()];
            System.out.println(day.name() + ": " + activity);
        }
    }


    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", IQ=" + IQ +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getIQ() {
        return IQ;
    }

    public void setIQ(int IQ) {
        if (IQ >= 1 && IQ <= 100) {
            this.IQ = IQ;
        } else {
            throw new IllegalArgumentException("IQ must be between 1 and 100");
        }
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int year) {
        this.yearOfBirth = year;
    }


    public String[] getSchedule() {

        return schedule;
    }

    public void setSchedule(DayOfWeek day, String activity) {
        schedule[day.ordinal()] = activity;
    }

    public void setSchedule(String[] schedule) {
        if (schedule.length != 7) {
            throw new IllegalArgumentException("Error");
        }
        this.schedule = schedule;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return yearOfBirth == human.yearOfBirth &&
                name.equals(human.name) &&
                surname.equals(human.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, yearOfBirth);
    }
}
