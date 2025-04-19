package az.edu.turing.module03.happy_family;

import java.util.Arrays;
import java.util.Objects;

public abstract class Pet {
    private Species species;
    private String nickname;
    private int age;
    private int trickLevel;
    private String[] habits;

    public Pet() {
        this.species = Species.UNKNOWN;
    }


    public Pet(String nickname) {
        this.nickname = nickname;
        this.species = Species.UNKNOWN;
    }

    public Pet(String nickname, int age, int trickLevel, String[] habits) {

        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
        this.species = Species.UNKNOWN;
    }




    @Override
    public String toString() {
        return species.name() + "{" +
                "nickname='" + nickname + '\'' +
                ", age=" + age +
                ", trickLevel=" + trickLevel +
                ", habits=" + Arrays.toString(habits) +
                '}';
    }


    public void eat() {
        System.out.println("I am eating");
    }

    public abstract void respond();

    public void foul() {
        System.out.println("I need to cover it up");
    }


    public String getSpecies() {
        return species.name();
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(int trickLevel) {
        if (trickLevel >= 1 && trickLevel <= 100) {
            this.trickLevel = trickLevel;
        } else {
            throw new IllegalArgumentException("Trick level must be between 1 and 100");
        }

    }

    public String[] getHabits() {
        return habits;
    }

    public void setHabits(String[] habits) {
        this.habits = habits;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age && species == pet.species && Objects.equals(nickname, pet.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, nickname, age);
    }
}
