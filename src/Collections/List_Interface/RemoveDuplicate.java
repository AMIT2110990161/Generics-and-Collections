package Collections.List_Interface;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicate {
    public static void main(String[] args) {
        ArrayList<Integer> li = new ArrayList<>(Arrays.asList(1,6,4,2,1,3,4,6));
        ArrayList<Integer> res = new ArrayList<>();
        for(int a:li){
            if(!res.contains(a))res.add(a);
        }
        System.out.println(res);
    }
}
