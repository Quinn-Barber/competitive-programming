class Solution {
    public String longestPalindrome(String s) {
        String longest = "" + s.charAt(0);
        for(int i = 0; i < s.length()-1; i++){
            String oddPalindrome = isPalindrome(s, i, i);
            if(oddPalindrome.length() > longest.length()){
                longest = oddPalindrome;
            }
            String evenPalindrome = isPalindrome(s, i, i+1);
            if(evenPalindrome.length() > longest.length()){
                longest = evenPalindrome;
            }
        }
        return longest;
    }
    
    public String isPalindrome(String s, int sIdx, int eIdx){
        if(sIdx < 0 || eIdx == s.length() || s.charAt(sIdx) != s.charAt(eIdx)){
            return s.substring(sIdx+1, eIdx);
        }
        return isPalindrome(s, sIdx-1, eIdx+1);
    }
}