/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode cur = head;
            while(cur != null && n > 0) {
                cur = cur.next;
                n--;
            }

            ListNode nthNode = head;
            ListNode prev = null;
            while(cur != null) {
                prev = nthNode;
                nthNode = nthNode.next;
                cur = cur.next;
            }
            if(prev == null) {
                head = nthNode.next;
            }
            else {
                prev.next = nthNode.next;
            }

            return head;
        }
}
