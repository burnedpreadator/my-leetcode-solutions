class Solution {
    private HashSet<String> set = new HashSet<>();
    public int numTilePossibilities(String tiles) {
        int n = tiles.length();
        boolean[] visited = new boolean[n];
        backtracking(visited, tiles,  n, new StringBuilder());
        return set.size();
    }

    private void backtracking(boolean[] visited, String tiles, int n, StringBuilder pair){
        if(pair.length() == n) return;
        for(int i=0 ; i<n; i++){
            if(visited[i]) continue;
            visited[i]= true;

            char c = tiles.charAt(i);
            pair.append(c);
            if(!set.contains(pair)){
                set.add(pair.toString());
            }

            backtracking(visited, tiles, n, pair);
            visited[i] = false;
            pair.setLength(pair.length() - 1);
        }
    }
}