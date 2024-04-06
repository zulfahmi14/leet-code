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
    
    TreeNode* setTree(vector<int> preorder, vector<int> inorder) {
        if(preorder.size() == 0) return NULL ;
        cout << preorder[0] << endl;
        if(preorder.size() == 1) {
            TreeNode* node = new TreeNode(preorder[0]);
            return node;
        }
        
        int valLeft, valRight, idx;
        TreeNode* head = new TreeNode(preorder[0]);
        for(int i=0;i<inorder.size();i++) {
            if(inorder[i]== preorder[0]) {
                idx = i;
            }
        }
        
        head->left = setTree({preorder.begin()+1, preorder.begin()+idx+1},
                             {inorder.begin(), inorder.begin()+idx});
        head->right = setTree({preorder.begin()+1+idx, preorder.end()},
                             {inorder.begin()+idx+1, inorder.end()});
        
        return head ;
    }
    
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        return setTree(preorder, inorder) ;
    }
};
