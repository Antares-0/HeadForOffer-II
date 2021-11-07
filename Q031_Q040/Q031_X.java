package HeadForOffer_II.Q031_Q040;

import java.util.HashMap;

public class Q031_X {
    public static void main(String[] args) {

    }

    static class LRUCache {
        class Node{
            int val;
            int key;
            Node prev;
            Node next;
            Node (int key,int val) {this.key = key; this.val = val;}
        }

        HashMap<Integer,Node> map;
        Node head; // 代表头部节点
        Node tail; // 代表尾部节点
        int len = 0;
        int count = 0;

        public LRUCache(int capacity) {
            map = new HashMap<>();
            head = new Node(-1,-1);
            tail = new Node(-1,-1);
            head.next = tail;
            tail.prev = head;
            len = capacity;
        }

        public int get(int key) {
            System.out.println(map.size());
            if (map.containsKey(key)){
                int k = map.get(key).val;
                moveToTail(map.get(key),tail);
                return k;
            } else {
                return -1;
            }

        }

        public void put(int key, int value) {
            if (map.containsKey(key)){
                // there is key in map;
                map.get(key).val = value;
                if (map.get(key).next == tail){

                } else{
                    moveToTail(map.get(key),tail);
                }
            } else {
                // 不包含key的情况
                if (count < len){
                    Node node = new Node(key,value);
                    map.put(key,node);
                    Node head_log =  tail.prev;
                    head_log.next = node;
                    node.prev = head_log;
                    node.next = tail;
                    tail.prev = node;
                    count++;
                } else {

                    Node node = new Node(key,value);

                    // 在链表结尾加上node节点
                    Node tail_log = tail.prev;
                    tail_log.next = node;
                    node.prev = tail_log;
                    node.next = tail;
                    tail.prev = node;
                    // 在链表前面删除node节点

                    Node head_log = head.next.next;
                    map.remove(head_log.prev.key);
                    map.put(key,node);
                    head_log.prev = head;
                    head.next = head_log;
                }
            }
        }


        private void moveToTail(Node node,Node tail){
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            Node log_pre = tail.prev;
            //  ________________________________________________________
            // |老老实实先删除再添加，否则就会出乱子                          |
            //  ________________________________________________________
            log_pre.next = node;
            node.prev = log_pre;
            node.next = tail;
            tail.prev = node;



//            node.prev.next = node.next;
//            node.next.prev = node.prev;
//            tail.prev.next = node;
//            node.prev = tail.prev;
//            tail.prev = node;
        }
    }

}
