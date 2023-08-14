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
        ListNode ans = new ListNode();
        ListNode res = ans;
        int c = 0;
        ListNode list1 = reverse(l1);
        ListNode list2 = reverse(l2);
        while(list1!=null || list2!=null){
            int s = 0;
            if(list1 !=null){
                s += list1.val;
                list1 = list1.next;
            }
            if(list2 !=null){
                s += list2.val;
                list2 = list2.next;
            }
            s +=c;
            ans.next = new ListNode(s%10);
            ans = ans.next;
            c = s/10;
        }
        if(c >0){
            ans.next = new ListNode(c);
        }
        return reverse(res.next);


    }

    public static ListNode reverse(ListNode node){
        ListNode pre = null, temp;
        while(node!=null){
            temp = node.next;
            node.next = pre;
            pre = node;
            node = temp;
        }
        return pre;
    }
}