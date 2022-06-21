package simple;

import java.util.ArrayList;
import java.util.List;

public class Code0118_TriangleGenerate {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList();
        for (int i = 0; i < numRows; i++) {
            List an = new ArrayList();
            if (i == 0) {
                an.add(1);
            }
            if (i > 0) {
                an = iterate(ans.get(i - 1));
            }
            ans.add(an);
        }
        return ans;
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
