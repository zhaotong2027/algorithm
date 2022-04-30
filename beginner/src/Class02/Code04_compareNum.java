package Class02;

import java.util.ArrayList;

import static Class01.Code03_Sort_Select.selectSort;
import static Class01.Code05_Sort_Insert.insertSort4;

public class Code04_compareNum {
    public static void main(String[] args) {
        // 生成数组
        ArrayList<Integer> ints = lenRandomValueRandom(10,8);
        System.out.println(ints.toString());
        ArrayList<Integer> newInts = copyInts(ints);
        System.out.println(newInts.toString());
        // 排序
        ArrayList<Integer> sortInts = insertSort4(ints);
        System.out.println(sortInts.toString());
        ArrayList<Integer> sortNewInts = selectSort(newInts);
        System.out.println(sortNewInts.toString());
        // 验证
        if (!isSort(sortInts)) {
            System.out.println("插入算法报错");
        }
        if (!isSort(sortNewInts)) {
            System.out.println("选择算法报错");
        }
        // 对数
        for (int i = 0; i < sortInts.size(); i++) {
            if (sortInts.get(i) != sortNewInts.get(i)){
                System.out.println("失败");
            }
        }
    }

    // 判断数组是否有序
    public static boolean isSort(ArrayList<Integer> ints) {
        Integer max = ints.get(ints.size() - 1); // 默认最大值在最后
        for (int i = 0; i < ints.size(); i++) {
            if (max < ints.get(i)) {
                return false;
            }
            max = Math.max(max, ints.get(i));
        }
        return true;
    }

    // 根据数组复制数组
    public static ArrayList<Integer> copyInts(ArrayList<Integer> ints) {
        ArrayList<Integer> newInts = new ArrayList<>(ints.size());
        for (int i = 0; i < ints.size(); i++) {
            newInts.add(i, ints.get(i));
        }
        return newInts;
    }

    // 返回随机生成的数组，长度 和值都是随机的
    // 长度是[0, max-1]
    // 每个值[0, maxValue-1]
    public static ArrayList<Integer> lenRandomValueRandom(int max, int maxValue) {
        int size = (int) (Math.random() * max);
        ArrayList<Integer> ints = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            ints.add(i, (int) (Math.random()*maxValue));
        }
        return ints;
    }
}
