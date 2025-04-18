class Solution {
    private class Pair {
        public int a;
        public int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    private int mainBinser(int[] nums1, int[] nums2, int n) {
        int l = 0;
        int r = nums1.length-1;

        while(l <= r) {
            int mid = (l+r)/2;
            int lowerIdx = otherBinser(nums2, nums1[mid]);
            int upperIdx = otherBinser(nums2, nums1[mid]+1);
            int targetIdx = (n/2) - mid;

            if (targetIdx >= lowerIdx && targetIdx <= upperIdx) {
                return mid;
            }

            if (lowerIdx + mid > n/2) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }

        return -1;
    }

    private int otherBinser(int[] nums, int num) {
        int l = 0;
        int r = nums.length-1;
        int ans = -1;

        while( l <= r ) {
            int mid = (r+l)/2;
            if (nums[mid] < num) {
                ans = mid;
                l = mid+1;
            } else {
                r = mid-1;
            }
        }

        return ans+1;
    }

    private Pair getMedian(int[] nums1, int[] nums2, int n) {
        int idx = mainBinser(nums1, nums2, n);

        if (idx == -1) {
            idx = mainBinser(nums2, nums1, n);
            return new Pair(-1, idx);
        }

        return new Pair(idx, -1);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int idx1 = -1;

        if (n % 2 == 1) {
            idx1 = mainBinser(nums1, nums2, n);

            if (idx1 == -1) {
                return nums2[mainBinser(nums2, nums1, n)];
            }

            return nums1[idx1];
        } else {

            Pair result1 = getMedian(nums1, nums2, n);
            double res = (double) result1.a != -1 ? nums1[result1.a] : nums2[result1.b];

            Pair result2 = getMedian(nums1, nums2, n-1);
            res = (double) result2.a != -1 ? res + nums1[result2.a] : res + nums2[result2.b];

            return (double) res/2;
        }
    }
}