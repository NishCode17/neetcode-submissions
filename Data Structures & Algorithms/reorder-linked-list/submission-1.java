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
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }

        ListNode second=slow.next;
        slow.next=null;
        ListNode prev=null;

        while(second!=null){
            ListNode next=second.next;
            second.next=prev;
            prev=second;
            second=next;
        }

        ListNode one=head;
        ListNode two=prev;

        while(two!=null){
            ListNode temp1=one.next;
            ListNode temp2=two.next;

            one.next=two;
            two.next=temp1;

            one=temp1;
            two=temp2;
        }

    }
}
