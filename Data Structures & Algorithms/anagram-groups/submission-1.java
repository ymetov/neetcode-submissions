class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Create a key, then add a string to the group with the correct key.
        Map<Map<Character, Integer>, List<String>> res = new HashMap<>();
        for (String str: strs) {
            res.computeIfAbsent(getKey(str), k-> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(res.values());
    }

    public Map<Character, Integer> getKey(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i), 1, Integer::sum);
        }
        return map;
    }
}
