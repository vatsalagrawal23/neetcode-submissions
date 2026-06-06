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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        int cnt = 0;
        while(l1 != null && l2 != null) {
            int tmp = l1.val + l2.val + cnt;
            int x = tmp%10;
            cnt = tmp/10;
            ListNode tmpA = new ListNode(x);
            cur.next = tmpA;
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null) {
            int tmp = l1.val + cnt;
            int x = tmp%10;
            cnt = tmp/10;
            ListNode tmpA = new ListNode(x);
            cur.next = tmpA;
            cur = cur.next;
            l1 = l1.next;
        }
        while(l2 != null) {
            int tmp = l2.val + cnt;
            int x = tmp%10;
            cnt = tmp/10;
            ListNode tmpA = new ListNode(x);
            cur.next = tmpA;
            cur = cur.next;
            l2 = l2.next;
        }

        if(cnt != 0) {
            ListNode tmpA = new ListNode(cnt);
            cur.next = tmpA;
            cur = cur.next;
        }

        return head.next;
    }
}
