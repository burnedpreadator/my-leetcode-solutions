class Solution {
    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int total = Arrays.stream(nums).sum();
        if (total%2 != 0) return false;

        int bucketsize = total/2;
        Boolean[][] memo = new Boolean[nums.length][bucketsize+1];

        return backtracking(0, bucketsize, nums, memo);
    }

    private boolean backtracking(int idx, int bsize, int[] nums, Boolean[][] memo){
        if(bsize == 0) return true;
        if(bsize < 0 || idx >= nums.length) return false;

        if(memo[idx][bsize] != null){
            return memo[idx][bsize];
        }

        boolean cont = backtracking(idx+1, bsize - nums[idx], nums, memo);

        boolean skip = backtracking(idx+1, bsize, nums, memo);

        memo[idx][bsize] = cont || skip;

        return cont||skip;
    }
}