class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int p1 = 0, p2 = s.length() - 1;
        while(p1 < p2) {
            while (p1 < p2 && !(s.charAt(p1) >= '0' && s.charAt(p1) <= '9') && !(s.charAt(p1) >= 'a' && s.charAt(p1) <= 'z')) {
                p1++;
            }
            while (p1 < p2 && !(s.charAt(p2) >= '0' && s.charAt(p2) <= '9') && !(s.charAt(p2) >= 'a' && s.charAt(p2) <= 'z')) {
                p2--;
            }
            if (p1 >= p2) break;
            if (s.charAt(p1++) != s.charAt(p2--)) {
                return false;
            }
        }
        return true;
    }
}
