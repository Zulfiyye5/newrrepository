package az.edu.turing.module03.lesson02;

import java.util.Arrays;
import java.util.Collections;

public class ComparableDemo {
    public static void main(String[] args) {
        Player[] players = new Player[]{
                new Player("Hermione", 99),
                new Player("Harry", 80),
                new Player("Ron", 75)
        };
        Arrays.sort(players);
        System.out.println(Arrays.toString(players));


    }

}
