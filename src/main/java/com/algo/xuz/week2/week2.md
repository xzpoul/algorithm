## 第三节课

set contains O(1)
map containsKey O(1)
    containsValue X


两数之和

使用hash比双指针要简单一些

作业:尝试把三数之和改成hash方式

机器人行走 很好回去写一下
(dx,dy 方向数组是一个小技巧)


C++ 日志格式
cout << "Added" << str << "into group" << copy << endl


程序不懂就打印


统计字符/串...之类的题目
放进HashMap里分组统计,只要实现他的Hash函数即可.


设计LRU 高频必考题

必须都去写一下

不能用栈,请问怎用栈删掉中间数字.


contain缓存命中,时间提前insertHead.


#  第四节课 递归 分治

# 递归

到 index+1层


依次考虑每个位置放哪个数

从没用过的数中选一个放在当前位置

作业: 三种类型自己总结模板

指数型 子集
排列型
组合型 


树-问题
子树-子问题


### 1. 翻转二叉树-每个点的孩子都翻转一下

先递归翻
重叠子问题

   4
 2   7 
 1 3 6 9

回溯: 
   4
 7  2
 3 1 9 6
 回溯>>>

invertTree(TreeNode root){
   TreeNode temp = root.right;
   root.right = root.left;
    root.left =temp;
   invertTree(root.left);
   invertTree(root.right)

}

### 2.验证二叉搜索树

 左子树 只包含 < 当前节点
 右子树 只包含 > 当前节点
 
 check ( root ) {
 check(root.left);
 check(root.right);
    ....
 
 }

### 3. 二叉树的最大/最小深度(层高)

参数是函数体独有的,所以不需要去还原的

共享成员,空间消耗少一点点,当需要在递归前后保护现场还原


##  分治

 计算 x 的 n次幂 x^n
 
 temp * temp * x ??
 
 子问题: 不重不漏
 
 A[(a)]b
 而不是
 错误划分: 
 A[a ()] b c 复杂度爆炸
 A[(a()) ] B[()()b] 与 A[(a)()] B[()b]重复
 
 
 作业: 合并k个升序链表
 
 分治,不用堆
 
 
 
