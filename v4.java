class Solution {
    public boolean isScramble(String s1, String s2) {
        HashMap<String, Boolean> hashMap = new HashMap();
        return IsScramble(s1, s2, hashMap);
    }
    
    public boolean IsScramble(String s1, String s2, HashMap<String, Boolean> hashMap)
    {
        if(s1.equals(s2)) // BC condition to check if single chars are equal or not
            return true;
        
        int [] count = new int[26]; // additional condition to check if the chars present in 
        //both the strings should be same order can be different but atleast the chars and 
        //count should be same else, there is no point to move further with this.
        for(int i=0;i<s1.length();i++)
        {
            count[s1.charAt(i)-'a']++;
            count[s2.charAt(i)-'a']--;
        }
        
        for(int i=0;i<26;i++)
        {
            if(count[i]!=0)
                return false;
        }
        
        String key = s1+" "+s2;
        //Here we are checking if already data is present in the dictionary or not if yes,
        //we can retrieve from here only
        if(hashMap.containsKey(key))
            return hashMap.get(key);
        
        for(int i=1;i<=s1.length()-1;i++)
        {
            int n = s1.length();
            //These are the 2 primary conditions
            //1) String from i to k can be compared with i to k from string 2 and
            //String from k+1 to j can be compare to k+1 of other string
            if(IsScramble(s1.substring(0,i), s2.substring(0,i), hashMap)
              && IsScramble(s1.substring(i), s2.substring(i), hashMap))
            {
                hashMap.put(key, true);
                return true;
            }
            ////1) String from i to k can be compared with n-i to n from string 2 and
            //String from k+1 to j can be compare to the first half of the other string
            if(IsScramble(s1.substring(0,i), s2.substring(n-i), hashMap)
              && IsScramble(s1.substring(i), s2.substring(0,n-i), hashMap))
            {
                hashMap.put(key, true);
                return true;
            }
            
        }
        hashMap.put(key, false);
        return false;
    }
}
        
       
