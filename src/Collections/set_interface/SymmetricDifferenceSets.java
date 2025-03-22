package Collections.set_interface;

import java.util.HashSet;
import java.util.Set;

public class SymmetricDifferenceSets {
    public static Set<Integer> symmetricDifference(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        for (int num : set2) {
            if (!result.add(num)) {
                result.remove(num);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Set.of(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Set.of(3, 4, 5));

        System.out.println("Symmetric Difference: " + symmetricDifference(set1, set2));
    }
}

