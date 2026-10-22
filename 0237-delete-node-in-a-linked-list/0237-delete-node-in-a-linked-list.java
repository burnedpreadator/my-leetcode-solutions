/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode dummy = node;
        ListNode fast;

        if(node.next != null){
            fast = node.next;
            dummy.val = fast.val;
        }else{
            fast = node;
        }

        while(fast.next != null){
            fast.val = fast.next.val;
            dummy = dummy.next;
            fast = fast.next;
        }

        dummy.next = null;
    }
}