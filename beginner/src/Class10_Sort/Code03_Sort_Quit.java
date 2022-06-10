package Class10_Sort;

/**
 * 快排：选一个数，左侧的小于该数，右侧反之，可无序。
 */
public class Code03_Sort_Quit {
    public static void main(String[] args) {
        int[] ints = {7, 1, 3, 5, 4, 5, 1, 4, 2, 3};
        splitNum(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + ",");
        }
    }

    public static void splitNum(int[] ints) {

        int lessEqualR = -1;
        int index = 0;
        int mostR = ints.length - 1;
        while (index < ints.length) {
            if (ints[index] <= ints[mostR]) {
//                swap(ints,lessEqualR, index);
//                lessEqualR++;
//                index++;
                swap(ints, ++lessEqualR, index++);
            } else {
                index++;
            }
        }

    }

    public static void swap(int[] ints, int i, int j) {
        int tmp = ints[i];
        ints[i] = ints[j];
        ints[j] = tmp;
    }
}
