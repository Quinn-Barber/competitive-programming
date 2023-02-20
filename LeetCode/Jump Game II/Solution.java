class Solution {
    public int jump(int[] nums) {
        int k = nums.length-1; 
        int count = 0;
        while(k!=0){
            for(int i = 0;i<nums.length;i++){ 
                if(nums[i]>= k-i) { 
                    k = i;
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}