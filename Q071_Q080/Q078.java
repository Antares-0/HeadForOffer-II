package HeadForOffer_II.Q071_Q080;

import java.util.Arrays;
import java.util.List;

public class Q078 {
    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        // 防止lists是空
        if (lists.length == 0 || (lists[0] == null && lists.length == 1)){
            return null;
        }
        int length = lists.length;
        for (int distance = 1; distance <= length; distance = distance << 1) {
            // flag表示指针的运动位置
            int flag = 0;
            // 如果flag小于长度，就继续安排
            while (flag < length){
                int start = flag;
                int mid = flag + distance;
                // 一定要有等于号
                if (mid >= length){
                    mid = length-1;
                    // 越界了，不排，其实只是针对与distance==1的情况
                    if (mid == start){
                        break;
                    }
                }
                // 对start和mid进行排序
                ListNode guard = new ListNode();
                ListNode log = guard;
                while (lists[start] != null || lists[mid] != null){
                    if (lists[mid] == null || (lists[start] != null && lists[start].val < lists[mid].val)){
                        guard.next = lists[start];
                        lists[start] = lists[start].next;
                        guard = guard.next;
                    } else {
                        guard.next = lists[mid];
                        lists[mid] = lists[mid].next;
                        guard = guard.next;
                    }
                }
                // 将排好序的链表放在start处
                lists[start] = log.next;
                flag = mid + distance;
            }
        }
        return lists[0];
    }

}
