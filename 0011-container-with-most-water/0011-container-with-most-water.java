class Solution {
    public int maxArea(int[] height) {
        int l=0;
        int r=height.length-1;
        int maxContainer = 0;

        while(l<r){
            int dist = r-l;
            int vol = Math.min(height[l], height[r])*dist;
            maxContainer = Math.max(vol, maxContainer); 

            if(height[l]<height[r]){
                l++;
            }else{
                r--;
            }
            
        }
        return maxContainer;
    }
}