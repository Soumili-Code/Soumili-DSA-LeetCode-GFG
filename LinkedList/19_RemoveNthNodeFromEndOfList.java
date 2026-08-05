/**
 * Problem Link : https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * Platform     : LeetCode
 * Difficulty   : Medium
 */

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
    private int findLength(ListNode curr){
        int len =0;
        while(curr!=null){
            len++;
            curr=curr.next;
        }
        return len;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
      //find length
      int len = findLength(head);  
      ListNode prev = null,curr=head;
      for(int i=0;i<len-n;i++){
        prev=curr;
        curr=curr.next;
      }
      if(prev==null){
        prev=curr.next;
        head=prev;
        return head;
      }
      prev.next=curr.next;
      return head;
    }
}
