class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        // Building the frequency arrays for both ofthem
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        // first count
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == s2Count[i]) {
                matches++;
            }
        }

        int left = 0;

        for (int right = s1.length(); right < s2.length(); right++) {

            if (matches == 26) {
                return true;
            }

            // Add next character
            int index = s2.charAt(right) - 'a';
            s2Count[index]++;

            if (s2Count[index] == s1Count[index]) {
                matches++;
            } else if (s2Count[index] == s1Count[index] + 1) {
                matches--;
            }

            // Remove first character
            index = s2.charAt(left) - 'a';
            s2Count[index]--;

            if (s2Count[index] == s1Count[index]) {
                matches++;
            } else if (s2Count[index] == s1Count[index] - 1) {
                matches--;
            }

            left++;
        }

        return matches == 26;
    }
}