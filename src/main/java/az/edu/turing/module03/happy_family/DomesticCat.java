package az.edu.turing.module03.happy_family;

public class DomesticCat extends Pet implements Foulable {

    public DomesticCat(String nickname) {
        super(nickname);
        this.setSpecies(Species.CAT);
    }

    public DomesticCat(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        this.setSpecies(Species.CAT);
    }

    @Override
    public void respond() {
        System.out.println("Hello, owner. I am - cat "+ this.getNickname()+ "I miss you!'");
    }

    @Override
    public void foul() {
        System.out.println("Domestic cat foul");
    }
}
