package HeadForOffer_II.Q021_Q030;



public class Q022 {
    public static void main(String[] args) {

    }

    class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode start = head;
        ListNode end = head;
        boolean flag = false;
        while (end.next!=null && end.next.next!=null){
            end = end.next.next;
            start = start.next;
            if (end == start){
                flag = true;
                break;
            }
        }
        if (!flag){
            // 代表无环
            return null;
        } else {
            // 代表有环，准备遍历求环的大小，先将end向后移动
            end = end.next;
            int count = 1;
            //
            while (end != start) {
                end = end.next;
                count++;
            }
            start = head;
            while (start != end){
                start = start.next;
                end = end.next;
            }
            return start;
        }
    }


}
