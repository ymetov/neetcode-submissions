class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;

        int p1 = 0, p2 = 1;
        while(p2 < prices.length) {
            if (prices[p1] < prices[p2]) {
                int sum = prices[p2] - prices[p1];
                if (sum > max) max = sum;
            } else {
                p1 = p2;
            } 
            p2++;
        }

        return max;
    }
}
