package simple;

public class Code0171_TitleToNumber {
    public static void main(String[] args) {
//        char ch = 'A';
//        byte byteAscii = (byte) ch;
//        System.out.println(byteAscii);
//        System.out.println(titleToNumber("AB"));
//        System.out.println(titleToNumber("ZY"));
        System.out.println(titleToNumber("A"));

    }

    public static int titleToNumber(String columnTitle) {
        if (columnTitle.length() < 1) {
            return 0;
        }

        byte[] bs = columnTitle.getBytes();
        int an = 0;
        for (int i = 0; i < bs.length; i++) {
            System.out.println(bs[i]);
            an *= 26;
            an += bs[i] - 64;
        }

        return an;
    }
}
