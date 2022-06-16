package simple;

public class Code0067_AddBinary {

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
//        System.out.println(addBinary("1010", "1011"));
        System.out.println(addBinary("0", "0"));
    }

    // 模拟竖式运算
    public static String addBinary(String a, String b) {
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        char[] ansArray = new char[aArray.length >= bArray.length ? aArray.length + 1 : bArray.length + 1];
        int flag = 0;
        int aInt = 0;
        int bInt = 0;
        for (int i = 0; i < ansArray.length; i++) {
            if (i < aArray.length) {
                aInt = Character.getNumericValue(aArray[aArray.length - 1 - i]);
            } else {
                aInt = 0;
            }
            if (i < bArray.length) {
                bInt = Character.getNumericValue(bArray[bArray.length - 1 - i]);
            } else {
                bInt = 0;
            }
            ansArray[ansArray.length - 1 - i] = (char) ((flag + aInt + bInt) % 2 + '0');
            flag = (flag + aInt + bInt) / 2;

        }
        String ans = String.valueOf(ansArray);
        return ans.startsWith("0") ? ans.substring(1) : ans;
    }

}
