/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node h1 = new Node(-1);
        Node cur = h1;
        Node h2 = head;
        Map<Node, Node> x = new HashMap<>();
        while(h2 != null) {
            Node tmp = new Node(h2.val);
            cur.next = tmp;
            x.put(h2, tmp);
            h2 = h2.next;
            cur = cur.next;
        }

        cur = h1.next;
        while(cur != null && head != null) {
            Node t1 = x.get(head.random);
            cur.random = t1;
            head = head.next;
            cur = cur.next;
        }

        return h1.next;
    }
}
