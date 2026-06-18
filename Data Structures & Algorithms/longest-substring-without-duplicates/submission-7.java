class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        Set<Character> charSet = new HashSet<>();
        char[] chars = s.toCharArray();

        charSet.add(chars[0]);

        int p1 = 0, p2 = 1;

        int max = 1;

        while (p2 < s.length()) {
            if (!charSet.contains(chars[p2])) {
                charSet.add(chars[p2]);
                if (max < charSet.size()) max = charSet.size();
            } else {
                while (charSet.contains(chars[p2])) {
                    charSet.remove(chars[p1]);
                    p1++;
                }
                charSet.add(chars[p2]);
                if (max < charSet.size()) max = charSet.size();
            } 

            p2++;
        }

        return max;
    }
}
