package simple;

public class Code0190_ReverseBits {
    public static void main(String[] args) {
        System.out.println(reverseBits(43261596));
    }

    public static int reverseBits(int n) {

        Integer.toBinaryString(n);
        System.out.println("00000010100101000001111010011100");

        String str = Integer.toBinaryString(n);
        System.out.println();
        int an = 0;
        while (n > 0) {
            int tmp = n % 10;
            an *= 10;
            an += tmp;
            n -= tmp;
            n /= 10;
        }
        return an;
    }


}
