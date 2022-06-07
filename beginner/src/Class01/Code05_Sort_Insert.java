package Class01;

import java.util.ArrayList;

/*
 *
 * 插入排序：扑克牌抽新牌插入到已有牌当中
 *
 * 时间复杂度：
 * 空间复杂度：
 */
public class Code05_Sort_Insert {
    // i 基数， j 待比对数
    // 要求基数比待比对数小，如果待比对数小于基数，则交换
    public static ArrayList<Integer> swap(ArrayList<Integer> ints, int i, int j) {
        if (ints.get(i) > ints.get(j)) {
            Integer temp = ints.get(j);
            ints.set(j, ints.get(i));
            ints.set(i, temp);
        }
        return ints;
    }

    // 不是插入排序，sad，也不是冒泡，看起来像选择排序
    // 外循环下标i从0开始，每次+1；内循环从i+1开始，每次+1；
    // 第一轮比对0和1、2、3、4。。。如果发现i不是最小的，就把最小的和i交换，第一轮结束选出最小的放第一位
    // 每次选出最小值放前面
    public static ArrayList<Integer> insertSort(ArrayList<Integer> ints) {
        for (int i = 0; i < ints.size(); i++) {
            for (int j = i + 1; j < ints.size(); j++) {
                swap(ints, i, j);
                System.out.println(ints.toString());
            }
        }
        return ints;
    }

    // 外循环下标end从1开始，每次+1；内循环下标从end-1开始，每次-1；
    // 第一轮比对1和0，如果发现1比0小则交换
    // 第二轮比对2和1、0，如果发现2比谁小放在谁前面
    // 每次比对范围扩大1，把数放在合适的位置
    public static ArrayList<Integer> insertSort2(ArrayList<Integer> ints) {
        int N = ints.size();
        for (int end = 1; end < N; end++) {
            int newNumIndex = end;
            while (newNumIndex - 1 >= 0 && ints.get(newNumIndex - 1) > ints.get(newNumIndex)) {
                swap(ints, newNumIndex - 1, newNumIndex);
                newNumIndex--;
                System.out.println(ints.toString());
            }
        }
        return ints;
    }

    public static ArrayList<Integer> insertSort3(ArrayList<Integer> ints) {
        // 外层循环，范围end，待排序值下标end，每轮范围+1
        for (int end = 1; end < ints.size(); end++) {
            // 内层循环，用冒泡把数插入范围内合适的位置
            for (int i = end - 1; i >= 0; i--) {
//                if (ints.get(i) > ints.get(i + 1)) {
//                    Integer temp = ints.get(i + 1);
//                    ints.set(i + 1, ints.get(i));
//                    ints.set(i, temp);
//                }
                swap(ints, i, i + 1);
                System.out.println(ints.toString());
            }
        }
        return ints;
    }

    // 一点小优化
    public static ArrayList<Integer> insertSort4(ArrayList<Integer> ints) {
        // 外层循环，范围end，每轮范围+1
        for (int end = 1; end < ints.size(); end++) {
            // 内层循环，待排序数end，基数end-1，用冒泡把数插入范围内合适的位置
            for (int pre = end; pre > 0 && ints.get(pre - 1) > ints.get(pre); pre--) {
//                if (ints.get(i) > ints.get(i + 1)) {
//                    Integer temp = ints.get(i + 1);
//                    ints.set(i + 1, ints.get(i));
//                    ints.set(i, temp);
//                }
                swap(ints, pre - 1, pre);
//                System.out.println(ints.toString());
            }
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
        System.out.println(insertSort5(ints));
    }

    // 默写
    public static ArrayList<Integer> insertSort5(ArrayList<Integer> ints) {
        for (int i = 1; i < ints.size(); i++) {  // 选牌
            for (int j = 0; j < i; j++) {  // 设定范围
                if (ints.get(i) < ints.get(j)) {
                    int temp = ints.get(i);
                    ints.set(i, ints.get(j));
                    ints.set(j, temp);
                }
            }
//            System.out.println(ints);
        }
        return ints;
    }

}
// 排序重要指标，排序范围、基值、待排序数值、循环