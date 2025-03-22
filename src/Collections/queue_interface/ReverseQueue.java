package Collections.queue_interface;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> qu = new LinkedList<>(Arrays.asList(1,2,3,4,5));
        Stack<Integer> st = new Stack<>();
        while(!qu.isEmpty()){
            st.push(qu.poll());
        }
        while(!st.isEmpty()){
            qu.offer(st.pop());
        }
        System.out.println(qu);
    }
}
