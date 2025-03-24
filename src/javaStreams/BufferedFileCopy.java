package javaStreams;

import java.io.*;

public class BufferedFileCopy {
    public static void main(String[] args) {
        File sourceFile = new File("largefile.txt");
        File destinationFile = new File("copy.txt");

        long startTime = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationFile))) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            long endTime = System.nanoTime();
            System.out.println("File copied successfully in " + (endTime - startTime) / 1e6 + " ms.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
