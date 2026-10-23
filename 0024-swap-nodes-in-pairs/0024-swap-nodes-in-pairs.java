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
    public ListNode swapPairs(ListNode head) {
        if(head ==null || head.next == null){
            return head;
        }
        ListNode fast = head.next;
        ListNode prev = head;
        ListNode curr = fast;
        ListNode newHead = head.next;

        while(fast!= null && fast.next != null){
            ListNode dummy = fast.next;
            curr.next = fast;
            fast.next = prev;
            prev.next = dummy;
            fast = dummy.next;
            curr = prev;
            prev = dummy;
        }
        if(fast!=null){
            ListNode dummy = fast.next;
            curr.next = fast;
            fast.next = prev;
            prev.next = dummy;
        }

        return newHead;
    }
}