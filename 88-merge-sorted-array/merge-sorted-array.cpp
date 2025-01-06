class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int idx = m+n-1;
        m--; n--;
        while(m >= 0 || n >= 0) {
            if (m < 0) {
                swap(nums1[idx], nums2[n]);
                n--;
                idx--;
            } else if (n < 0) {
                swap(nums1[idx], nums1[m]);
                m--;
                idx--;
            } else if (nums1[m] > nums2[n]) {
                swap(nums1[idx], nums1[m]);
                m--;
                idx--;
            } else {
                swap(nums1[idx], nums2[n]);
                n--;
                idx--;
            }
        }
    }
};


