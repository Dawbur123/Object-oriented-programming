package Lab4;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FileAndURLCopy {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Too few arguments, expected two: source and destination");
            return;
        }
        boolean isURLValid;
        try {
            URL url = new URL(args[0]);
            url.toURI();
            isURLValid = true;
        } catch (Exception e) {
            isURLValid = false;
        }

        File source = new File(args[0]);
        File destination = new File(args[1]);
        if (!isURLValid) {
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
        }
        if (destination.isDirectory()) {
            destination = new File(destination, source.getName());
        }
        try {
            if (isURLValid) {
                URL url = new URL(args[0]);
                URLConnection urlC = url.openConnection();
                urlC.connect();
                FileOutputStream os = null;
                try {
                    ReadableByteChannel is = Channels.newChannel(url.openStream());
                    os = new FileOutputStream(destination);
                    os.getChannel().transferFrom(is, 0, Long.MAX_VALUE);
                } finally {
                    os.close();
                }
            } else {
                Files.copy(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            System.err.println("Something went wrong " + e.getClass().getName());
        }

    }

}

