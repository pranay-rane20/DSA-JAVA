package D13BinaryHeap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ClassRoom {
    static class Student implements Comparable<Student>{
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());

        pq.add(new Student("A",4));
        pq.add(new Student("B",1));
        pq.add(new Student("C",11));
        pq.add(new Student("D",8));

        while(!pq.isEmpty()) {
            System.out.println( STR."\{pq.peek().name} -> \{pq.peek().rank}");
            pq.remove();
        }

    }
}


//(node) idx = 1;
//leftchild = 2i+1;
//rightchild = 2i+2;


//child = x;
//parent = (x-1)/2;