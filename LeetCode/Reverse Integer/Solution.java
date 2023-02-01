class Solution {
    public int reverse(int x) {
        int nums[] = new int[10];
        boolean sign;
        if(x * -1 > 0){
            x *= -1;
            sign = false;
        }
        else{
            sign = true;
        }
        int j = 0;
        while(x > 0){
            nums[j] = (x % 10);
            x /= 10;
            j++;
        }
        int number = 0;
        int prevNum = 0;
        for(int i = 0; i < j; i++){
            number *= 10;
            number += nums[i];
            if(prevNum != number/10) return 0;
            prevNum = number;
        }
        int ret = (int)number;
        if(!sign) ret *= -1;
        return ret;
    }
}