package Collections.queue_interface;

import java.util.LinkedList;
import java.util.*;

public class StackUsingQueue {
    public static void main(String[] args) {
        MineStack<Integer> ms = new MineStack<>();
        ms.push(1);
        ms.push(2);
        ms.peek();
        ms.push(3);
        ms.print();
        ms.pop();
        ms.peek();
        ms.print();
        ms.push(4);
        ms.push(5);
        ms.push(6);
        ms.peek();
        ms.print();
        ms.pop();
        ms.print();
    }
}

class MineStack<T>{
    Queue<T> qu1 = new LinkedList<>();
    Queue<T> qu2 = new LinkedList<>();

    public void push(T num){
        qu1.offer(num);
    }

    public T pop(){
        while(qu1.size() > 1){
            qu2.offer(qu1.poll());
        }
        T num = qu1.poll();

        Queue<T> temp = qu1;
        qu1 = qu2;
        qu2 = temp;
        return num;
    }

    public void peek(){
        while(qu1.size() > 1){
            qu2.offer(qu1.poll());
        }
        T num = qu1.poll();
        qu2.offer(num);

        Queue<T> temp = qu1;
        qu1 = qu2;
        qu2 = temp;
        System.out.println(num);
    }

    public void print(){
        System.out.println(qu1);
    }

}
