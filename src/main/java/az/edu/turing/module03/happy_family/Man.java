package az.edu.turing.module03.happy_family;

public final class Man extends Human {
    public Man(String name, String surname, int yearOfBirth) {
        super(name, surname, yearOfBirth);
    }

    @Override
    public void greetPet() {
        if (getFamily().getPet() != null && getFamily().getPet().getNickname() != null) {
            System.out.println("Hey, " + getFamily().getPet().getNickname() + "!");
        } else {
            System.out.println("I don't have a pet to greet.");
        }
    }

    public void repairCar() {
        System.out.println("Repairing my car...");
    }


}
