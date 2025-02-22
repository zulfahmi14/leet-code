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
  private TreeNode buildBST(int[] nums, int l, int r, TreeNode head) {
    if (l > r) {
      return null;
    }
    
    int mid = (l + r) / 2;
    head.val = nums[mid];
    
    TreeNode left = new TreeNode();
    TreeNode right = new TreeNode();
    head.left = buildBST(nums, l, mid - 1, left);
    head.right = buildBST(nums, mid+1, r, right);
    
    return head;
  }

  public TreeNode sortedArrayToBST(int[] nums) {
    if (nums.length == 0) {
      return new TreeNode();
    }

    TreeNode head = new TreeNode();
    int left = 0;
    int right = nums.length - 1;

    return buildBST(nums, left, right, head);
  }
}