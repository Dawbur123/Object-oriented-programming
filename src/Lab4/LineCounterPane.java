package Lab4;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LineCounterPane {
    public static void main(String[] args) throws IOException {
        String fileName = JOptionPane.showInputDialog("Please input name of a file");
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\mamgl\\IdeaProjects\\Programowanie\\src\\Lab4\\"+ fileName));
        int lineNumber = 0;
        while (reader.readLine() != null) {
            lineNumber++;
        }
        System.out.println("Numbers of line of file " + fileName + " is: " + lineNumber);


    }
}
