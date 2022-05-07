package Class03;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * HashMap (K,V) 结构的表
 * 不管存多少数，增删改查都是常数时间O(1)，比较大的常数时间，比数组寻址的常数时间要大得多
 * TreeMap (K,V) 结构的有序表，按k排序
 * 比HashMap功能强大，但增删改查都是O(logN)
 */
public class Code04_HashMapTreeMap {
    public static class Node {
        public int value;

        public Node(int v) {
            value = v;
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("first", "H");
        System.out.println(map.containsKey("first"));
        System.out.println(map.containsKey("f"));
        System.out.println(map.get("first"));
        System.out.println("==============");

        map.put("first", "E");
        System.out.println(map.containsKey("first"));
        System.out.println(map.containsKey("f"));
        System.out.println(map.get("first"));
        System.out.println("==============");

//        map.remove("first");
//        System.out.println(map.containsKey("first"));
//        System.out.println(map.containsKey("f"));
//        System.out.println(map.get("first"));
//        System.out.println("==============");

        String test1 = "first";
        String test2 = "first";
        System.out.println(map.containsKey(test1));
        System.out.println(map.containsKey(test2));
        System.out.println(map.get(test1));
        System.out.println("==============");

        HashMap<Integer, String> map2 = new HashMap<>();
        map2.put(123456, "我是123456");

        Integer a = 123456;
        Integer b = 123456;
        System.out.println(a == b); // == 比较的是内存地址是不是一块区域
        System.out.println(a.equals(b)); // equals 比较的是数值

        System.out.println(map2.containsKey(a)); // 哈希表内部比较的是数值
        System.out.println(map2.containsKey(b));
        System.out.println(map2.get(a));
        System.out.println("在哈希表内部，Integer、Double、Flo、String、Char等原生基础类型都是按值传递");
        System.out.println("==============");

        Node node1 = new Node(1);
        Node node2 = new Node(1);
        HashMap<Node, String> map3 = new HashMap<>();
        map3.put(node1, "node1");
        System.out.println(map3.containsKey(node1));
        System.out.println(map3.containsKey(node2));
        System.out.println("在哈希表内部，构造类型等非基础类型非原生类型，都是按引用传递的，查询按照内存地址查，构造重写");
        System.out.println("==============");

        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "H");
        treeMap.put(8, "O");
        treeMap.put(2, "E");
        treeMap.put(3, "L");
        treeMap.put(7, "W");
        treeMap.put(9, "R");
        treeMap.put(4, "L");
        treeMap.put(10, "D");

        System.out.println(treeMap.containsKey(7));
        System.out.println(treeMap.containsKey(5));
        System.out.println(treeMap.get(7));
        treeMap.put(3, "new");
        System.out.println(treeMap.get(3));
        treeMap.remove(3);
        System.out.println(treeMap.get(3));

        System.out.println(treeMap.firstKey()); // 有序表内部是按照key排序的
        System.out.println(treeMap.lastKey());
        System.out.println(treeMap.floorKey(7)); // 查询小于等于key附近的数（key存在）
        System.out.println(treeMap.floorKey(5)); // 查询小于等于key附近的数（key不存在）
        System.out.println(treeMap.ceilingKey(7)); // 查询大于等于key附近的数（key存在）
        System.out.println(treeMap.ceilingKey(5)); // 查询大于等于key附近的数（key不存在）
        System.out.println("==============");

        Node node3 = new Node(3);
        Node node4 = new Node(4);
        TreeMap<Node, String> treeMap2 = new TreeMap<>();
        treeMap2.put(node3, "node3"); // key必须可比较，如不能比较会报错
        treeMap2.put(node4, "node4");
    }
}
