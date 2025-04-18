package az.edu.turing.module03.happy_family;

public class Dog extends Pet  implements Foulable {


    public Dog(String nickname) {
        super(nickname);
        this.setSpecies( Species.DOG);

    }

    public Dog( String nickname, int age, int trickLevel, String[] habits) {
        super( nickname, age, trickLevel, habits);
        this.setSpecies( Species.DOG);
    }
    @Override
    public void respond() {
        System.out.println("Hello, owner. I am - dog "+ this.getNickname()+ "I miss you!'");
    }
    @Override
    public void foul() {
        System.out.println("Dog foul");

    }
}
