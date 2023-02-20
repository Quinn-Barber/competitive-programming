class Solution {
    public int maxSubArray(int[] nums) {
        
        int max = nums[0];
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max) max = nums[i];
            if(nums[i] < 0){
                continue;
            }
            int sum = nums[i];
            for(int j = i+1; j < nums.length; j++){
                sum += nums[j];
                if(sum <= 0){
                    i = j;
                    break;
                }
                else if(sum > max){
                    max = sum;
                }
                if(j == nums.length-1){
                    return max;
                }
            }
        }
        
        return max;
    }
}