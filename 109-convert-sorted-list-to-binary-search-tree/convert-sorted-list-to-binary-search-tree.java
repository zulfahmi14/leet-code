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

  private static TreeNode createBST(List<ListNode> list, int l, int r) {
    if (l > r) return null;
    int mid = (l + r) / 2;

    TreeNode head = new TreeNode(list.get(mid).val);
    head.left = createBST(list, l, mid - 1);
    head.right = createBST(list, mid + 1, r);
    return head;
  }

    public TreeNode sortedListToBST(ListNode head) {
        List<ListNode> list = new ArrayList<>();
    while(head != null) {
      list.add(head);
      head = head.next;
    }

    return createBST(list, 0, list.size() - 1);
    }
}