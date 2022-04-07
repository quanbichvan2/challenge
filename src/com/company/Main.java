package com.company;
import java.util.Scanner;
public class Main {
    public static int[] random_code(int min , int max, int count){
        int random_code;
        int[] past_random = new int[count];
        boolean status = false;
        for (int i = 0; i < count ; i++) {
            random_code = (int)(Math.random()*((max-min+1)+min));
            past_random[i] = random_code;
            for (int j = 0 ; j < i ; j++) {
                if (random_code == past_random[j]){
                    status = true;
                    break;
                }
            }
            if (status){
                status = false;
                i--;
            }
        }
        return past_random;
    }
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        String[] s1 = {"2+2=", "10-5=", "5*3=", "20/4=", "100-75=","4*7=","8*7","54/9=","99+99=","456-123="};
        String[] s2 = {"4", "5", "15", "5", "25","28","56","6","198","333"};
        int grade = 0;
        boolean mode ;
        while(true) {
            while (true) {
                System.out.print("\nPress 1 to choose The Challenge. \nPress 2 to choose The Check Real.\nYour press: ");
                String mode_choose = input.nextLine();
                if (mode_choose.equals("1")) {
                    System.out.print("Welcome to The Challenge.\n");
                    mode = false;
                    break;
                } else if (mode_choose.equals("2")) {
                    System.out.println("Welcome to The Check Real \n");
                    mode = true;
                    break;
                } else {
                    System.out.print("Please press again to choose. Thank You.\n");
                }
            }
            int[] random = random_code(0, s1.length - 1, s1.length);
            for (int i = 0; i < s1.length; i++) {
                System.out.print("The question " + (i + 1) + " is:" + s1[random[i]]+" Answer: ");
                String answer = input.nextLine().toLowerCase();
                if (answer.equals(s2[random[i]])) {
                    if (!mode) {
                        System.out.print("OK\n");
                    } else {
                        grade++;
                    }
                } else if(!mode) {
                    System.out.print("Again\n");
                    i--;
                }
            }
            if (mode) {
                System.out.println("");
                System.out.println("The total points is: " + grade);

                if (grade == 10) {
                    System.out.println("\nYour grade point are excellent : A++");
                } else if (grade >= 9) {
                    System.out.println("\nYour grade point are excellent : A+");
                } else if (grade >= 8) {
                    System.out.println("\nYour grade point are excellent : A");
                } else if (grade >= 6) {
                    System.out.println("\nYour grade point are excellent : B");
                } else if (grade >= 5) {
                    System.out.println("\nYour grade point are excellent : C");
                } else if (grade >= 4) {
                    System.out.println("Your grade point are excellent : D");
                } else {
                    System.out.println("Your grade point are excellent : F");
                }
            }
        }
    }
}
