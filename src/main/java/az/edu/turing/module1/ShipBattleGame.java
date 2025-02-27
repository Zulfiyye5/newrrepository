package az.edu.turing.module1;

import java.util.Random;
import java.util.Scanner;

public class ShipBattleGame {

    public static void main(String[] args) {
        Random rand = new Random();
        int targetRow = rand.nextInt(5) + 1;
        int targetCol = rand.nextInt(5) + 1;
        char[][] battleField = new char[6][6];
        prepareField(battleField);

        System.out.println("All set. Get ready to rumble!");
        while(true){

            int row = getInput("Enter row number between 1 and 5: ");
            int column = getInput("Enter column number between 1 and 5: ");
            if(row==targetRow && column==targetCol){
                battleField[row][column]='x';
                System.out.println("You have won!");
                printBattleField(battleField);
                break;
            }
            else {
                if (battleField[row][column] == '-') {
                    battleField[row][column] = '*';
                }
                else{
                    System.out.println("You have already shot at this location!");
                }
                System.out.println("Try again");
            }
            printBattleField(battleField);
        }


    }
    public static void prepareField(char[][] battleField){
        for (int i=0;i<6;i++){
            battleField[0][i] = (char) (i + '0');
        }
        for(int j=0;j<6;j++){
            battleField[j][0] = (char) (j + '0');
        }
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                battleField[i][j] = '-';
            }
        }
    }

    public static  int getInput(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        int value;
        while (true) {

            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                if (value >= 1 && value <= 5) {
                    return value;
                } else {
                    System.out.print(message);
                }
            } else {
                System.out.print("Please enter a numeric value: ");
                scanner.next();
            }
        }

    }
    public static void printBattleField(char[][] battleField){
        for(int i=0;i<battleField.length;i++){
            for (int j=0;j<battleField[0].length;j++){
                System.out.print(battleField[i][j] +" | ");
            }
            System.out.println();
        }

    }


}
