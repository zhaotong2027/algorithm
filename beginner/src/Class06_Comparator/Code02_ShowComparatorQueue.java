package Class06_Comparator;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Code02_ShowComparatorQueue {
    public static void main(String[] args) {
//        // 队列后入先出
////        PriorityQueue<Integer> heap = new PriorityQueue<>();
//        PriorityQueue<Integer> heap = new PriorityQueue<>(new MyComparator());
//        heap.add(6);
//        heap.add(2);
//        heap.add(3);
//        heap.add(1);
//        heap.add(7);
//        System.out.println(heap.peek());
//        heap.add(0);
//        System.out.println(heap.peek());
//
//        while (!heap.isEmpty()) {
//            System.out.print(heap.poll() + " ");
//        }
//        System.out.println();

        Student s1 = new Student("张三", 5, 27);
        Student s2 = new Student("李四", 1, 17);
        Student s3 = new Student("王五", 4, 29);
        Student s4 = new Student("赵六", 3, 9);
        Student s5 = new Student("左七", 2, 34);
        PriorityQueue<Student> heap = new PriorityQueue<>(new IdComparator());
        heap.add(s1);
        heap.add(s2);
        heap.add(s3);
        heap.add(s4);
        heap.add(s5);
        while (!heap.isEmpty()) {
            Student s = heap.poll();
            System.out.print(s.id + "，" + s.name + "  ");
        }
        System.out.println();

        // 类似有序结构都可以这样用 TreeMap，TreeSet
        TreeSet<Student> treeSet = new TreeSet<>(new IdComparator());
        treeSet.add(s1);
        treeSet.add(s2);
        treeSet.add(s3);
        treeSet.add(s4);
        treeSet.add(s5);
        for (Student s : treeSet) {
            System.out.print(s.id + "，" + s.name + "  ");
        }
        System.out.println();

        // String 类型按照字典序比较，在字典中的先后顺序
        // 长度一样按照ascii码顺序，长度不一样的，短的后面补成ascii最小的，再比较
        String a = "abc";
        String b = "a";
        System.out.println(a.compareTo(b));
    }

    // id 升序/降序
    public static class IdComparator implements Comparator<Student> {
        // 返回正数 o1 在前
        // 返回负数 o2 在前
        // 返回0 两数相等
        @Override
        public int compare(Student o1, Student o2) {
            if (o1.id > o2.id) {
                return -1;
            } else if (o1.id == o2.id) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    // 降序
    public static class MyComparator implements Comparator<Integer> {
        // 返回正数，第一个数在前
        // 返回负数，第二个数在前
        // 返回0，则两数相等，谁都一样
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 > o2) {
                return -1;
            } else if (o1 == o2) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public static class Student {
        public String name;
        public int id;
        public int age;

        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }
}
