class Solution {
    public List<String> letterCombinations(String digits) {
        
        char[][] letters = new char[8][4];
        
        int asciiValue = 0;
        for(int i = 0; i < 8; i++){
            Arrays.fill(letters[i], '_');
            int n = 3;
            if(i == 5 || i == 7){
                n = 4;
            }
            for(int j = 0; j < n; j++, asciiValue++){
                letters[i][j] = (char)((int)'a' + asciiValue);
            }
        }
        
        if(digits.length() == 0) return new ArrayList<String>();
        
        return permutations(digits, letters, 0, new ArrayList<String>());
    }
    
    public List<String> permutations(String digits, char[][] letters,int i, List<String> curStrings){
        
        int curNum = Character.getNumericValue(digits.charAt(i));
        if(curStrings.size() == 0){
            for(int j = 0; j < 4; j++){
                if(letters[curNum-2][j] == '_') continue;
                String newStr = "" + letters[curNum-2][j];
                curStrings.add(newStr);
            }
        }
        else{
            List<String> newStrings = new ArrayList<String>();
            for(int j = 0; j < curStrings.size(); j++){
                for(int g = 0; g < 4; g++){
                    if(letters[curNum-2][g] == '_') continue;
                    String newStr = curStrings.get(j);
                    newStr += letters[curNum-2][g];
                    newStrings.add(newStr);
                }
            }
            curStrings = newStrings;
        }
        
        while((i+1) < digits.length()){
            return permutations(digits, letters, i+1, curStrings);
        }
        
        return curStrings;
        
    }
}