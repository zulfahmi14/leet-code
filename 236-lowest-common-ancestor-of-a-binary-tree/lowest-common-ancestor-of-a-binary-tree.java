/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public Deque<TreeNode> search(TreeNode root, TreeNode s) {
        if (root == null) return new ArrayDeque<>();
        if (root.val == s.val) return new ArrayDeque<>(List.of(root));
        Deque<TreeNode> ans1 = search(root.left, s);
        Deque<TreeNode> ans2 = search(root.right, s);
        if (!ans1.isEmpty()) {
            ans1.addFirst(root);
            return ans1;
        } else if (!ans2.isEmpty()) {
            ans2.addFirst(root);
            return ans2;
        }

        return new ArrayDeque<>();
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> data1 = search(root, p);
        Deque<TreeNode> data2 = search(root, q);

        Map<Integer, TreeNode> visited = new HashMap<>();
        for (TreeNode node : data2) {
            visited.put(node.val, node);
        }

        TreeNode ans = null;
        for (TreeNode node : data1) {
            if (visited.containsKey(node.val)) {
                ans = node;
            }
        }

        return ans;
    }
}