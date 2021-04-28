package com.algo.xuz.day0425;

/**
 * CountNumOfNiceSubArrays
 * <p>
 * 统计【优美子数组】
 *
 * @author 18736
 * @version 1.0
 * 2021/4/27 22:32
 **/
public class CountNumOfNiceSubArrays {
    /**
     * 奇数看作1，偶数看作0，求前缀和数组s
     * <p>
     * 原数组：1,1,2,1,1
     * 变奇偶数组：1,1,0,1,1
     * 数组index：0,1,2,3,4
     * 数组index：0,l-1,l,r,r+1
     * <p>
     * 前缀和数组S：1,2,2,3,4
     * <p>
     * 连续子数组[l,r]中的奇数个数为S[r]-S[l-1]
     * 例如：[1,3] S[3]-S[1]=3-2=1
     * <p>
     * 枚举右端点i,只需要找到i前面有多少个j满足S[i]-S[j]=k
     * 由于S单调递增,只要满足S[i]-S[j]=k(k>0),j必然在i前面
     * <p>
     * 所以只需要用一个计数数组统计S中每个值的个数
     * 枚举右端点i，看一下等于S[i]-k的值有几个就行了
     */

    public static int numOfSubArrays(int[] nums, int k) {
        int n = nums.length;
        // 前缀和，最后一定要+1统计所有的和嘛
        int[] s = new int[n + 1];
        // count s当然也要n+1长度
        int[] count = new int[n + 1];
        // 为了统计前缀和 index=0时，s[1] = s[0]+value(num[0])
//        s[0] = 0;
        count[s[0]]++;
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + nums[i - 1] % 2;// &1位与运算
            count[s[i]]++;
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            // s[i] -s[j] = k 求j的数量
            // s[j] -s[i] = k
            // 注意下标越界
            if (s[i] - k >= 0) {
                ans += count[s[i] - k];
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("result:" + numOfSubArrays(new int[]{1, 1, 2, 1, 1}, 3));
        System.out.println("result:" + numOfSubArrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2));
    }

}
