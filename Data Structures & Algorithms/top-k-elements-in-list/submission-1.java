class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();        
        for (int num: nums) countMap.merge(num, 1, Integer::sum);
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> 
            Integer.compare(a.getValue(), b.getValue()));
        for (Map.Entry entry: countMap.entrySet()) {
            pq.add(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] res = new int[k]; 
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll().getKey();
        }
        return res;
    }
}
