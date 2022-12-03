package Lab5;

import java.util.Scanner;

public class DrawSquare {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter how long side of a square is");
        String input = in.nextLine();

        try {
            int sideOfSquare = Integer.parseInt(input);
            if (sideOfSquare <= 0) {
                System.err.println("Please enter positive number!");
            }
            System.out.println("#".repeat(sideOfSquare));
            for (int i = 1; i <= sideOfSquare-2; i++) {
                System.out.print("#");
                System.out.print("_".repeat(sideOfSquare-2));
                System.out.printf("#%n");
            }
            System.out.println("#".repeat(sideOfSquare));

        } catch (NumberFormatException e) {
            System.err.println("Please enter one number!");
        }
    }
}
