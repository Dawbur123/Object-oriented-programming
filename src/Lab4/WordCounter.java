package Lab4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WordCounter {
    public static void main(String[] args) {
        try {
            Boolean enableLines = null;
            Boolean enableWords = null;
            Boolean enableChars = null;
            String fileName = null;
            int files = 0;

            if (args.length == 0) {
                System.out.println("No arguments");
                System.exit(0);
            }
            for (String argument : args) {
                if (argument.startsWith("-")) {
                    if (argument.length() == 1) {
                        System.out.println("Invalid argument");
                        System.exit(0);
                    }
                    for (int i = 1; i < argument.length(); ++i) {
                        char c = argument.charAt(i);
                        switch (c) {
                            case 'l':
                                if (enableLines != null) {
                                    System.err.println("Lines enabled more then once");
                                    System.exit(0);
                                }
                                enableLines = true;
                                break;
                            case 'w':
                                if (enableWords != null) {
                                    System.err.println("Words enabled more then once");
                                    System.exit(0);
                                }
                                enableWords = true;
                                break;
                            case 'c':
                                if (enableChars != null) {
                                    System.err.println("Characters enabled more than once");
                                    System.exit(0);
                                }
                                enableChars = true;
                                break;
                            default:
                                System.err.println("Invalid option " + c + "!");
                                return;
                        }
                    }
                } else {
                    if (files == 0) {
                        fileName = argument;
                        files++;
                    } else {
                        System.err.println("Only one file can be processed");
                        System.exit(0);
                    }
                }
            }
            if (enableLines == null && enableWords == null && enableChars == null) {
                enableLines = true;
                enableWords = true;
                enableChars = true;
            }

            int lineCounter = 0;
            int wordCounter = 0;
            int characterCounter = 0;

            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.equals("")) {
                    characterCounter += line.length();
                    String[] words = line.split(" ");
                    wordCounter += words.length;
                }
                lineCounter++;
            }
            if (enableLines != null && enableLines) {
                System.out.println("Lines: " + lineCounter);
            }
            if (enableWords != null && enableWords) {
                System.out.println("Words: " + wordCounter);
            }
            if (enableChars != null && enableChars) {
                System.out.println("Characters: " + characterCounter);
            }

        } catch (FileNotFoundException exception) {
            System.err.println("File does not exist");
        } catch (IOException e) {
            System.err.println("File out of reach");
        } catch (IndexOutOfBoundsException exception) {
            System.err.println("No enough arguments");
        }
    }
}
