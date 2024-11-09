package D13BinaryHeap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PQ {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(5);    //O(log n)
        pq.add(3);
        pq.add(7);
        pq.add(1);
        while (!pq.isEmpty()) {
            System.out.println(pq.peek());  //O(1)
            pq.remove();    //O(log n)
        }
    }
}
