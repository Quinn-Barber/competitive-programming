class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        StringBuilder sb = new StringBuilder();
        String prev = "1";
        
        for(int i = 1; i < n; i++){
            
            StringBuilder apnd = new StringBuilder();
            int cnt = 0;
            char curNum = prev.charAt(0);
            
            for(int j = 0; j <= prev.length(); j++){
                if(j == prev.length()){
                    apnd.append(cnt);
                    apnd.append(curNum);
                    break;
                }
                if(prev.charAt(j) == curNum){
                    cnt++;
                }
                else{
                    apnd.append(cnt);
                    apnd.append(curNum);
                    cnt = 1;
                    curNum = prev.charAt(j);
                }
            }
            prev = apnd.toString();
            if(i == n-1){
                sb.append(apnd.toString());
            }
        }
        return sb.toString();
    }
}