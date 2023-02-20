class Solution {
    public boolean canJump(int[] nums) {
        
        if(nums.length == 1) return true;
        
        for(int i = nums.length-1; i >= 0; i--){
            if(nums[i] == 0){
                boolean canJump = false;
                for(int j = 0; j < i; j++){
                    if(nums[j]+j > i){
                        canJump = true;
                        break;
                    }
                    else if(nums[j]+j == i && i == nums.length-1){
                        canJump = true;
                        break;
                    }
                }
                if(!canJump) return false;
            }
        }
        
        return true;
    }
}