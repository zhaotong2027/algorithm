package Class01;

import java.util.ArrayList;
/*
*
* 选择排序：第一次循环选最小值，把最小值和第一位互换，第二次循环剩下位置的最小值，与第二位互换，依次类推
*
* 时间复杂度：
* 空间复杂度：
*
* */
public class Code03_Sort_Select {

    public static ArrayList<Integer> selectSort(ArrayList<Integer> ints) {
        for (int i = 0; i < ints.size(); i++) {
            Integer minValue = ints.get(i);
            int minIndex = i;
            for ( int j = i + 1 ; j < ints.size(); j++) {
//                if (minValue > ints.get(j)) {
//                    minValue = ints.get(j);
//                    minIndex = j;
//                }
                minValue = minValue > ints.get(j) ? ints.get(j) : minValue;
                minIndex = minValue > ints.get(j)? j : minIndex;
            }
            if (minValue < ints.get(i)) {
                ints.set(minIndex, ints.get(i));
                ints.set(i, minValue);
            }
            System.out.println(ints.toString());
        }
        return ints;
    }
    public static void main(String[] args) {
//        int[] arr = {9, 2, 5, 8, 3, 4, 6};
        ArrayList<Integer> ints = new ArrayList<Integer>();
        ints.add(2);
        ints.add(77);
        ints.add(8);
        ints.add(5);
        ints.add(2);
        ints.add(37);
        ints.add(4);
        ints.add(19);
        System.out.println(ints.toString());
        System.out.println(selectSort(ints).toString());

    }
}
