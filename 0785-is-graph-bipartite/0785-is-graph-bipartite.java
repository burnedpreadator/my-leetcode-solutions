class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        for(int i=0; i<n; i++){
            if(colors[i] == 0){
                if(!dfsCheck(graph, colors, i, 1)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfsCheck(int[][] graph, int[] colors, int node, int colortoAsign){
        colors[node] = colortoAsign;

        for(int neighbor: graph[node]){
            if(colors[neighbor] == 0){
                if(!dfsCheck(graph, colors, neighbor, -colortoAsign)){
                    return false;
                }
            }
            else if(colors[neighbor] == colors[node]){
                return false;
            }
        }

        return true;
    }
}