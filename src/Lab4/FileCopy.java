package Lab4;

import java.io.File;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.StandardCopyOption;
import java.nio.file.AccessDeniedException;

public class FileCopy {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Too few arguments, expected two: source and destination");
            return;
        }

        File source = new File(args[0]);
        File destination = new File(args[1]);

        if (!source.exists()) {
            System.err.println("Source doesn't exist or you have no permission to it");
            return;
        }
        if (!source.canRead()) {
            System.err.println("Not enough permission to read this file");
            return;
        }
        if (!source.isFile()) {
            System.err.println("Expected source to be a file");
            return;
        }
        if (destination.isDirectory()) {
            destination = new File(destination, source.getName());
        }

        try {
            Files.copy(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (AccessDeniedException e) {
            System.err.println("Missing permission to " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Something went wrong " + e.getClass().getName());
        }
    }
}