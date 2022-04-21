package Class01;

public class Code02_SumNum {

    // ----------------1失败----------------
//    public static int factorial(int i) {
//        int n = i;
//        int j = 0;
//        int sum = 0;
//        while (n > 0) {
//            if(i > 2) {
//                while (i > 2) {
//                    j = i * (i - 1);
//                    i--;
//                }
//                sum = j + sum;
//                System.out.println(sum);
//            }
//            if (i == 2) {
//                j = 2;
//                sum = j + sum;
//            }
//            if (i == 1) {
//                j = 1;
//                sum = j + sum;
//            }
//            n--;
//        }
//        return sum;
//    }

    // ------------2成功--------------
    public static int factorial(int i) {
        System.out.print("i:" + i + " ");
        int f = i;
        if (i > 2) {
            while (i > 2) {
                f = f * (i - 1);
                i--;
            }
        }
//        else if (i == 2) {
//            f = 2;
//        } else if (i == 1) {
//            f = 1;
//        }
        System.out.println("f:" + f);
        return f;
    }
    public static int recursion1(int i) {
        int sum = 0;
        while (i > 0) {
            sum = sum + factorial(i);
            i--;
        }
        System.out.println("sum:" + sum);
        return sum;

    }

    // --------------3失败-----------------
//    public static int recursion2(int i) {
//        System.out.print("i:" + i + "  ");
//        int sum = 0;
//        int f = i;
//        while (i > 2) {
//            f = f * (i - 1);
//            i--;
//        }
//        System.out.print("f:" + f + "  ");
//        System.out.println("sum:" + sum);
//        sum = f + recursion2(i - 1);
//        return sum;
//    }
    public static void main(String[] args) {
        System.out.println(recursion1(5));
        // 1: 1
        // 2: 2 + 1 = 3
        // 3: 3 * 2 + 3 = 9
        // 4: 4 * 6 + 9 = 33
        // 5: 5 * 24 + 33 = 153
    }
}
