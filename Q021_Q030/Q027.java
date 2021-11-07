package HeadForOffer_II.Q021_Q030;

public class Q027 {
    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public boolean isPalindrome(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null){
            sb.append(head.val);
            head = head.next;
        }
        String k = sb.toString();
        String p = sb.reverse().toString();
        System.out.println(k);
        System.out.println(p);
        return k.equals(p);
    }

}
