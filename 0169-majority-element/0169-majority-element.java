class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        int n = nums.length;
        for(int i=1; i<n; i++){
            if(count == 0){
                candidate = nums[i];
                count = 1;
                continue;
            }

            if(candidate == nums[i]){
                count++;
            }else {
                count--;
            }
        }
        return candidate;
    }
}