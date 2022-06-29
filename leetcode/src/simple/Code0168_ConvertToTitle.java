package simple;

public class Code0168_ConvertToTitle {
    public static void main(String[] args) {
//        char ch = 'A';
//        char ch1 = 'a';
//        int ascii = ch;
//        int ascii1 = ch1;
//        System.out.println("大A的ascii编码是-->" + ascii);
//        System.out.println("小a的ascii编码是-->" + ascii1);
//        System.out.println(ch1);

//        int n = 18;
//        Integer.toHexString(n);
//        System.out.println(n + "的二进制是:" + Integer.toBinaryString(n));
//        System.out.println(n + "的八进制是:" + Integer.toOctalString(n));
//        System.out.println(n + "的十六进制是:" + Integer.toHexString(n));
//        System.out.println(n + "的三进制是:" + Integer.toString(n, 3));

        System.out.println(convertToTitle2(28));
        System.out.println(convertToTitle2(701));
        System.out.println(convertToTitle2(2147483647));
    }


//    public static String convertToTitle3(int columnNumber) {
//        StringBuilder ans = new StringBuilder();
//        while (columnNumber > 26) {
//            int tmp = columnNumber % 26 == 0 ? 26 : columnNumber % 26;
//            ans.insert(0, (char) ('@' + tmp));
//            columnNumber -= tmp;
//            columnNumber /= 26;
//        }
//        ans.insert(0, (char) ('@' + columnNumber));
//        return ans.toString();
//    }

    public static String convertToTitle2(int columnNumber) {
        String an = "";
        while (columnNumber > 26) {
            int tmp = columnNumber % 26 == 0 ? 26 : columnNumber % 26;
            an = String.valueOf((char) (64 + tmp)).concat(an);
            columnNumber -= tmp;  // 去掉余数
            columnNumber /= 26;
        }

        an = String.valueOf((char) (64 + columnNumber)).concat(an);
        return an;
    }

    // 701 转换成 10p 无法识别成数字
    public static String convertToTitle(int columnNumber) {
        if (columnNumber < 1) {
            return null;
        }

        Integer.toHexString(columnNumber);
        String intStr = Integer.toString(columnNumber, 26);
        System.out.println(26 + "进制：" + intStr);

        String an = "";
        for (int i = 0; i < intStr.length(); i++) {
            System.out.println("每一位转换的数值：" + (65 - Integer.valueOf(intStr.charAt(i))));
            int ascii = 16 + Integer.valueOf(intStr.charAt(i));
            char ch = (char) ascii;
            an = an.concat(String.valueOf(ch));
        }

        return an;
    }
}
