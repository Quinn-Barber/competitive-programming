class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int[] count = new int[256];
        int i = 0;
        int j = 0;
        int maxLen = 0;

        while (j < s.length()) {
            count[s.charAt(j)]++;

            while (count[s.charAt(j)] > 1) {
                count[s.charAt(i)]--;
                i++;
            }
            maxLen = Math.max(maxLen, (j - i + 1));
            j++;

        }

        return maxLen;
    }
}