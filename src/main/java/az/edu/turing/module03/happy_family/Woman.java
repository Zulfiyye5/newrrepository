package az.edu.turing.module03.happy_family;

public final class Woman extends Human {
    public Woman(String name, String surname, int yearOfBirth) {
        super(name, surname, yearOfBirth);
    }

    @Override
    public void greetPet() {
        if (getFamily().getPet() != null && getFamily().getPet().getNickname() != null) {
            System.out.println("Hello, my dear " + getFamily().getPet().getNickname() + "!");
        } else {
            System.out.println("I don't have a pet to greet.");
        }
    }

    public void makeup() {
        System.out.println("Doing my makeup...");
    }
}
