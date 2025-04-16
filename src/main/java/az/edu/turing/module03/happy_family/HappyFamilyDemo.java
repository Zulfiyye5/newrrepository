package az.edu.turing.module03.happy_family;

public class HappyFamilyDemo {
    public static void main(String[] args) {

        Pet pet1 = new Pet("dog","Sirius",3,55,new String[]{"eat"});
        Pet pet2 = new Pet("cat","Garfield",2,85,new String[]{"eat, drink, sleep"});
        Pet pet3 = new Pet("cat","Crookshanks",5,95,new String[]{"eat, drink, sleep"});


        Human mother = new Human("Lily","Potter",1985);

        Human father = new Human("James","Potter",1984);

        Human child = new Human("Harry","Potter",2010,father,mother);
        mother.setIQ(80);
        father.setIQ(78);
        child.setIQ(81);
       child.setPet(pet1);
       pet1.getHabits();
       mother.greetPet();
       father.describePet();
        System.out.println(child);
        System.out.println(mother);
        child.describePet();






    }
}
