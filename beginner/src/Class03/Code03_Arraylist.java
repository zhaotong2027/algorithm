package Class03;


import java.util.ArrayList;

/**
 * 静态数组：固定数组，长度不变的数组
 * 动态数组：变长数组，存到一定长度，会生成更长的数组，把老数组的内容复制过来，
 *         老数组销毁用新数组，再存新的数，以此类推
 *         每个数组存数都是O(1)，但扩容会使常量操作（旧数存新表），每次扩容都会使前面数复制一遍O(N)
 *
 *         ❌大约复制 8+16+32+...+8^n 等比数列，通项公式 an = a1*q^(n-1) = 1*8^n
 *         ❌求和公式Sn = a1 * （1-q^n）/ (1-q) = 8 * (1-8^n)/(1-8) = -8/7 + 8/7*8^n
 *         ❌最高阶为8^n，O(8^n)
 *
 *         ？？？？？？？？
 *         扩容的时间复杂度仍为O(N)，从时间复杂度的角度上，依然是常数时间，动态数组的扩容没太大影响，工程上一般感受不到影响
 *
 * python的list更为复杂，是一棵有序树，平衡搜索二叉树
 */
public class Code03_Arraylist {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList(16);
        arrayList.add(0, 1);

        // add
//        if ((s = size) == (elementData = this.elementData).length)
//            elementData = grow();

//        private Object[] grow() {
//            return grow(size + 1);
//        }

//        private Object[] grow(int minCapacity) {
//            int oldCapacity = elementData.length;
//            if (oldCapacity > 0 || elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
//                int newCapacity = ArraysSupport.newLength(oldCapacity,
//                        minCapacity - oldCapacity, /* minimum growth */
//                        oldCapacity >> 1           /* preferred growth */);
//                return elementData = Arrays.copyOf(elementData, newCapacity);
//            } else {
//                return elementData = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
//            }
//        }
    }
}
