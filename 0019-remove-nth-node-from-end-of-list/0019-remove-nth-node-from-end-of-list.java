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
        Queue<ListNode> queue = new LinkedList<>();
        ListNode current = head;

        while (current != null) {
            queue.add(current);
            current = current.next;
        }
        int totalLength = queue.size();

        if (n == totalLength) {
            return head.next; // Head ko skip karke agla node return kar do
        }

        int stepsToPrev = totalLength - n - 1;
        for(int i =0; i<stepsToPrev; i++){
            queue.poll();
        }
        ListNode prev = queue.poll(); 
        if(prev!=null || prev.next!=null){
            prev.next = prev.next.next;
        }

        return head;
    }
}