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

    // 每次选出最小值放前面
    public static ArrayList<Integer> selectSort(ArrayList<Integer> ints) {
        // 外围循环控制范围，范围每次-1
        for (int j = 0; j < ints.size(); j++) {
            Integer minValue = ints.get(j);
            int minIndex = j;
            for ( int i = j + 1 ; i < ints.size(); i++) {
                if (minValue > ints.get(i)) {
                    minValue = ints.get(i);
                    minIndex = i;
                }
//                minValue = minValue > ints.get(i) ? ints.get(i) : minValue;
//                minIndex = minValue > ints.get(i) ? i : minIndex;
            }
            if (minValue < ints.get(j)) {
                ints.set(minIndex, ints.get(j));
                ints.set(j, minValue);
            }
//            System.out.println(ints.toString());
        }
        return ints;
    }
    public static void main(String[] args) {
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
