package javaStreams;

import java.io.*;

public class ImageByteArray {
    public static void main(String[] args) {
        File inputFile = new File("input.jpg");
        File outputFile = new File("output.jpg");

        try (FileInputStream fis = new FileInputStream(inputFile);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                fos.write(baos.toByteArray());
            }
            System.out.println("Image copied successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
