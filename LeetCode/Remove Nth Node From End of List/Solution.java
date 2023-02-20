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
    ListNode nextNode;
    int fromEnd;
    boolean done;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        nextNode = null;
        fromEnd = 0;
        done = false;
        remove(head, n);
        if(!done){
            return head.next;
        }
        return head;
    }
    
    
    public void remove(ListNode head, int n){
        if(head == null){
            nextNode = null;
            fromEnd = 1;
            return;
        }
        remove(head.next, n);
        if(fromEnd == n+1){
            head.next = nextNode.next;
            done = true;
        }
        nextNode = head;
        fromEnd++;
    }
}