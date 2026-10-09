class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int maxSum = nums[0] + nums[1] + nums[2];
        int n = nums.length;
        for(int i=0; i<n-2; i++){
            for(int j=i+1; j<n-1; j++){
                for(int k=j+1; k<n; k++){
                    int currSum = nums[i]+nums[j]+nums[k];
                    if(Math.abs(target-currSum) < Math.abs(target-maxSum)){
                        maxSum = currSum;
                    }
                }
            }
        }

        return maxSum;
    }
}