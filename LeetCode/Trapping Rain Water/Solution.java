class Solution {
    public int trap(int[] height) {
        int waterTrapped = 0;
        if (height.length <= 2)
            return waterTrapped;
        int max = height[0];
        ArrayList<Integer> lower = new ArrayList<>();
        for (int i = 1; i < height.length; i++) {
            if (height[i] >= max) {
                for (int j = 0; j < lower.size(); j++) {
                    waterTrapped += max - lower.get(j);
                }
                lower = new ArrayList<>();
                max = height[i];
            } else {
                lower.add(height[i]);
            }
        }
        max = height[height.length - 1];
        lower = new ArrayList<>();
        for (int i = height.length - 2; i >= 0; i--) {
            if (height[i] > max) {
                for (int j = 0; j < lower.size(); j++) {
                    waterTrapped += max - lower.get(j);
                }
                lower = new ArrayList<>();
                max = height[i];
            } else {
                lower.add(height[i]);
            }
        }
        return waterTrapped;
    }
}