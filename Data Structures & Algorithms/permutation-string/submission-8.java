class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] map1 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            char ch1 = s1.charAt(i);
            map1[ch1-'a']++;
        }
        int[] map2 = new int[26];
        int l = 0, r = 0, match = 0;
        while (r < s2.length()) {
            if (map1[s2.charAt(r)-'a'] == 0 && match == 0) {
                r++;
                l = r;
                continue;
            } else if (map1[s2.charAt(r)-'a'] == 0 && match != 0) {
                while(map1[s2.charAt(r)-'a'] == 0 && match != 0) {
                    map1[s2.charAt(l)-'a']++;
                    match--;
                    l++;
                }
                continue;
            }
            map1[s2.charAt(r)-'a']--;
            match++;
            r++;
            if (match == s1.length()) return true;
        }
        return false;
    }
}
