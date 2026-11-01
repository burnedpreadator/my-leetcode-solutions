class Solution {
    private HashSet<String> set = new HashSet<>();
    public int numTilePossibilities(String tiles) {
        int n = tiles.length();
        int[] arr = new int[26];
        for(char c : tiles.toCharArray()){
            arr[c-'A']++;
        }
        return backtracking(arr);
    }

    private int backtracking(int[] count){
        int sum = 0;
        for(int i=0 ; i<26; i++){
            if(count[i] == 0) continue;

            sum++;
            count[i]--;
            sum+=backtracking(count);
            count[i]++;
        }

        return sum;
    }
}