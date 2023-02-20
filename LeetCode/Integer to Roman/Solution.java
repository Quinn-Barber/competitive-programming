class Solution {
    public String intToRoman(int num) {
        String numbers[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int nums[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String roman = "";
        for(int i = 0; i < 13; i++){
            while(num >= nums[i]){
                roman += numbers[i];
                num -= nums[i];
            }
        }
        return roman;
    }
}