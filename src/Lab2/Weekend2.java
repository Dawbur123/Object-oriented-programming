package Lab2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Weekend2 {
    public static void main(String[] args) {
        Calendar day = Calendar.getInstance();
        if (day.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || day.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            System.out.println("Weekend");
        } else {
            System.out.println("Dziś jest " + new SimpleDateFormat("EEEE").format(new Date()) + ", do weekendu pozostało: " + (Calendar.SATURDAY - day.get(Calendar.DAY_OF_WEEK)) + " dni.");
        }
    }
}
