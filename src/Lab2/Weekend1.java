package Lab2;

import java.util.Date;

public class Weekend1 {
    public static void main(String[] args) {
        Date date = new Date();
        int day = date.getDay();

        switch (day) {
            case 1 -> System.out.print("Monday ");
            case 2 -> System.out.print("Tuesday ");
            case 3 -> System.out.print("Wednesday ");
            case 4 -> System.out.print("Thursday ");
            case 5 -> System.out.print("Friday ");
            default -> System.out.print("Weekend ");
        }
    }
}
