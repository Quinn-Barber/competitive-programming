class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        int n= nums.length;
        // sorting the array to use two pointer approach
        Arrays.sort(nums);
        // looping till 3rd last only as we have to find triplet
        for(int i=0;i<n-2;i++){
            // if two equal numbers are there we skip one of them
            if(i==0 || (i>0 && nums[i]!=nums[i-1])){
                int low= i+1;
                int high = n-1;
                // we have to find a+b= -(a+b) in case to make sum of them equal to 0
                int sum = 0-nums[i];
                while(low<high){
                    if(nums[low]+nums[high]==sum){
                        ans.add(Arrays.asList(nums[i],nums[low],nums[high]));
                        // if numbers are same we skip them
                        while(low<high && nums[low]==nums[low+1]) low++;
                        while(low<high && nums[high]==nums[high-1]) high--;
                        low++;
                        high--; 
                    }
                    else if(nums[low]+nums[high]>sum) high--;
                    else low++;
                }
                
            }
        }
        return ans;
    }
}