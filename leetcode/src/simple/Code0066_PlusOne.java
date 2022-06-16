package simple;

public class Code0066_PlusOne {
    public static void main(String[] args) {
//        int[] digits = {1,2,3};
        int[] digits = {4,3,2,1};
//        int[] digits = {9};
        int[] ans = plusOne(digits);
        System.out.println();
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + ",");
        }
        System.out.println();
    }

    public static int[] plusOne(int[] digits) {

        int flag = 0;
        int addOne = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int tmp = digits[i];
            digits[i] = (tmp + addOne + flag) % 10;
            flag = (tmp + addOne + flag) / 10;
            if (flag < 1) {
                return digits;
            }
            addOne = 0;
        }
        int[] ans = new int[digits.length + 1];
        ans[0] = 1;
//        System.arraycopy(digits, 0, ans, 1, digits.length);
        return ans;
    }
}
