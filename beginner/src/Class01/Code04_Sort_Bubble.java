package Class01;

import java.util.ArrayList;

/*
 *
 * 冒泡排序：每轮相邻两个数交换，选出最大或最小值排序
 *         基数和待排序数是相邻的两个数
 *         第一轮循环所有数，拿相邻两个数比对，数小的放前面，第一轮交换结束把最大值放最后一位
 *         第二轮循环除最后一位的得到所有数，交换结束把循环里最大的放倒第二位，依次类推
 *
 * 时间复杂度：
 * 空间复杂度：
 */
public class Code04_Sort_Bubble {
    public static ArrayList<Integer> swap(ArrayList<Integer> ints, int i) {
        if (ints.get(i) > ints.get(i + 1)) {
            Integer temp = ints.get(i + 1);
            ints.set(i + 1, ints.get(i));
            ints.set(i, temp);
        }
        return ints;
    }

    // 每次排出最大数放在最后
    public static ArrayList<Integer> bubbleSort(ArrayList<Integer> ints) {
        for (int j = 0; j < ints.size(); j++) {
            for (int i = 0; i + 1 < ints.size() - j; i++) {
//                if (ints.get(i) > ints.get(i + 1)) {
//                    Integer temp = ints.get(i + 1);
//                    ints.set(i + 1, ints.get(i));
//                    ints.set(i, temp);
//                }
                swap(ints, i);
            }
            System.out.println(ints.toString());
        }
        return ints;
    }

    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(77);
        ints.add(8);
        ints.add(5);
        ints.add(2);
        ints.add(2);
        ints.add(37);
        ints.add(4);
        ints.add(19);
        System.out.println(ints.toString());
        System.out.println(bubbleSort2(ints).toString());
    }

    // 默写
    public static ArrayList<Integer> bubbleSort2(ArrayList<Integer> ints) {
        for (int i = 1; i < ints.size(); i++) {
            for (int j = 1; j < ints.size() - i + 1; j++) {  // 把最小值放到最前
                if (ints.get(ints.size() - j - 1) > ints.get(ints.size() - j)) {  // 末尾排序，前面的数大于后面的数，则交换
                    Integer temp = ints.get(ints.size() - j);
                    ints.set(ints.size() - j, ints.get(ints.size() - j - 1));
                    ints.set(ints.size() - j - 1, temp);
                }
            }
            System.out.println(ints);
        }

        return ints;
    }
}