package Class06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 比较器是系统自带的结构
 */
public class Code01_ShowComparator {
    public static void main(String[] args) {
        int[] arr = {8, 1, 4, 1, 6, 8, 4, 1, 5, 82, 3, 0};
        printArray(arr);
        Arrays.sort(arr);
        printArray(arr);

        Student s1 = new Student("张三", 5, 27);
        Student s2 = new Student("李四", 1, 17);
        Student s3 = new Student("王五", 4, 29);
        Student s4 = new Student("赵六", 3, 9);
        Student s5 = new Student("左七", 2, 34);

        Student[] students = {s1, s2, s3, s4, s5};
        printStudents(students);
        Arrays.sort(students, new IdComparator());
        printStudents(students);

        ArrayList<Student> arrayList = new ArrayList<>();
        arrayList.add(s1);
        arrayList.add(s2);
        arrayList.add(s3);
        arrayList.add(s4);
        arrayList.add(s5);
        for (Student s : arrayList) {
            System.out.print(s.id + "，" + s.name + "  ");
        }
        System.out.println();
        arrayList.sort(new IdComparator());
        for (Student s : arrayList) {
            System.out.print(s.id + "，" + s.name + "  ");
        }
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

    public static void printStudents(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            System.out.print("[" + students[i].id + "," + students[i].name + "]");
        }
        System.out.println();
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
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
