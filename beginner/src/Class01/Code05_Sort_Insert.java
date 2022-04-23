package Class01;

import java.util.ArrayList;

public class Code05_Sort_Insert {
    public static ArrayList<Integer> swap(ArrayList<Integer> ints, int i, int j) {
        if (ints.get(i) > ints.get(j)) {
            Integer temp = ints.get(j);
            ints.set(j, ints.get(i));
            ints.set(i, temp);
        }
        return ints;
    }

    public static ArrayList<Integer> insertSort(ArrayList<Integer> ints) {
        for (int i = 0; i < ints.size(); i++) {
            for (int j = i + 1; j < ints.size(); j++) {
                swap(ints, i, j);
            System.out.println(ints.toString());
            }
        }
        return ints;
    }
    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<Integer>();
        ints.add(77);
        ints.add(8);
        ints.add(5);
        ints.add(2);
        ints.add(2);
        ints.add(37);
        ints.add(4);
        ints.add(19);
        System.out.println(ints.toString());
        System.out.println(insertSort(ints).toString());
    }
}
