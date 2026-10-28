class Solution:
    def makesquare(self, matchsticks: list[int]) -> bool:
        n = len(matchsticks)
        total_sum = sum(matchsticks)
        if total_sum%4 != 0: return False

        side = total_sum//4
        matchsticks.sort(reverse = True)

        if matchsticks[0]>side: return False

        sides  = [0]*4

        def backtracking(idx: int):
            if idx == len(matchsticks):
                return True
            
            matchstick = matchsticks[idx]
            for i in range(4):
                if sides[i]+matchstick <= side:
                    sides[i]+=matchstick
                    if backtracking(idx+1):
                        return True

                    sides[i]-=matchstick

                if sides[i] == 0:
                    return False

            return False

        return backtracking(0)