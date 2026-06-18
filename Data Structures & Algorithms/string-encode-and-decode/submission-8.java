class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str: strs) {
            sb.append(str);
            sb.append(";");
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ';') {
                    res.add(sb.toString());
                    sb.setLength(0);
                } else sb.append(str.charAt(i));
            }
            
        return res;
    }
}
