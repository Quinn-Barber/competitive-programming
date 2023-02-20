class Solution {
    public static List<String> curList;
    public List<String> generateParenthesis(int n) {
        /* 
         from 0 to n current number of open paren
         from 0 to n current number of close paren
         
         from each step, can only put open or close paren
         can only place close paren if current open > current close
         can only place open if current open < n
         
         go forward each step, skip if impossible
         */
        curList = new ArrayList<>();
        permutation(0, 0, n, "");
        return curList;
    }
    public void permutation(int open, int close, int n, String curStr){
        if(open == close && open == n){
            curList.add(curStr);
        }
        else{
            if(open < n){
                permutation(open+1, close, n, curStr+"(");
            }
            if(close < open){
                permutation(open, close+1, n, curStr+")");
            }
        }
    }
}