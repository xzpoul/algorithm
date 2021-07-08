package com.algo.xuz.week3;

import java.util.HashMap;
import java.util.Map;

/**
 * construct_binary_tree_from_in_postorder
 * <p>
 * 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 *
 * @author 18736
 * @version 1.0
 * 2021/7/7 22:52
 **/
public class construct_binary_tree_from_in_postorder {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int[] postorder;
    private int[] inorder;
    int post_idx;
    Map<Integer, Integer> idx_map = new HashMap<Integer, Integer>();


    public TreeNode helper(int in_left, int in_right) {
        // 如果这里没有节点构造二叉树了，就结束
        if (in_left > in_right) {
            return null;
        }

        // 选择 post_idx 位置的元素作为当前子树根节点
        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);

        // 根据 root 所在位置分成左右两棵子树
        int index = idx_map.get(root_val);

        // 下标减一
        post_idx--;
        // 构造右子树
        root.right = helper(index + 1, in_right);
        // 构造左子树
        root.left = helper(in_left, index - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        // 从后序遍历的最后一个元素开始
        post_idx = postorder.length - 1;

        // 建立（元素，下标）键值对的哈希表
        int idx = 0;
        for (Integer val : inorder) {
            idx_map.put(val, idx++);
        }

        return helper(0, inorder.length - 1);
    }


//    public TreeNode buildTree(int[] inorder, int[] postOrder) {
//        this.postOrder = postOrder;
//        this.inorder = inorder;
//        return build(postOrder.length - 1, 0, 0, inorder.length - 1);
//    }
//
//    // * 中序遍历 inorder = [9,3,   15,20,7]  mid 2
//
//
//    // * 后序遍历 postorder = [9,15,7,20,    3] l1
//
//    private TreeNode build(int r1, int l1, int l2, int r2) {
//        // 后续最后一位是根节点
//        TreeNode root = new TreeNode(postOrder[r1]);
//        int mid = postOrder.length - r1;
//        // 找到根在中序的位置
//        while (inorder[mid] != postOrder[r1]) {
//            mid++;
//        }
//        root.left = build(r1 - 1, r1-mid+l2 ,l2, mid-1 );
//        root.right = build(r1-mid +l2-1,r1);
//        return root;
//    }


}
