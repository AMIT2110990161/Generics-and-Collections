package javaStreams;

import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             FileWriter fw = new FileWriter("user_data.txt")) {
            System.out.print("Enter name: ");
            String name = br.readLine();
            System.out.print("Enter age: ");
            String age = br.readLine();
            System.out.print("Enter favorite programming language: ");
            String language = br.readLine();
            fw.write("Name: " + name + "\nAge: " + age + "\nLanguage: " + language);
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}