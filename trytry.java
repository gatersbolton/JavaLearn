package bbb;
import java.util.*;

public class trytry {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue=new PriorityQueue<Integer>();
        queue.add(3);
        queue.add(2);
        queue.add(5);
        queue.add(1);
        queue.add(4);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}