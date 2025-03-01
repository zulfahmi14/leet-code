/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
  private static void addNext(Node[] l, Node root, int lv) {
    if (root == null) return ;

    root.next = l[lv];
    l[lv] = root;

    addNext(l, root.right, lv+1);
    addNext(l, root.left, lv+1);
  }

  public static Node connect(Node root) {
    Node ans = root;
    Node[] arr = new Node[13];
    addNext(arr, root, 0);
    return ans;
  }
}