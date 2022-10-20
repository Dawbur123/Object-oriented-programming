package Lab2;

import java.util.Date;

public class Weekend {
    public static void main(String[] args) {
        Date date = new Date();
        int daysToWeekend = 6 - date.getDay();


        if (daysToWeekend <= 0 | date.getDay() == 0) {
            System.out.print("Weekend");
        } else {
            System.out.println("Weekend starts in: " + daysToWeekend + " days");
        }
    }
}
