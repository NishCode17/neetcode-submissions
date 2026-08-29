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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null || head.next==null) return head;
        int counter=0;
        ListNode temp=head;

        while(counter<k && temp!=null){
            temp=temp.next;
            counter++;
        }

        if(counter<k) return head;

        ListNode newNode=revList(head,temp);
        head.next=reverseKGroup(temp,k);
        return newNode;

    }

    public ListNode revList(ListNode start, ListNode end){
        ListNode next;
        ListNode prev=null;

        while(start!=end){
            next=start.next;
            start.next=prev;
            prev=start;
            start=next;
        }

        return prev;
    }
}
