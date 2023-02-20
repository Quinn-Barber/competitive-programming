class Solution {
    public int maxArea(int[] height) {
        int maxVol = Integer.MIN_VALUE;
        int high, low;
        low = 0;
        high = height.length-1;
        while(low < high){
            int h = Math.min(height[low], height[high]);
            maxVol = Math.max(maxVol, h*(high-low));
            
            if(height[low] < height[high]){
                low++;
            }
            else{
                high--;
            }
        }
        return maxVol;
    }
}