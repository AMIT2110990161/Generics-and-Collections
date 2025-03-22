package Collections.set_interface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class ConvertSetToSortedList {
    public static List<Integer> convertToSortedList(Set<Integer> set) {
        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);
        return sortedList;
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(Set.of(5, 3, 9, 1));
        System.out.println("Sorted List: " + convertToSortedList(set));
    }
}
