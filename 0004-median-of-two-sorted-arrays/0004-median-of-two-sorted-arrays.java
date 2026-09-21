class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array to minimize binary search range
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int m = nums1.length;
        int n = nums2.length;
        int halfLen = (m + n + 1) / 2;
        
        int left = 0;
        int right = m;
        
        while (left <= right) {
            int i = left + (right - left) / 2;
            int j = halfLen - i;
            
            // Boundary conditions for nums1
            int nums1LeftMax = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int nums1RightMin = (i == m) ? Integer.MAX_VALUE : nums1[i];
            
            // Boundary conditions for nums2
            int nums2LeftMax = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2RightMin = (j == n) ? Integer.MAX_VALUE : nums2[j];
            
            // Check if we found the correct partition
            if (nums1LeftMax <= nums2RightMin && nums2LeftMax <= nums1RightMin) {
                // If total length is odd
                if ((m + n) % 2 == 1) {
                    return Math.max(nums1LeftMax, nums2LeftMax);
                }
                // If total length is even
                return (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2.0;
            } 
            else if (nums1LeftMax > nums2RightMin) {
                // We are too far right in nums1, move left
                right = i - 1;
            } 
            else {
                // We are too far left in nums1, move right
                left = i + 1;
            }
        }
        
        return 0.0;
    }
}
