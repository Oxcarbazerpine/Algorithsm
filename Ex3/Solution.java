package Ex3;

import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int startIdx = 0;

        for (int i = 0; i < s.length(); i++) {

            char nowChar = s.charAt(i);
            Integer firstIdx = map.get(nowChar);

            if (firstIdx != null && firstIdx >= startIdx) {
                startIdx = firstIdx + 1;
            }
            int len = i - startIdx + 1;
            if (len > maxLen) {
                maxLen = len;
            }
            map.put(nowChar, i);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "  ";
        System.out.println(sol.lengthOfLongestSubstring(s));
    }
}
