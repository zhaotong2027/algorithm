package Class02;

// 从1～5随机到1～7
// 从a～b随机到c～d
// 01不等概率随机到01等概率随机
public class Code03_random2 {
    public static void main(String[] args) {
        // f() 1~5 正数等概率，根据 f() 得到1～7的随机
//        testf(); // 1~5 等概率，验证成功
//        testf2(); // 1~5 -> 1~7  等概率，验证失败，不等概率，无3、6
//        testf3(); // 1~5 -> 0,1  等概率，验证成功
//        testf4(); // 0,1 -> 1~7  等概率，验证成功，写的太繁琐
//        testf5(); // 0,1 -> 1~7  等概率，验证成功，骚操作
//        testf6(); // 1~7 -> 0~6  等概率，验证成功
//        testf7(); // 0~6 -> 1~7  等概率，验证成功

        // 3~19 -> 17~56
//        testf11(); // 3~19 等概率，验证成功
//        testf12(); // 3~19 -> 0、1 等概率，验证成功
        testf13(); // 0,1 -> 17~56 等概率，验证成功
    }

    // 0,1 -> 17~56
    public static int f13() {
        int ans = (f12() << 6) + (f12() << 5) + (f12() << 4) + (f12() << 3) + (f12() << 2) + (f12() << 1) + (f12() << 0);
        return ans + 17;
    }
    public static void testf13() {
        int testTimes = 10000000;
        int[] counts = new int[200];
        for (int i = 0; i < testTimes; i++) {
            int ans = f13();
            counts[ans]++;
        }
        for (int i = 17; i < 57; i++) {
            System.out.println("这个数 " + i + " 出现了 " + counts[i]+" 次");
        }
    }

    // 3~19 -> 0、1 等概率
    public static int f12() {
        int ans = 0;
        do {
            ans = f11();
        } while (ans == 11);
        return ans < 11 ? 0 : 1;
    }
    public static void testf12() {
        int testTimes = 10000000;
        int[] counts = new int[2];
        for (int i = 0; i < testTimes; i++) {
            int ans = f12();
            counts[ans]++;
        }
        for (int i = 0; i < 2; i++) {
            System.out.println("这个数 " + i + " 出现了 " + counts[i]+" 次");
        }
    }

    // 3~19 等概率，不可更改
    public static int f11() {
        return (int)(Math.random()*17) + 3;
    }
    public static void testf11() {
        int testTimes = 10000000;
        int[] counts = new int[20];
        for (int i = 0; i < testTimes; i++) {
            int ans = f11();
            counts[ans]++;
        }
        for (int i = 3; i < 20; i++) {
            System.out.println("这个数 " + i + " 出现了 " + counts[i]+" 次");
        }
    }







    // 0~6 -> 1~7
    public static int f7() {
        return  f6() + 1;
    }
    public static void testf7() {
        int testTimes = 10000000;
        int[] counts = new int[8];
        for (int i = 0; i < testTimes; i++) {
            int ans = f7();
            counts[ans]++;
        }
        for (int i = 1; i < 8; i++) {
            System.out.println("这个数 " + i + " 出现了 " + counts[i]+" 次");
        }
    }

    // 1~7 -> 0~6
    public static int f6() {
        int ans = 0;
        do {
            ans = f5();
        } while (ans == 7);
        return ans;
    }
    public static void testf6() {
        int testTimes = 10000000;
        int[] counts = new int[7];
        for (int i = 0; i < testTimes; i++) {
            int ans = f6();
            counts[ans]++;
        }
        for (int i = 0; i < 7; i++) {
            System.out.println("这个数 " + i + " 出现了 " + counts[i]+" 次");
        }
    }

    // 0,1 -> 1~7，骚操作
    public static int f5() {
        return  (f3() << 2) + (f3() << 1) + (f3() << 0);
    }
    public static void testf5() {
        int testTimes = 10000000;
        int[] counts = new int[8];
        for (int i = 0; i < testTimes; i++) {
            int ans = f5();
            counts[ans]++;
        }
        for (int i = 1; i < 8; i++) {
            System.out.println("这个数 " + i + " 出现了 " + counts[i]+" 次");
        }
    }

    // 0,1 -> 1~7
    public static int f4() {
        String ans = String.valueOf(f3()) + String.valueOf(f3()) + String.valueOf(f3());
        if (ans.equals("001")) {
            return 1;
        } else if (ans.equals("010")) {
            return 2;
        } else if (ans.equals("011")) {
            return 3;
        } else if (ans.equals("100")) {
            return 4;
        } else if (ans.equals("101")) {
            return 5;
        } else if (ans.equals("110")) {
            return 6;
        } else if (ans.equals("111")) {
            return 7;
        }
        return 0;
    }
    public static void testf4() {
        int testTimes = 10000000;
        int[] counts = new int[8];
        for (int i = 0; i < testTimes; i++) {
            int ans = f4();
            counts[ans]++;
        }
        for (int i = 1; i < 8; i++) {
            System.out.println("这个数 " + i + " 出现了 " + counts[i]+" 次");
        }
    }

    // 1~5 -> 0、1 等概率
    public static int f3() {
        int ans = 0;
        do {
            ans = f();
        } while (ans == 3);
        return ans < 3 ? 0 : 1;
    }
    public static void testf3() {
        int testTimes = 10000000;
        int[] counts = new int[2];
        for (int i = 0; i < testTimes; i++) {
            int ans = f3();
            counts[ans]++;
        }
        for (int i = 0; i < 2; i++) {
            System.out.println("这个数 " + i + " 出现了 " + counts[i]+" 次");
        }
    }

    // 1~5 -> 1~7
    public static int f2() {
        return (int)(f()*7/5);
    }
    public static void testf2() {
        int testTimes = 10000000;
        int[] counts = new int[8];
        for (int i = 0; i < testTimes; i++) {
            int ans = f2();
            counts[ans]++;
        }
        for (int i = 1; i < 8; i++) {
            System.out.println("这个数 " + i + " 出现了 " + counts[i]+" 次");
        }
    }

    // 1~5 等概率，f()不可修改
    public static int f() {
        return (int)(Math.random()*5) + 1;
    }
    public static void testf() {
        int testTimes = 10000000;
        int[] counts = new int[6];
        for (int i = 0; i < testTimes; i++) {
            int ans = f();
            counts[ans]++;
        }
        for (int i = 1; i < 6; i++) {
            System.out.println("这个数 " + i + " 出现了 " + counts[i]+" 次");
        }
    }
}
