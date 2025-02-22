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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

  private static TreeNode createBST(ListNode listNode, int max) {
    if (listNode == null || max <= 0) return null;

    int mid = max/2; //
    int tempMid = mid;
    ListNode temp = listNode;

    while(mid > 0) {
      temp = temp.next;
      mid--;
    }

    TreeNode head = new TreeNode(temp.val);
    head.left = createBST(listNode, tempMid);
    head.right = createBST(temp.next, max%2 == 0 ? tempMid-1: tempMid);
    return head;
  }

    public TreeNode sortedListToBST(ListNode head) {
    int max = 0;
    ListNode temp = head;
    while(temp != null) {
      temp = temp.next;
      max++;
    }

    return createBST(head, max);
    }
}