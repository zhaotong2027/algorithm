package Class02;

public class Code02_random {
    public static void main(String[] args) {
        System.out.println("开始");
        // Math.random() -> double -> [0,1)
//        double ans = Math.random();
        int testTimes = 10000000;
        int count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (Math.random() < 0.75) {
                count++;
            }
        }
        System.out.println((double)count/(double)testTimes);

        System.out.println("======================");

        // [0,1) -> [0,8)
//        double ans = Math.random() * 8;
        count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (Math.random()*8 < 5) {
                count++;
            }
        }
        System.out.println((double)count/(double)testTimes);
        System.out.println((double)5/(double)8);

        System.out.println("======================");

        //[0,1) -> [0,k-1]
        int k = 9;
        // [0,8]
//        int ans = (int)(Math.random() * k);
        int[] counts = new int[9];
        for (int i = 0; i < testTimes; i++) {
            int ans = (int) (Math.random() * k);
            counts[ans]++;
        }
        for (int i = 0; i < k; i++) {
            System.out.println("这个数 " + i + " 出现了 " + counts[i]+" 次");
        }

        System.out.println("======================");

        // [0,1) -> [0, x^2)
        // 让任意一个数，在[0, x)范围上，调整概率由x改为x^2，并输出这个概率
        count = 0;
        double x = 0.17;
        for (int i = 0; i < testTimes; i++) {
            if (xToXPower2() < x) {
                count++;
            }
        }
        System.out.println((double)count/(double)testTimes);
        System.out.println(Math.pow(x, 2));
//        System.out.println(1-Math.pow((1-x), 2));
    }

    // 返回[0,1)的一个小数
    // 任意的x，x属于[0,1)，[0,1)范围上的数出现概率由原来的x调整成x平方
    public static double xToXPower2() {
        return Math.max(Math.random(), Math.random());
    }
    // max是返回两个数较大的，两个数较大的都<x，
    // 说明两个数都在[0,x)区间，都在这个区间的概率为x^2
    public static double xToXPower3() {
        return Math.max(Math.random(), Math.max(Math.random(), Math.random()));
    }
    // min返回两个数较小的，则只要有一个数是<x
    // 1个数落到[0,1)的概率是x，不在的概率是1-x
    // 两个数都不在的概率是(1-x)^2，两个数任意一个在的概率就是1-(1-x)^2
    public static double min() {
        return Math.min(Math.random(), Math.random());
    }
}
