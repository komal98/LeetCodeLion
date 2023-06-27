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
    public void reorderList(ListNode head) {
        //finding the middle of the linked list and splitting it into two linked lists
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast!=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode curr = slow.next;
        slow.next = null;
        //reversing the second half
        while(curr!=null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        //merging two lists
        ListNode curr1 = head;
        ListNode curr2= prev;
        while(curr1!=null && curr2!=null){
            ListNode next1 = curr1.next;
            ListNode next2 = curr2.next;

            curr1.next =curr2;
            curr2.next = next1;

            curr1 = next1;
            curr2 = next2;
        }
    }
}

//1->2->3->4->5->6
//result: 1->6->2->5->3->4
//split: l1: 1->2->3->null. l2:4->5->6->null
//reverse l2: 6->5->4->null
//merge l1 and l2