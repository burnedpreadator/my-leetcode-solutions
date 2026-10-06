class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();

        boolean[] visited = new boolean[n];
        int visitedCount=1;
        visited[0] = true;

        Queue<Integer> queue = new LinkedList<>();
        for (int key : rooms.get(0)) {
            if (!visited[key]) {
                visited[key] = true;
                visitedCount++;
                queue.add(key);
            }
        }

        while(!queue.isEmpty()){
            int curr = queue.poll();

            for(int key: rooms.get(curr)){
                if(!visited[key]){
                    visited[key] = true;
                    visitedCount++;
                    queue.add(key);
                }
            }
        }

        return visitedCount == n;
    }
}