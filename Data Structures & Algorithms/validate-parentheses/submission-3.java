class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Set<Character> closingSet = new HashSet<>();
        closingSet.add(')');
        closingSet.add(']');
        closingSet.add('}');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (closingSet.contains(ch)) {
                if (stack.isEmpty() || map.get(stack.peek()) != ch) return false;
                else stack.pop();
            } else {
                stack.add(ch);
            }
        }
        return stack.isEmpty();
    }
}
