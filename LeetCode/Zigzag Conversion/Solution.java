class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        String ret = "";
        int rows[] = new int[s.length()];
        int curRow = 1;
        boolean goingDown = true;
        for(int i = 0; i < s.length(); i++){
            rows[i] = curRow;
            if(curRow == numRows || curRow == 1){
                goingDown = !goingDown;
            }
            if(goingDown){
                curRow--;
            }
            else{
                curRow++;
            }
        }
        curRow = 1;
        while(numRows > 0){
            for(int i = 0; i < rows.length; i++){
                if(rows[i] == curRow){
                    ret += s.charAt(i);
                }
            }
            numRows--;
            curRow++;
        }
        return ret;
    }
}