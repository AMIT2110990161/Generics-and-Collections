package Collections.map_interface;

import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) throws IOException {
        String text = "Hello world, hello Java!";
        text = text.replaceAll("[^a-zA-Z ]", "").toLowerCase();
        String[] words = text.split(" ");

        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        System.out.println(frequencyMap);
    }
}

