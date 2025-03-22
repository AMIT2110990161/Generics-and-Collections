package Collections.set_interface;

import java.util.HashSet;
import java.util.Set;

public class CheckIfSetsEqual {
    public static boolean areSetsEqual(Set<Integer> set1, Set<Integer> set2) {
        for(int a:set1){
            if(!set2.contains(a))return false;
        }
        for(int a:set2){
            if(!set1.contains(a))return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Set.of(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Set.of(3, 2, 1));
        System.out.println(areSetsEqual(set1, set2));
    }
}

