class Solution {
    public List<String> letterCombinations(String digits) {
        List<String>ans=helper("",digits);
        if (ans.contains("")){
            ans.remove("");
        }
        return ans;
        
    }
    
    static List<String> helper(String p, String up){
        if (up.isEmpty()){
            ArrayList<String>data = new ArrayList<>();
            data.add(p);
            return data;
        }
        int digit = up.charAt(0)-'0';
        int i = (digit-2)*3;
        //example: digit =2
        // 2
        //a  b  c
          // 2  3  4
    //start loop from 2 till 5
        if (digit>7){
            i++;
        }
        int len=i+3;
        if (digit==7 || digit==9){
            len++;
        }
        ArrayList<String>list = new ArrayList<>();
        for (; i <len; i++) {
            char ch = (char)('a'+i);
            list.addAll(helper(p+ch, up.substring(1)));
        }
        return list;
    }
}s

        
