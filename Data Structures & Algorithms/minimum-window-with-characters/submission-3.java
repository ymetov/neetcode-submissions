class Solution {
    public String minWindow(String s, String t) {
        int count = 0;
        Map<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = 0;
        int[] res = new int[] {0, s.length() + 5};
        while (r < s.length()) {
            char c = s.charAt(r);
            if (tMap.containsKey(c)) {
                tMap.put(c, tMap.get(c) - 1);
                if (tMap.containsKey(c) && tMap.get(c) == 0) {
                    count++;
                }
            }


            while(count == tMap.size()) {
                if (res[1] - res[0] > r - l) {
                    res[0] = l;
                    res[1] = r;
                }
                if (tMap.containsKey(s.charAt(l))) {
                    tMap.put(s.charAt(l), tMap.get(s.charAt(l)) + 1);
                    if (tMap.get(s.charAt(l)) > 0) {
                        count--;
                    }
                }
                l++;
            }

            r++;
        }

        return res[1] > s.length() ? "" : s.substring(res[0], res[1] + 1);
    }
}


