/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        TreeNode* ans ;
        vector<TreeNode*> v1 ;
        vector<TreeNode*> v2 ;
        search(root, p, v1);
        search(root, q, v2);

        for(int i=0 ; i< min(v1.size(), v2.size()) ; i++) {
            if(v1[i] == v2[i]) ans = v1[i];
        }

        return ans; 
    }

    void search(TreeNode* root, TreeNode* s, vector<TreeNode*>& v) {
        if(root == NULL) {
            return ;
        }

        v.push_back(root);

        if(s->val == root-> val) {
            return ;
        } else if(s->val > root-> val) {
            return search(root->right, s, v);
        } else {
            return search(root->left, s, v);
        }
    }
};