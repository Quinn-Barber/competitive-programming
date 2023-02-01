/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
    public:
        ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
            ListNode* head = l1;
            int carry = 0;
            while (l2 || carry)
            {
                l1->val += (l2 ? l2->val : 0) + carry;
                carry = l1->val / 10;
                l1->val = l1->val % 10;
                l2 = l2 ? l2->next : l2;
                if (!l2 && !carry) break;
                l1 = l1->next ? l1->next : l1->next = new ListNode(0);
            }
            return head;
        }
    };package LeetCode.Add Two Numbers;
    
    public class Solution {
        
    }
    