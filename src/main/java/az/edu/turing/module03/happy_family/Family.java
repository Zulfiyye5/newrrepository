package az.edu.turing.module03.happy_family;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Family implements HumanCreator {
    private Human mother;
    private Human father;
    private Pet pet;
    private Human[] children;


    private static final String[] maleNames = new String[]{"Martin", "Oscar", "Daniel", "Ron", "Robert", "Harry", "Dylan"};
    private static final String[] femaleNames = new String[]{"Jane", "Elizabeth", "Anne", "Emma", "Emily", "Alice", "Mary"};


    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new Human[0];
        this.mother.setFamily(this);
        this.father.setFamily(this);
    }

    @Override
    public Human bornChild(Human father, Human mother) {
        Random random = new Random();
        int sex = random.nextInt(2);
        int iq = (father.getIQ() + mother.getIQ()) / 2;
        String name = "";
        int yearOfBirth = LocalDate.now().getYear();

        if (sex == 0) {

            name = maleNames[random.nextInt(maleNames.length)];
            Man man = new Man(name, father.getSurname(), yearOfBirth);
            man.setIQ(iq);
            return man;

        } else {
            name = femaleNames[random.nextInt(femaleNames.length)];
            Woman woman = new Woman(name, father.getSurname(), yearOfBirth);
            woman.setIQ(iq);
            return woman;
        }


    }

    public void addChild(Human child) {
        this.children = Arrays.copyOf(this.children, this.children.length + 1);
        this.children[this.children.length - 1] = child;
        child.setFamily(this);

    }

    public boolean deleteChild(int index) {
        int j = 0;
        if (index < 0 || index >= this.children.length) return false;
        else {
            Human[] newArray = new Human[this.children.length - 1];
            for (int i = 0; i < this.children.length; i++) {
                if (i != index) {
                    newArray[j++] = this.children[i];
                } else {
                    this.children[i].setFamily(null);
                }
            }
            setChildren(newArray);
            return true;
        }

    }

    public boolean deleteChild(Human child) {
        boolean exist = false;
        int j = 0;
        Human[] newArray = new Human[this.children.length - 1];

        for (Human human : this.children) {
            if (!human.equals(child)) {
                if (j >= newArray.length) break;
                newArray[j++] = human;
            } else {
                child.setFamily(null);
                exist = true;
            }
        }

        if (exist) {
            setChildren(Arrays.copyOf(newArray, j));
        }

        return exist;
    }

    public int countFamily() {
        if (pet != null) {
            return 3 + children.length;
        }
        return 2 + children.length;
    }

    public void describePet() {
        if (pet != null) {
            System.out.print("We have an " + pet.getSpecies() + ", it is " + pet.getAge() + " years old, and it is ");
            if (pet.getTrickLevel() >= 50) {
                System.out.println("very sly.");
            } else {
                System.out.println("almost not sly.");
            }
        } else {
            System.out.println("We don't have a pet to describe.");
        }
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Human[] getChildren() {
        return children;
    }

    public void setChildren(Human[] children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Family{" +
                "mother=" + mother +
                ", father=" + father +
                ", pet=" + pet +
                ", children=" + Arrays.toString(children) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(mother, family.mother) && Objects.equals(father, family.father);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father, pet, Arrays.hashCode(children));
    }


}
