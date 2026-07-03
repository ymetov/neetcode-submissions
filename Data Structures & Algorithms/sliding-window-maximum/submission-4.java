class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        };
        int[] res = new int[nums.length - k + 1];
        res[0] = pq.peek();
        for (int i = 1; i < res.length; i++) {
            pq.remove(nums[i-1]);
            pq.add(nums[i+k-1]);
            res[i] = pq.peek();
        }
        return res;
    }
}
