package HeadForOffer_II.Q021_Q030;


public class Q028_X {
    public static void main(String args[]) {

    }
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten(Node head) {

        flattenGetTail(head);
        return head;
    }

    private Node flattenGetTail(Node head){
        Node cur = head;
        Node ans = null;
        while (cur!=null){
            Node next = cur.next;
            if (cur.child!=null){
                Node child = cur.child;
                Node tail = flattenGetTail(child);
                tail.next = next;
                cur.child = null;
                cur.next = child;
                child.prev = cur;

                if (next != null){
                    next.prev = tail;
                }
                ans = tail;
            } else {
                ans = cur;
            }
            cur = cur.next;
        }
        return ans;
    }



}
