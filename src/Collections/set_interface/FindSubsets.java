package Collections.set_interface;

import java.util.Set;
import java.util.HashSet;

public class FindSubsets {
    public static boolean isSubset(Set<Integer> subset, Set<Integer> superset) {
        for (int num : subset) {
            if (!superset.contains(num)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Set.of(2, 3));
        Set<Integer> set2 = new HashSet<>(Set.of(1, 2, 3, 4));

        System.out.println("Is set1 a subset of set2? " + isSubset(set1, set2));
    }
}

