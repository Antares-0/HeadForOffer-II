package HeadForOffer_II.Q021_Q030;


public class Q025 {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode new_l1 = reverse(l1);
        ListNode new_l2 = reverse(l2);
        int carry = 0;
        ListNode ans = null;
        while (new_l1 != null || new_l2 != null) {
            int l1_num = new_l1 == null ? 0 : new_l1.val;
            int l2_num = new_l2 == null ? 0 : new_l2.val;
            new_l1 = new_l1 == null ? new_l1 : new_l1.next;
            new_l2 = new_l2 == null ? new_l2 : new_l2.next;
            int ans_num = (l1_num + l2_num + carry) % 10;
            carry = (l1_num + l2_num + carry) / 10;
            ListNode ans_new = new ListNode(ans_num);
            ans_new.next = ans;
            ans = ans_new;
        }
        if (carry == 1){
            ListNode ans_new = new ListNode(1);
            ans_new.next = ans;
            ans = ans_new;
        }
        return ans;
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
