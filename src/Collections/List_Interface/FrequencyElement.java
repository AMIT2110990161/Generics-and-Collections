package Collections.list_Interface;

import java.util.*;

public class FrequencyElement {
    public static void main(String[] args) {
        List<String> li = Arrays.asList("apple", "banana", "apple", "orange");
        HashMap<String, Integer> freq = new HashMap<>();

        // Corrected loop
        for (String i : li) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }

        // Printing frequency of each element
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            System.out.println(entry.getKey() + " appears " + entry.getValue() + " times");
        }
    }
}
