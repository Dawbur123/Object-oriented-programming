package Lab4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LineCounter {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("No arguments");
            System.exit(0);
        }
        try {
            String fileName = args[0];
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                lineNumber++;
            }
            System.out.println("File " + fileName + " has " + lineNumber + " lines");
        } catch (FileNotFoundException exception) {
            System.out.println("Something went wrong");
        }

    }
}
