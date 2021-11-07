package HeadForOffer_II.Q021_Q030;

public class Q021 {


     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }



    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0,head);
        ListNode ans = start;
        ListNode end = new ListNode(0,head);
        for(int i = 0;i<n;i++){
            end = end.next;
        }
        while (end.next!=null){
            start = start.next;
            end = end.next;
        }
        start.next = start.next.next;
        // 返回以哨兵节点为基准的地址，简化了代码对特殊情况的处理
        return ans.next;
    }




}
