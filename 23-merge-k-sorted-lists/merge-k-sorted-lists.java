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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode node = new ListNode();
        ListNode ans = node;
        while(true) {
            int nullData = 0;
            int idx = -1;
            int minn = 4000000;
            for(int i=0; i < lists.length; i++) {
                if (lists[i] == null) {
                    nullData++;
                    continue;
                }

                if (lists[i].val <= minn) {
                    minn=lists[i].val;
                    idx = i;
                }
            }

            if (nullData == lists.length) {
                break;
            }

            ListNode temp = new ListNode(lists[idx].val);
            node.next = temp;
            node = node.next;
            lists[idx] = lists[idx].next;
        }

        return ans.next;
    }
}