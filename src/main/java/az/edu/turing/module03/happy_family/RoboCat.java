package az.edu.turing.module03.happy_family;

public class RoboCat extends Pet implements Foulable {

    public RoboCat(String nickname) {
        super(nickname);
        this.setSpecies(Species.ROBOCAT);
    }

    public RoboCat(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        this.setSpecies(Species.ROBOCAT);
    }

    @Override
    public void respond() {
        System.out.println("Hello, owner. I am - robocat "+ this.getNickname()+ "I miss you!'");
    }

    @Override
    public void foul() {
        System.out.println("Robocat foul");
    }
}