class Solution {
    public int lengthOfLongestSubstring(String s) {

        if (s.isEmpty()){return 0;}

        int i=0;
        int j=1;
                
        HashSet<Character> set= new HashSet<>();
        set.add(s.charAt(i));
        int ans=1;

        while(j<s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                ans=Math.max(ans,j-i+1);
                j++;
            }

            else{
                set.remove(s.charAt(i));
                i++;
            }
        }

        return ans;
    }
}
