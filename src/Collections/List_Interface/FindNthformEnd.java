package Collections.List_Interface;

import java.util.Arrays;
import java.util.LinkedList;

public class FindNthformEnd {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(2,5,6,8,9,4,2));
        int n = 2;
        int num = findNthFromEnd(list, n);
        System.out.println(num);
    }
    static int findNthFromEnd(LinkedList<Integer> list, int n){
        int slow = 0;
        int fast = n;
        try{
            while(list.get(fast) != null){
                slow++;
                fast++;
            }
        }catch (IndexOutOfBoundsException e){
            return list.get(slow);
        }
        return -1;


    }
}
