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
        if(head == null) return head;
        if(head.next == null) return head;
        
        ListNode tmp = head;
        
        ArrayList<Integer> vals = new ArrayList<>();
        
        while(tmp != null){
        
            if(tmp.next == null){
                vals.add(tmp.val);
                break;
            }
            
            vals.add(tmp.next.val);
            vals.add(tmp.val);
            
            tmp = tmp.next.next;
        }
        
        ListNode newHead = new ListNode(vals.get(0));
        tmp = newHead;
        for(int i = 1; i < vals.size(); i++){
            newHead.next = new ListNode(vals.get(i));
            newHead = newHead.next;
        }
        
        return tmp;
    }
}