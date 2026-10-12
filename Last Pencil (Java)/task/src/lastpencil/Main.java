
package lastpencil;

import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void printPencil(int number) {
        for (int i = 0; i < number; i++) {
            System.out.print("|");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("How many pencils would you like to use:");

        int count;

        while (true) {
            String input = scanner.nextLine();

            if (!input.matches("[0-9]+")) {
                System.out.println("The number of pencils should be numeric");
                continue;
            }

            try {
                count = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("The number of pencils should be numeric");
                continue;
            }

            if (count == 0) {
                System.out.println("The number of pencils should be positive");
                continue;
            }

            break;
        }

        System.out.println("Who will be the first (John, Jack):");
        String currentPlayer = scanner.nextLine();

        while (!currentPlayer.equals("John") &&
                !currentPlayer.equals("Jack")) {
            System.out.println("Choose between 'John' and 'Jack'");
            currentPlayer = scanner.nextLine();
        }

        while (count > 0) {
            printPencil(count);

            if (currentPlayer.equals("Jack")) {
                System.out.println("Jack's turn:");

                int chose;

                if (count == 1) {
                    chose = 1;
                } else if (count % 4 == 1) {
                    chose = random.nextInt(3) + 1;
                } else if (count % 4 == 0) {
                    chose = 3;
                } else {
                    chose = count % 4 - 1;
                }

                System.out.println(chose);
                count -= chose;

            } else {
                System.out.println("John's turn!");

                while (true) {
                    String choice = scanner.nextLine();

                    if (!choice.equals("1") &&
                            !choice.equals("2") &&
                            !choice.equals("3")) {

                        System.out.println("Possible values: '1', '2' or '3'");
                        continue;
                    }

                    int chose = Integer.parseInt(choice);

                    if (chose > count) {
                        System.out.println("Too many pencils were taken");
                        continue;
                    }

                    count -= chose;
                    break;
                }
            }

            if (currentPlayer.equals("John")) {
                currentPlayer = "Jack";
            } else {
                currentPlayer = "John";
            }
        }

        System.out.println(currentPlayer + " won!");

        scanner.close();
    }
}
