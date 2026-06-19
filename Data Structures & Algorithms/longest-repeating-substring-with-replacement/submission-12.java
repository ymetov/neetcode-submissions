class Solution {
    public int characterReplacement(String s, int k) {
        if (s.length() < 2) {
            return 1;
        }
        // ABBB
        Map<Character, Integer> map = new HashMap<>();
        int left = 0; int freq = 1;
        int max = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            freq = Math.max(freq, map.get(ch));

            while(right - left - freq + 1 > k) {
                char chL = s.charAt(left);
                map.put(chL, map.getOrDefault(chL, 0) - 1);
                left++;
            }

            max = Math.max(right - left + 1, max);
        }
        return max;
    }
}
