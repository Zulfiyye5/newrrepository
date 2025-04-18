package az.edu.turing.module03.happy_family;

public class HappyFamilyDemo {
    public static void main(String[] args) {

        Woman mother = new Woman("Lily", "Potter", 1990);
        Man father = new Man("James", "Potter", 1989);
        Dog dog = new Dog("Sirius");
        mother.setIQ(90);
        father.setIQ(85);
        Family family = new Family(mother, father);
        family.setPet(dog);
        Human child = family.bornChild(father, mother);
        System.out.println(family.countFamily());
        family.addChild(child);
        Human child2 = family.bornChild(father, mother);
        family.addChild(child2);
        System.out.println(family);
        family.deleteChild(child2);
        System.out.println(family);
        System.out.println(family.countFamily());
        System.out.println(dog);
        mother.greetPet();
        father.greetPet();
        child.greetPet();

        mother.setSchedule(DayOfWeek.MONDAY, "Working on the project");
        mother.setSchedule(DayOfWeek.TUESDAY, "Gym");
        mother.setSchedule(DayOfWeek.WEDNESDAY, "Reading books");
        mother.printSchedule();



        Human human1 = new Human("Lily", "Potter", 1990);
        System.out.println(human1.equals(mother));






    }
}
