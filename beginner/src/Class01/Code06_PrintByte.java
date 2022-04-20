package Class01;

public class Code06_PrintByte {
    public static void print(int num) {
        for(int i = 31; i >= 0; i--){
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }
    public static void main(String[] args) {
//        // 4字节32位
//        int num = 1;
//        print(num);
//        num = 2;
//        print(num);
//        num = 3;
//        print(num);
//        num = 4;
//        print(num);
//        num = 5;
//        print(num);
//
//        int i = Integer.MAX_VALUE;
//        print(i);
//        int j = Integer.MIN_VALUE;
//        print(j);

        // 正数是零的基础上加
        print(3);
        print(2);
        print(1);
        // 0是基点，每位都是空
        print(0);
        // 负数是0的取反，再在取反的基础上减
        print(-1);
        print(-2);
        print(-3);

//        由于-1和0对称，-2是1的取反，-3是2的取反，那么负数每个值都是正数-1的取反
//        因此负数可以表示到2^31次方，但正数只能表示到2^31-1，正、负、0合起来是2^32

//        十进制、八进制的底层都是二进制的位运算来实现的

//        &	按位进行与运算（AND）
//        |	按位进行或运算（OR）
//        ^	按位进行异或运算（XOR）
//        ~	按位进行取反运算（NOT）
    }
}
