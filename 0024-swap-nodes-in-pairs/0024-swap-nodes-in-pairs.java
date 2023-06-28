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
        if(head == null || head.next == null) return head;
        //initializing a new linkedlist that points to the head
        ListNode ans = new ListNode(0);
        ans.next = head;

        //starting curr from head
        ListNode curr = ans;

        //moving the curr alternatively
        while(curr.next != null && curr.next.next!=null){
            //initialzing 2 more nodes becauase 3 nodes including curr are
            //involved in the swapping
            ListNode t1 = curr.next;
            ListNode t2 = curr.next.next;
            curr.next = t2;
            t1.next = t2.next;
            t2.next = t1;
            curr = curr.next.next;
        }
        //ans.next points to head and we want to return that
       return ans.next; 
    }
}