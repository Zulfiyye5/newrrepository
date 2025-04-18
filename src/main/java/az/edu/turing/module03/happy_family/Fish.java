package az.edu.turing.module03.happy_family;

public class Fish extends Pet implements Foulable {

    public Fish(String nickname) {
        super(nickname);
        this.setSpecies( Species.FISH);
    }

    public Fish( String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        this.setSpecies( Species.FISH);
    }
    @Override
    public void respond() {
        System.out.println("Hello, owner. I am - fish "+ this.getNickname()+ "I miss you!'");
    }
    @Override
    public void foul() {
        System.out.println("Fish foul");
    }
}
