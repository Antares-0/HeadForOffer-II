package HeadForOffer_II.Q071_Q080;

import javax.swing.*;
import java.util.List;

public class Q077 {
    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode mid = divideList(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return mergeSort(left,right);
    }

    private ListNode divideList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null){
            fast = fast.next;
            if (fast.next != null){
                fast = fast.next;
                slow = slow.next;
            } else {
                break;
            }
        }
        ListNode log = slow.next;
        slow.next = null;
        return log;
    }

    private ListNode mergeSort(ListNode head, ListNode mid){
        ListNode guard = new ListNode();
        ListNode log = guard;
        while (head != null || mid != null){
            if (mid == null || (head != null && head.val < mid.val)){
                guard.next = head;
                guard = head;
                head = head.next;
            } else {
                guard.next = mid;
                guard = mid;
                mid = mid.next;
            }
        }
        return log.next;
    }


}
