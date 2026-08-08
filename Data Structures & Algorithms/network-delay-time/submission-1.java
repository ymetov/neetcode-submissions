class Solution {

    // build adjList
    // start with node k, pick cheapest path, repeat
    // check if we visited all notdes 
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for (int[] time: times) {
            int nodeA = time[0];
            int nodeB = time[1];
            int cost = time[2];
            adjList.putIfAbsent(nodeA, new ArrayList<>());
            adjList.get(nodeA).add(new int[]{nodeB, cost});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.add(new int[] {k, 0});
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        int cost = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            cost = curr[1];

            for (int[] next: adjList.getOrDefault(node, List.of())) {
                if (cost + next[1] < dist[next[0]]) {
                    pq.add(new int[] {next[0], next[1] + cost});
                    dist[next[0]] = cost + next[1];
                }
            }
        }
        int max = 0;
        for (int i = 1; i < dist.length; i++) {
            max = Math.max(max, dist[i]);
        }
        return max == Integer.MAX_VALUE ? -1 : max;
    }
}