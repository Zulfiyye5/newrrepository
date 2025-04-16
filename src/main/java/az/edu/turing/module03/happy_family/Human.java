package az.edu.turing.module03.happy_family;

import java.util.Random;

public class Human {
    private String name;
    private String surname;
    private int yearOfBirth;
    private  int IQ;
    private Pet pet;
    private Human mother;
    private Human father;
    private String[][] schedule;
    public Human(){


    }

    public Human(String name, String surname, int yearOfBirth) {
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;

    }

    public Human(String name, String surname, int yearOfBirth, Human father, Human mother) {
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
        this.mother = mother;
        this.father = father;

    }


    public Human(String name, String surname, int yearOfBirth, int IQ, Pet pet, Human mother, Human father, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
        this.IQ = IQ;
        this.pet = pet;
        this.mother = mother;
        this.father = father;
        this.schedule = schedule;
    }

    public void greetPet() {
        if (pet != null && pet.getNickname() != null) {
            System.out.println("Hello, " + pet.getNickname());
        } else {
            System.out.println("I don't have a pet to greet.");
        }
    }

    public void describePet() {
        if (pet != null) {
            System.out.print("I have an " + pet.getSpecies() + ", it is " + pet.getAge() + " years old, and it is ");
            if (pet.getTrickLevel() >= 50) {
                System.out.println("very sly.");
            } else {
                System.out.println("almost not sly.");
            }
        } else {
            System.out.println("I don't have a pet to describe.");
        }
    }
    public boolean feedPet(boolean isTimeToFeed) {
        if(pet!=null){
            boolean willFeed;

            if (isTimeToFeed) {
                willFeed = true;
            } else {
                Random random = new Random();
                int randomNumber = random.nextInt(101);
                willFeed = pet.getTrickLevel() > randomNumber;
            }

            if (willFeed) {
                System.out.println("Hm... I will feed " + name + "'s " + pet.getNickname());
            } else {
                System.out.println("I think " + name + " is not hungry.");
            }

            return willFeed;
        }
        else{
            System.out.println(this.name +" doesn't have a pet to feed.");
            return  false;
        }

    }
    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + yearOfBirth +
                ", IQ=" + IQ +
                ", pet=" + (pet != null ? pet.toString() : "null") +
                ", mother=" + (mother != null ? mother.getName() + " " + mother.getSurname() : "null") +
                ", father=" + (father != null ? father.getName() + " " + father.getSurname() : "null") +
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
        if(IQ>=1 && IQ<=100){
            this.IQ = IQ;
        }
        else{
            throw new IllegalArgumentException("IQ must be between 1 and 100");
        }
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int year) {
        this.yearOfBirth = year;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public String[][] getSchedule() {
        return schedule;
    }

    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }
}
