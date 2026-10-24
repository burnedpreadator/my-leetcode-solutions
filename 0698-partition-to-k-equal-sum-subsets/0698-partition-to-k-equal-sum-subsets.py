class Solution:
    def canPartitionKSubsets(self, nums: list[int], k: int) -> bool:
        total_sum = sum(nums)
        if total_sum % k != 0:
            return False

        target = total_sum // k
        nums.sort(reverse=True)

        if nums[0] > target:
            return False

        subsets = [0]*k

        def backtracking(index: int)->bool:
            if(index == len(nums)):
                return True

            num = nums[index]
            
            for i in range(k):
                if subsets[i]+num <= target:
                    subsets[i] += num
                    if(backtracking(index+1)):
                        return True

                    subsets[i] -= num

                if subsets[i] == 0:
                    break
            
            return False

        return backtracking(0)