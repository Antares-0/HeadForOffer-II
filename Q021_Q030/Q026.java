package HeadForOffer_II.Q021_Q030;

public class Q026 {
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

    public void reorderList(ListNode head) {
        ListNode start = head;
        ListNode end = head;
        while (end != null) {
            end = end.next;
            // end == null || end.next == null
            if (end == null) {
                // 虽然end==null没有报错，但是只限于这道题而已，在027中这样写就会出问题
                // * --- * --- * ---- [*]   ====  * --- * --- *
                // |  /  |  /                     |  /  |  /  |
                // * --- *                  ====  * --- * --- [*]
                break;
            } else {
                start = start.next;
                end = end.next;
            }
        }
        System.out.print(start.val);
        ListNode new_list_back = reverse(start.next);
        start.next = null;
        ListNode new_list_head = head;
        while (new_list_back != null) {
            ListNode log_head = new_list_head.next;
            ListNode log_back = new_list_back.next;
            new_list_head.next = new_list_back;
            new_list_back.next = log_head;
            new_list_head = log_head;
            new_list_back = log_back;
        }
    }

    public ListNode reverse(ListNode ln) {
        ListNode prev = null;
        ListNode cur = ln;
        while (cur != null) {
            ListNode las = cur.next;
            cur.next = prev;
            prev = cur;
            cur = las;
        }
        return prev;
    }


}
