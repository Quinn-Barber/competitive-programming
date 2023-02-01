/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static final int bigNum = 100000;

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode root = null;
        int k = lists.length;
        int min = bigNum;
        int idx = -1;
        for (int i = 0; i < k; i++) {
            if (lists[i] != null && lists[i].val < min) {
                min = lists[i].val;
                idx = i;
            }
        }
        if (min == bigNum) {
            return root;
        }
        root = new ListNode(min);
        lists[idx] = lists[idx].next;

        min = bigNum;
        idx = -1;
        for (int i = 0; i < k; i++) {
            if (lists[i] != null && lists[i].val < min) {
                min = lists[i].val;
                idx = i;
            }
        }
        ListNode tmp = root;
        while (min != bigNum) {
            ListNode curNode = new ListNode(min);
            lists[idx] = lists[idx].next;
            tmp.next = curNode;
            tmp = curNode;
            min = bigNum;
            idx = -1;
            for (int i = 0; i < k; i++) {
                if (lists[i] != null && lists[i].val < min) {
                    min = lists[i].val;
                    idx = i;
                }
            }
        }

        return root;
    }
}