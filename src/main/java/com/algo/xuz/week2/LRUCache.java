package com.algo.xuz.week2;

import java.util.HashMap;

/**
 * LRU
 * <p>
 * <p>
 * 用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 * <p>
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *  
 * <p>
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 18736
 * @version 1.0
 * 2021/6/25 8:08
 **/

//class LRUCache {
//
//    public LRUCache(int capacity) {
//
//    }
//
//    public int get(int key) {
//
//    }
//
//    public void put(int key, int value) {
//
//    }
//}
//
///**
// * Your LRUCache object will be instantiated and called as such:
// * LRUCache obj = new LRUCache(capacity);
// * int param_1 = obj.get(key);
// * obj.put(key,value);
// */
public class LRUCache {


    /**
     * 哈希表+双向链表
     * <p>
     * 双向链表用于按时间顺序保存数据
     * <p>
     * 哈希表用于把key映射到链表节点(指针/引用)
     */
    private class Node {
        public int key;
        public int value;
        public Node pre;
        public Node next;
    }

    private HashMap<Integer, Node> map;

    // 保护节点
    private Node head;

    private Node tail;

    private int capacity;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, Node>();
        // 建有带有保护节点的空双向链表
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!this.map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);

        // 在List和Map中移除
        this.removeFromListAndMap(node);

        // 重新插入List和Map
        this.insertToListHeadAndMap(node.key, node.value);

        return node.value;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            Node node = map.get(key);
            this.removeFromListAndMap(node);
        }
        // 重新插入链表头部,更新时间顺序
        this.insertToListHeadAndMap(key, value);
        if (this.map.size() > this.capacity) {
            // 为什么 移除tail.pre
            this.removeFromListAndMap(this.tail.pre);
        }
    }

    public void removeFromListAndMap(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        this.map.remove(node.key);
    }

    public Node insertToListHeadAndMap(int key, int value) {
        Node node = new Node();
        node.key = key;
        node.value = value;

//        this.head.pre = node;
//        node.next = this.head;
//        head是保护节点,无实际存储,不是成为head的head,node+head+head.next 错
//        原head仍然做head,即head+node+head.next

        // node 与下一个节点
        node.next = this.head.next;
        this.head.next.pre = node;

        // node 与 上一个节点
        this.head.next = node;
        node.pre = this.head;

        // 建立映射关系
        this.map.put(node.key, node);

        return node;
    }


}
