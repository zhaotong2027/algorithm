package Class05;

// 除法太难，先跳过：https://www.mashibing.com/study?courseNo=337&sectionNo=30762&callbackUrl=%2Fsubject%2Fstudyline%2F1%3FcourseId%3D9495
// https://www.mashibing.com/study?courseNo=337
// 39、40、41 乘除法，系统最小值转绝对值
public class Code03_BitAddMinusMultiDiv {
    public static void main(String[] args) {
//        int a = 46;
//        int b = 20;
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(add(a, b));
//        System.out.println(minus(a, b));

        System.out.println(multi(3, 12));
    }

    public static int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;  // b 赋值为进位信息
            a = sum;  // a 赋值为无进位相加
        }
        return sum;  // 整个过程中，没有出现加号
    }

    // a-b 等于 a + b的相反数
    // 相反数为 取反加一
    public static int minus(int a, int b) {
        int sum = a;
//        b = ~b + 1; 不能出现加号
        b = add(~b, 1);

        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    public static int multi(int a, int b) {
        int res = 0;
        while (b != 0) {
            System.out.println("a" + a);
            System.out.println("b" + b);
            if ((b & 1) != 0) {
                res = add(res, a);
            }
            System.out.println("res" + res);
            a <<= 1;
            b >>>= 1;
        }
        return res;
    }
}
