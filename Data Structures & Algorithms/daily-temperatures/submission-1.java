class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int size = temperatures.length;
        int[] res = new int[size];

        for (int i = size - 1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek()[1] <= temperatures[i]) {
                stack.pop();
            }
            
            if (!stack.isEmpty()) {
                res[i] = stack.peek()[0] - i;
            }
            stack.push(new int[] {i, temperatures[i]});
        }

        return res;
    }
}
