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
    private TreeNode adjustTree(TreeNode root) {
        if (root == null) return root;

        TreeNode temp = root.right;
        TreeNode temp2 = root;
        root.right = adjustTree(root.left);

        while(temp2 != null && temp2.right != null) {
            temp2 = temp2.right;
        }
        
        temp2.right = adjustTree(temp);
        root.left = null;
        return root;
    }


    public void flatten(TreeNode root) {
        TreeNode x = adjustTree(root);
    }
}