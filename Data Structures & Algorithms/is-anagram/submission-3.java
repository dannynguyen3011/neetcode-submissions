class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;  // increment for s
            count[t.charAt(i) - 'a']--;  // decrement for t
        }

        for (int c : count) {
            if (c != 0) return false;  // mismatch found
        }
        return true;
        //Time: O(n) — one pass through both strings
// Space: O(1) — the array is always size 26, regardless of input size
    }
}
