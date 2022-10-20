package Lab1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;

public class HelloDate2 {
    public static void main(String[] args){
        System.out.println("Witaj dzisiaj jest: " + new SimpleDateFormat("yyyy.MM.dd - EEEE - HH:mm").format(new Date()));

    }
}
