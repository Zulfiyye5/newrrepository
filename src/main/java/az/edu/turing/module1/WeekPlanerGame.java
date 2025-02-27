package az.edu.turing.module1;

import java.util.Scanner;

public class WeekPlanerGame {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String[][] scedule = new String[7][2];
        String[] weekdayArray = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        for(int i=0;i<7;i++){
            scedule[i][0] = weekdayArray[i];
            scedule[i][1]= "There is no task for "+weekdayArray[i];
        }
        scedule[0][0] = "Sunday";
        scedule[0][1] = "do home work";
        scedule[1][0] = "Monday";
        scedule[1][1] = "go to courses; watch a film";




        while (true) {

            System.out.print("Please, input the day of the week:   ");
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("exit")) {
                break;
            } else {
                if(input.split(" ")[0].equals("change")){
                    int dayIndex = userInput(input.split(" ")[1]);
                    if(dayIndex!=-1){
                        System.out.print("Please enter new tasks for " + scedule[dayIndex][0] + ": ");
                        String newTasks = scanner.nextLine();
                        scedule[dayIndex][1] = newTasks;
                        System.out.println("Your tasks  for " + scedule[dayIndex][0] + ": " + scedule[dayIndex][1]);
                    }

                    ;
                }
                else{
                    int dayIndex = userInput(input);
                    if (dayIndex != -1) {
                        System.out.println("Your tasks  for " + scedule[dayIndex][0] + ": " + scedule[dayIndex][1]);
                    } else {
                        System.out.println("Sorry, I don't understand you, please try again");
                    }
                }

            }
        }


    }

    public static int userInput(String weekday) {
        return switch (weekday) {
            case "sunday" -> 0;
            case "monday" -> 1;
            case "tuesday" -> 2;
            case "wednesday" -> 3;
            case "thursday" -> 4;
            case "friday" -> 5;
            case "saturday" -> 6;
            default -> -1;
        };
    }









}
