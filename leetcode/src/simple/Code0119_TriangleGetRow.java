package simple;

import java.util.ArrayList;
import java.util.List;

public class Code0119_TriangleGetRow {
    public static void main(String[] args) {
        System.out.println(getRow(3));
    }
    // 优化
    public static List<Integer> getRow2(int rowIndex) {
        List an = new ArrayList();
        for (int i = 0; i <= rowIndex; i++) {
            if (i == 0) {
                an.add(1);
            } else {
                for (int j = 0; j <= rowIndex / 2; j++) {
                    an.add(j, 1);
                    an.add(an.size() - j, 1);
                }
                an.add(an.size(), 1);
            }
        }
        return an;
    }


    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> ans = new ArrayList();
        for (int i = 0; i <= rowIndex; i++) {
            List an = new ArrayList();
            if (i == 0) {
                an.add(1);
            }
            if (i > 0) {
                an = iterate(ans.get(i - 1));
            }
            ans.add(an);
        }
        return ans.get(rowIndex);
    }

    public static List<Integer> iterate(List<Integer> ints) {
        List<Integer> integers = new ArrayList<>();
        integers.add(0, 0);
        integers.addAll(ints);
        integers.add(integers.size(), 0);

        List<Integer> an = new ArrayList<>();
        for (int i = 0; i + 1 < integers.size(); i++) {
            an.add(integers.get(i) + integers.get(i + 1));
        }
        return an;
    }

}
