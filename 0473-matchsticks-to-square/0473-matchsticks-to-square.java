class Solution {
    private int[] sides = new int[4];
    public boolean makesquare(int[] matchsticks) {
        int n = matchsticks.length;
        int total_ln = Arrays.stream(matchsticks).sum();
        if(total_ln%4 != 0) return false;
        int side_length = total_ln/4;
        if(matchsticks[0] > side_length) return false;
        return backtracking(0, matchsticks, side_length);
    }

    private boolean backtracking(int idx, int[] matchsticks, int side_length){
        if(idx == matchsticks.length){
            return true;
        }
        int matchstick = matchsticks[idx];
        for(int i=0; i<sides.length; i++){
            if(sides[i]+matchstick <= side_length){
                sides[i]+=matchstick;
                if(backtracking(idx+1, matchsticks, side_length)){
                    return true;
                }
                sides[i]-=matchstick;
            }

            if(sides[i] == 0) return false;
        }

        return false;
    }
}