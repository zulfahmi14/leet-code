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
    public ListNode sortList(ListNode head) {

    if (head == null) return head;

    ListNode temp = head;
    List<ListNode> list = new ArrayList<>();
    
    while(temp != null) {
      list.add(temp);
      temp = temp.next;
    }

    Collections.sort(list, (a,b) -> a.val - b.val);
    
    for(int i = 0; i < list.size(); i++) {
      if(i == list.size() - 1) {
        list.get(i).next = null;
      } else {
        list.get(i).next = list.get(i + 1);
      }
    }
    
    return list.get(0);
    }
}