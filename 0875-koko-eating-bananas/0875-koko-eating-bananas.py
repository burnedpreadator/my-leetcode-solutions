class Solution:
    def minEatingSpeed(self, piles: list[int], h: int) -> int:
        low = 1
        high = max(piles)
        result = high
        while(low<=high):
            mid = (high+low)//2
            time_taken = 0

            for pile in piles:
                time_taken += (pile+mid-1)//mid

            if time_taken <= h:
                result = mid
                high = mid-1
            else:
                low = mid+1

        return result

