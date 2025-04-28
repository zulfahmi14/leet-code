public class Segtree {
    public int val;
    public int l;
    public int r;
    public Segtree left;
    public Segtree right;

    public Segtree() {
    }

    public Segtree(int val) {
        this.val = val;
    }
}

class NumArray {

    Segtree root;
    int n;

    private Segtree initData(int[] nums, int l, int r) {
        Segtree root = new Segtree();

        if(l == r) {
            root.val = nums[l];
            root.l = l;
            root.r = r;
            return root;
        }

        int mid = (l+r)/2;
        Segtree left = initData(nums, l, mid);
        Segtree right = initData(nums, mid+1, r);

        root.val = left.val + right.val;
        root.left = left;
        root.right = right;
        root.l = l;
        root.r = r;

        return root;
    }

    private int update(Segtree root, int idx, int val) {
        if(root.l == root.r) {
            root.val = val;
            return root.val;
        }

        int mid = (root.l + root.r)/2;
        int newData ;
        if(idx <= mid) {
            newData = update(root.left, idx, val);
            root.val = newData + root.right.val;
        } else {
            newData = update(root.right, idx, val);
            root.val = newData + root.left.val;
        }

        return root.val;
    }

    private int sumRange(Segtree root, int l, int r) {
        if (root == null) return 0;
        
        if (root.l == l && root.r == r) {
            return root.val;
        }

        int mid = (root.l + root.r)/2;

        if(mid >= l && mid < r) {
            return sumRange(root.left, l, mid) + sumRange(root.right, mid+1, r);
        } else if (r <= mid) {
            return sumRange(root.left, l, r);
        } else {
            return sumRange(root.right, l, r);
        }
    }

    public NumArray(int[] nums) {
        n = nums.length-1;
        root = initData(nums, 0, nums.length-1);
    }
    
    public void update(int index, int val) {
        if (index < 0 || index > n) {
            return ;
        }

        root.val = update(root, index, val);
    }
    
    public int sumRange(int left, int right) {
        return sumRange(root, left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */