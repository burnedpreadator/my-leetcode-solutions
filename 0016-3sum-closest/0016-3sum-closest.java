class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int minSum = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0; i<n-2; i++){
            int l = i+1;
            int r = n-1;
            while(l<r){
                int temp = nums[i]+nums[l]+nums[r];
                if (temp == target) {
                    return temp;
                }

                if (Math.abs(target - temp) < Math.abs(target - minSum)) {
                    minSum = temp;
                }

                if(temp > target){
                    r--;
                }else{
                    l++;
                }
            }
        }

        return minSum;
    }
}