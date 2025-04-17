package az.edu.turing.module03.happy_family;

public class HappyFamilyDemo {
    public static void main(String[] args) {

        Pet pet1 = new Pet(Species.DOG,"Sirius",3,55,new String[]{"eat"});
        Pet pet2 = new Pet(Species.CAT,"Garfield",2,85,new String[]{"eat, drink, sleep"});

        Human child1 = new Human("Harry","Potter",2002);
        Human mother = new Human("Lily","Potter",1975);
        Human father = new Human("James","Potter",1973);
        Human child2 = new Human("Emma","Potter",2005);
        Family family1 = new Family(mother,father);
        family1.setPet(pet1);
        family1.addChild(child1);
        family1.deleteChild(child2);
        System.out.println(family1);
        mother.setSchedule(DayOfWeek.MONDAY, "bhjbj");
        mother.setSchedule(DayOfWeek.TUESDAY, "hjugjk");
        mother.setSchedule(DayOfWeek.WEDNESDAY, "Gvgh");
        mother.printSchedule();




    }
}
