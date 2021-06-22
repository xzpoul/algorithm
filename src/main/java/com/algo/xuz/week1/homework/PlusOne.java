package com.algo.xuz.week1.homework;

import java.util.Arrays;

/**
 * PlusOne
 * 加一
 * <p>
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 18736
 * @version 1.0
 * 2021/6/22 8:12
 **/
public class PlusOne {

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();

        int[] plusOneArrayResult1 = plusOne.plusOne(new int[]{1, 2, 3, 9});
        System.out.println(Arrays.toString(plusOneArrayResult1));

        int[] plusOneArrayResult2 = plusOne.plusOne(new int[]{9, 9, 9, 9});
        System.out.println(Arrays.toString(plusOneArrayResult2));

    }

    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }

        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }


}
