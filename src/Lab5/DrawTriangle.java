package Lab5;

import java.util.Scanner;

public class DrawTriangle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter high of a triangle");
        String input = in.nextLine();

        try {
            int high = Integer.parseInt(input);
            if (high < 2) {
                System.err.println("Triangle cannot be made of this high");
                System.exit(0);
            }
            for (int i = 1; i <= high; i++) {
                System.out.print("_".repeat(high - i));
                System.out.print("#".repeat(2*i-1));
                System.out.printf("_".repeat(high-i)+"%n");
            }


        } catch (NumberFormatException e) {
            System.err.println("Please enter one number!");
        }
    }
}
