package HeadForOffer_II.Q021_Q030;



public class Q023 {
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

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len_A = 0;
        int len_B =0;
        ListNode A = headA;
        ListNode B = headB;
        while (A!=null){
            len_A++;
            A = A.next;
        }
        while (B!=null){
            len_B++;
            B = B.next;
        }
        if (len_A > len_B){
            return getNode(headA,headB,len_A-len_B);
        } else {
            return getNode(headB,headA,len_B-len_A);
        }
    }

    private ListNode getNode(ListNode long_, ListNode short_,int n){
        for (int i =0;i<n;i++){
            long_ = long_.next;
        }
        while (long_ !=short_){
            long_ = long_.next;
            short_ = short_.next;
        }
        return long_;
    }



}
