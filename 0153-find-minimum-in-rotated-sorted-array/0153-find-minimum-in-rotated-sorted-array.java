class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int smallest = Integer.MAX_VALUE;
        while(left <= right){
            int mid = left+(right-left)/2;
            if(nums[mid] >= nums[left]){
                //left side is sorted check if number exists on left side
                smallest = Math.min(smallest, nums[left]);
                left = mid+1;
            }else{
                smallest = Math.min(smallest, nums[mid]);
                right = mid-1;
            }
        }
        return smallest;
    }
}