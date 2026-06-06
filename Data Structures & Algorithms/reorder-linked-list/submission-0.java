/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public static ListNode rev(ListNode node) { 
        ListNode prev = null, curr = node, next; 
        while (curr != null) { 
            next = curr.next; 
            curr.next = prev; 
            prev = curr; 
            curr = next; 
        } 
        node = prev; 
        return node; 
    } 
    public void reorderList(ListNode head) {
        if(head == null){
            head = head;
        }
        else{
            ListNode slow = head;
            ListNode fast = slow.next;
            while(fast != null && fast.next!= null){
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode n1 = head;
            ListNode n2 = slow.next;
            slow.next = null;
            n2 = rev(n2);
            head = new ListNode(0);
            ListNode curr = head;
            while(n1!=null || n2!=null){
                if(n1!=null){
                    curr.next = n1;
                    curr = curr.next;
                    n1 = n1.next;
                }
                if(n2!=null){
                    curr.next = n2;
                    curr= curr.next;
                    n2 = n2.next;
                }
            }
            head = head.next;
        }
    }
}