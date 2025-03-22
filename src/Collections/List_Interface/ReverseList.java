package Collections.list_Interface;

import java.util.*;

public class ReverseList {
    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(1,2,3,4,5);
        System.out.println("before reverse : " + li);
        List<Integer> temp = reverseList(li);
        System.out.println("After reverse : " + temp);
    }

    static List<Integer> reverseList(List<Integer> li){
        int len = li.size()-1;
        List<Integer> temp = new ArrayList<>();
        for(int i=len; i>=0; i--){
            temp.add(li.get(i));
        }
        return temp;
    }
}


