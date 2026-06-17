class Solution {
    public boolean isAnagram(String s, String t) {
        char[] setS = new char[26];
        char[] setT = new char[26];
        initSet(s, setS);
        initSet(t, setT);
        for (int i = 0; i < 26; i++) {
            if (setS[i] != setT[i]) return false;
        }
        return true;
    }

    public void initSet(String str, char[] set) {
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            set[index]++;
        }
    } 
}
