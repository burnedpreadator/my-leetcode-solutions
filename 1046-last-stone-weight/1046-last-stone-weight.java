class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone:stones){
            queue.add(stone);
        }
        int curr = queue.peek();

        while(!queue.isEmpty()){
            curr = queue.poll();
            int next = 0;
            if(queue.size() >= 1){
                next = queue.poll();
            }else{
                return curr;
            }
            if(curr-next != 0){
                queue.add(curr-next);
            }
        }

        return 0;
    }
}