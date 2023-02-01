class Solution {
    public int myAtoi(String s) {
        if(s.length() == 0) return 0;
        int i = 0;
        int number[] = new int[s.length()];
        while(s.charAt(i) == ' '){
            i++;
            if(i >= s.length()) return 0;
        }
        boolean sign = true;
        if(s.charAt(i) == '-'){
            sign = false;
            i++;
        }
        if(i >= s.length()) return 0;
        if(s.charAt(i) == '+'){
            if(sign == false) return 0;
            i++;
        }
        int j = 0;
        if(i >= s.length()) return 0;
        while(Character.isDigit(s.charAt(i))){
            number[j] = Character.getNumericValue(s.charAt(i));
            i++;
            j++;
            if(i >= s.length()) break;
        }
        
        int h = 0;
        int num = 0;
        int prevNum = 0;
        
        while(h < j){
            num *= 10;
            num += number[h];
            if(prevNum != num/10){
                if(sign) return 2147483647;
                return -2147483648;
            }
            prevNum = num;
            h++;
        }
        if(!sign) num *= -1;
        return num;
    }
}