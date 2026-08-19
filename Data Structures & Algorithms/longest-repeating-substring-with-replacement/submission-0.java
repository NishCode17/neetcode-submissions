class Solution {
    public int characterReplacement(String s, int k) {
        int left=0;
        int[] freq=new int[26];

        int mxFreq=0;
        int mxLength=0;

        for(int right=0; right<s.length(); right++){
            char curr= s.charAt(right);
            freq[curr-'A']++;

            mxFreq=Math.max(mxFreq, freq[curr-'A']);

            while ((right - left + 1) - mxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            mxLength=Math.max(mxLength,right-left+1);
        }

        return mxLength;
    }
}
