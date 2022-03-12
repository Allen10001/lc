package linklist;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author hubo88
 * @link https://leetcode-cn.com/problems/lru-cache/
 * @description
 *
 * 请你设计并实现一个满足  LRUCache (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRUCache 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 *  
 *
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 *
提示：

1 <= capacity <= 3000
0 <= key <= 10000
0 <= value <= 105
最多调用 2 * 105 次 get 和 put


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/lru-cache
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LRUCache {

    // 1. 定义一个节点
    private class Node {
        Node prev, next;
        int key, value;

        private Node(int k, int v) {
            this.key = k;
            this.value = v;
        }
    }

    // 2. 定义一个双向链表, 双向链表也可以使用 LinkedList 代替
    private class DoubleList {
        Node head = new Node(0, 0);
        Node tail = new Node(0, 0);
        int size;

        private DoubleList() {
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        private void addFirst(Node n) {
            Node headNext = head.next;
            head.next = n;
            headNext.prev = n;
            n.prev = head;
            n.next = headNext;
            size++;
        }

        private void remove(Node n) {
            n.prev.next = n.next;
            n.next.prev = n.prev;
            size--;
        }

        private Node removeLast() {
            Node last = tail.prev;
            remove(last);
            return last;
        }

        private int size() {
            return size;
        }
    }

    // 3. 定义 map 用于维护最新的 cache，DoubleList 维护 LRU 的顺序，capacity cache 的大小
    // key -> Node(key, val)
    private Map<Integer, Node> map;
    // node(k1, v1) <-> Node(k2, v2)...
    private DoubleList cache;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        cache = new DoubleList();
    }

    // 4. 完成 get put 方法，主要逻辑在于 put 方法，无论 get 还是 put 要不断地更新 DoubleList
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int val = map.get(key).value; // 利⽤ put ⽅法把该数据提前
        put(key, val);
        return val;
    }
    public void put(int key, int value) {
        Node n = new Node(key, value);
        if (map.containsKey(key)) {
            cache.remove(map.get(key));
            cache.addFirst(n);
            map.put(key, n);
        } else {
            if (cache.size() == capacity) {
                // delete last element in list
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            cache.addFirst(n);
            map.put(key, n);
        }
    }

}
