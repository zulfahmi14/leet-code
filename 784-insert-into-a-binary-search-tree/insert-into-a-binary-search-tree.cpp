/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    TreeNode* insertIntoBST(TreeNode* root, int val) {
        if (root == NULL) {
            return new TreeNode(val);
        }

        insertLeaf(root, val);

        return root;
    }

    void insertLeaf(TreeNode* root, int val) {
        if(root == NULL) {
            // root = new TreeNode(val);
            return;
        }

        if(root->val > val) {
            if (root->left == NULL) {
                root->left = new TreeNode(val);
                return;
            }

            return insertLeaf(root->left, val);
        }

        if (root->right == NULL) {
            root->right = new TreeNode(val);
            return;
        }

        return insertLeaf(root->right, val);
    }
};