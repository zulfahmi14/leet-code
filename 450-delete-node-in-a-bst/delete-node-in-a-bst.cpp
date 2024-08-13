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
    TreeNode* deleteNode(TreeNode* root, int key) {
        if (root == NULL) {
            return NULL ;
        }

        if (root->val == key) {
            TreeNode* endleaf = root->right;

            if(root->left != NULL) {
                addLastRight(root->left, endleaf);
                return root->left ;
            }

            return root->right;
        }

        delNode(root, key);
        return root;
    }

    void addLastRight(TreeNode* root, TreeNode* newNode) {
        if (root->right != NULL) {
            addLastRight(root->right, newNode);
            return;
        }

        root->right = newNode;
        return;
    }

    void delNode(TreeNode* root, int key) {
        if(root == NULL) {
            return ;
        }

        if(root->val == key) {
            root = NULL;
        } else if (root->val > key) {
            if(root->left != NULL && root->left->val == key) {
                // delete the left node
                if(root->left->right != NULL && root->left->left != NULL) {
                    TreeNode* endleaf = root->left->right;
                    root->left = root->left->left;
                    addLastRight(root->left, endleaf);
                } else if (root->left->right == NULL) {
                    root->left = root->left->left;
                } else if (root->left->left == NULL) {
                    root->left = root->left->right;
                } else {
                    root->left = NULL;
                }
            } else {
                delNode(root->left, key);
            }
        } else {
            if(root->right != NULL && root->right->val == key) {
                // delete the right node
                if(root->right->right != NULL && root->right->left != NULL) {
                    TreeNode* endleaf = root->right->right;
                    root->right = root->right->left;
                    addLastRight(root->right, endleaf);
                } else if (root->right->right == NULL) {
                    root->right = root->right->left;
                } else if (root->right->left == NULL) {
                    root->right = root->right->right;
                } else {
                    root->right = NULL;
                }
            } else {
                delNode(root->right, key);
            }
        }
    }
};