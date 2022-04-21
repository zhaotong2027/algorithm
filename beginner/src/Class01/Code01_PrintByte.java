package Class01;

public class Code01_PrintByte {
    public static void print(int num) {
        for(int i = 31; i >= 0; i--){
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }
    public static void main(String[] args) {
//        ---------------1----------------
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

//        -------------------2---------------
//        // 正数是零的基础上加
//        print(3);
//        print(2);
//        print(1);
//        // 0是基点，每位都是空
//        print(0);
//        // 负数是0的取反，再在取反的基础上减
//        print(-1);
//        print(-2);
//        print(-3);

//        由于-1和0对称，-2是1的取反，-3是2的取反，那么负数每个值都是正数-1的取反
//        因此负数可以表示到2^31次方，但正数只能表示到2^31-1，正、负、0合起来是2^32

//        十进制、八进制的底层都是二进制的位运算来实现的

//        ------------------3----------------------
//        &	按位进行与运算（AND）
//        |	按位进行或运算（OR）
//        ^	按位进行异或运算（XOR）
//        ~	按位进行取反运算（NOT）

//        int a = 1123432425;
//        int b = 327481;
//        print(a);
//        print(b);
//        print(a & b); // 与，取1的交集，都有才算有，否则为空
//        print(a | b); // 或，取1的并集，只要有一个有则有，都没有为空
//        print(a ^ b); // 异或，取1的差集，都有或都空则空，只有一个有才算有
//        print( ~ a); // 取0和1的补集，和位置相反

//        -----------------4--------------------
//        >> 带符号右移，移动的位置是符号补的，正数的符号是0，负数的符号是1
//        >>> 不带符号右移，移动的位置是0来补的
//        int a = 1024;
//        print(a);
//        print(a >> 1); // 1024 的符号是0，带符号右移补0
//        print(a >>> 1); // 不带符号右移补0
//
//        a = Integer.MIN_VALUE;
//        print(a);
//        print(a >> 1); // 最小值的符号是1，带符号右移补1
//        print(a >>> 1); // 不带符号右移补0

//      --------------------5------------------
//        0 -1 对称 互为补码
//        1 -2 对称 互为补码
//        2 -3 对称 互为补码
//        3 -4 对称 互为补码
//        4 -5 对称 互为补码
        int b = 5; // 正数的相反数是正数5取反即-6，再+1得到-5
//        int b = -5; // 负数的相反数是负数-5取反即4，再+1得到5
        print(b);
        int c = -b;
        int d = ~b + 1; // 相反数，是取反+1
        print(~b);
        print(~b + 1);
        System.out.println(c);
        System.out.println(d);
//        相反数就是补码+1，正数取值范围小，正数都能取道相反数，负数的最小值取不到相反数，补码+1是最小值本身
        int e = Integer.MIN_VALUE;
        print(e);
        print(~e);
        print(~e + 1);
//        最小值还要取反的应该设计成long类型，因此这个逻辑无伤大雅

        int f = 0;
        print(f);
        print(~f);
        print(~f + 1);
//        0取反全是1，再+1就溢出了，溢出的去掉，结果还是0
    }
}
