package HeadForOffer_II.Q021_Q030;

public class Q029 {
    public static void main(String[] args) {

    }

    class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }


    public Node insert(Node head, int insertVal) {
        Node i = new Node(insertVal);
        Node start = head;
        if (start == null) {
            i.next = i;
            return i;
        } else if (start.next == start) {
            start.next = i;
            i.next = start;
            return head;
        } else {
            Node end = start.next;
            boolean flag = true;
            Node log = start;
            if (start.val > end.val) {
                start = start.next;
                end = end.next;

            }
            while (flag) {
                if (insertVal <= end.val && insertVal >= start.val) {
                    i.next = end;
                    start.next = i;
                    flag = false;
                } else if (insertVal <= end.val && start.val > end.val) {
                    i.next = end;
                    start.next = i;
                    flag = false;
                } else if (insertVal >= start.val && start.val > end.val) {
                    i.next = end;
                    start.next = i;
                    flag = false;
                } else {
                    start = start.next;
                    end = end.next;
                    if (start == log) {
                        i.next = end;
                        start.next = i;
                        flag = false;

                    }
                }
            }
            return head;
        }
    }


}
