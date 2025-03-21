package Collections.List_Interface;

import java.util.*;

public class RotateElement {
    public static void main(String[] args) {
        ArrayList<Integer> li = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        int key = 2;
        rev(li, 0, li.size()-1);
        rev(li, 0, key-1);
        rev(li, key, li.size()-1);

        System.out.println(li);

    }

    static void rev(ArrayList<Integer>li, int st, int ed){
        while(st<ed){
            int temp = li.get(st);
            li.set(st, li.get(ed));
            li.set(ed, temp);
            st++;
            ed--;
        }
    }
}
