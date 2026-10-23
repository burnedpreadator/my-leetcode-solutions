class Solution:
    def restoreIpAddresses(self, s: str) -> list[str]:
        result = []

        def backtracking(start: int, current_path: list[str]):
            if len(current_path) == 4:
                if(start == len(s)):
                    result.append(".".join(current_path))
                return

            for length in range(1, 4):
                if start + length > len(s):
                    break
                
                segment = s[start : start + length]

                if len(segment)>1 and segment[0] == '0':
                    break

                if int(segment)> 255:
                    continue

                current_path.append(segment)
                backtracking(start+length, current_path)
                current_path.pop()

        backtracking(0, [])
        return result