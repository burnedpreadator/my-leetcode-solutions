class Solution {
    public int lastStoneWeight(int[] stones) {
        int maxWeight = 0;
        for(int stone: stones){
            maxWeight = Math.max(maxWeight, stone);
        }

        int[] simulation = new int[maxWeight + 1];
        for(int stone: stones){
            simulation[stone]++;
        }
        int simulatingHeap = 0;
        int curr = maxWeight;

        while(curr>0){
            if(simulation[curr] == 0){
                curr--;
                continue;
            }

            if(simulatingHeap == 0){
                if(simulation[curr]%2 == 1){
                    simulatingHeap = curr;
                }
                curr--;
            }else{
                simulation[curr]--;
                int diff = simulatingHeap - curr;
                if(diff >= curr){
                    simulatingHeap = diff;
                }else{
                    simulation[diff]++;
                    simulatingHeap = 0;
                }
            }
        }

        return simulatingHeap;
    }
}