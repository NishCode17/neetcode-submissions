class Solution {
    public boolean isPalindrome(String s) {
        String s2 = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int i=0;
        int j=s2.length()-1;

        while(i<j){
            if(s2.charAt(i)==s2.charAt(j)){
                i++;
                j--;
            }

            else {return false;}
        }

        return true;
    }
}
