package Lab5;

import java.io.*;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        try {
            String FileStringPath = "C:\\Users\\mamgl\\IdeaProjects\\Programowanie\\src\\Lab5\\conf.properties";
            boolean FileExist = new File(FileStringPath).exists();
            Properties prop = new Properties();

            if (FileExist) {
                FileInputStream fileIn = new FileInputStream(FileStringPath);
                prop.load(fileIn);
            } else {
                FileOutputStream fileOut = new FileOutputStream(FileStringPath);
                prop.setProperty("minValue", "1");
                prop.setProperty("maxValue", "10");
                prop.setProperty("percentage", "70");
                prop.setProperty("minRepeats", "10");
                prop.setProperty("maxRepeats", "25");
                prop.store(fileOut, null);
            }
            double answersCount = 1;
            double correctAnswersCount = 0;
            int givenAnswer = 0;
            double percentageOfCorrectAnswers = 0;
            boolean isLessThanMaxRepeats = true;
            boolean isMoreThanMinRepeats = false;
            boolean isMoreThan70percentage = false;
            Random rand = new Random();
            Scanner scan = new Scanner(System.in);

            while (isLessThanMaxRepeats && !(isMoreThanMinRepeats && isMoreThan70percentage)) {
                System.out.println("Question nr " + (int)answersCount);
                int firstNumber = rand.nextInt(Integer.parseInt(prop.getProperty("maxValue")) - Integer.parseInt(prop.getProperty("minValue"))) + Integer.parseInt(prop.getProperty("minValue"));
                int secondNumber = rand.nextInt(Integer.parseInt(prop.getProperty("maxValue")) - Integer.parseInt(prop.getProperty("minValue"))) + Integer.parseInt(prop.getProperty("minValue"));
                int correctAnswer = firstNumber * secondNumber;

                System.out.println(firstNumber + " * " + secondNumber + " = ?");

                boolean isGoodInput = false;
                while (!isGoodInput) {
                    try {
                        givenAnswer = Integer.parseInt(scan.nextLine());
                        isGoodInput = true;
                    } catch (NumberFormatException e) {
                        System.err.println("Please enter one number");
                        System.out.println("Question nr " + (int)answersCount);
                        System.out.println(firstNumber + " * " + secondNumber + " = ?");
                    }
                }

                if (correctAnswer == givenAnswer) {
                    correctAnswersCount++;
                }

                percentageOfCorrectAnswers = correctAnswersCount / answersCount * 100;
                answersCount++;
                isLessThanMaxRepeats = answersCount <= Integer.parseInt(prop.getProperty("maxRepeats"));
                isMoreThanMinRepeats = answersCount > Integer.parseInt(prop.getProperty("minRepeats"));
                isMoreThan70percentage = percentageOfCorrectAnswers >= Double.parseDouble(prop.getProperty("percentage"));
            }

            System.out.print("Percentage of correct answers: ");
            System.out.printf("%.2f", percentageOfCorrectAnswers);
            System.out.print("%");

        } catch (IOException e) {
            System.err.println("No file");
        } catch (NumberFormatException e) {
            System.err.println("Properties file damaged");
        }
    }
}

