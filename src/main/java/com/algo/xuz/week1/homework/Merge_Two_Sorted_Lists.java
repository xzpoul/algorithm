package com.algo.xuz.week1.homework;

import java.util.Arrays;

/**
 * Merge_Two_Sorted_Lists
 * <p>
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 链接: https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * @author 18736
 * @version 1.0
 * 2021/6/22 8:21
 **/
public class Merge_Two_Sorted_Lists {

    public static void main(String[] args) {
        Merge_Two_Sorted_Lists merge_two_sorted_lists = new Merge_Two_Sorted_Lists();
        int[] m = {1, 2, 5};
        int[] n = {3, 4, 6};
        int[] result = merge_two_sorted_lists.merge(m, n);

        System.out.println(Arrays.toString(result));
    }

    public int[] merge(int[] m, int[] n) {
        int[] result = Arrays.copyOf(m, m.length + n.length);
        int i = m.length - 1;
        int j = n.length - 1;

        // 思路: i j 两个指针倒着扫描,谁大要谁
        // 细节: i j (--)不能越界 一个<0,就要另一个
        for (int k = m.length + n.length - 1; k >= 0; k--) {
            if (j < 0 || m[i] > n[j]) {
                result[k] = m[i];
                i--;
            } else {
                result[k] = n[j];
                j--;
            }
        }
        return result;
    }

//    public ArrayList<Integer> merge(ArrayList<Integer> m, ArrayList<Integer> n) {
//        ArrayList<Integer> result = new ArrayList<Integer>();
//     预先设置ArrayList的大小，这样可以大大提高初始化速度。
//     不会创建大小为 x 的ArrayList.它会创建一个空的ArrayList，其初始容量为10.
//     所以仍然error: IndexOutOfBoundsException
//        result.ensureCapacity(1);
//
//        int i = m.size() - 1;
//        int j = n.size() - 1;
//
//        // 思路: i j 两个指针倒着扫描,谁大要谁
//        // 细节: i j (--)不能越界 一个<0,就要另一个
//        for (int k = m.size() + n.size() - 1; k >= 0; k--) {
//            if (j < 0 || m.get(i) > n.get(j)) {
//                result.set(k, m.get(i));
//                i--;
//            } else {
//                result.set(k, n.get(j));
//                j--;
//            }
//        }
//        return m;
//    }


}
