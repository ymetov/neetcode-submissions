class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int [][] pair = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        Arrays.sort(pair, (a,b) -> b[0] - a[0]);
        int count = 1;
        double timeToDest = timeToDest(target, pair[0]);
        for (int i = 1; i < speed.length; i++) {
            double localTimeToDest = timeToDest(target, pair[i]);
            if (localTimeToDest > timeToDest) {
                timeToDest = localTimeToDest;
                count++;
            }
        }
        
        return count;
    }

    public double timeToDest(int target, int[] pair) {
        int pos = pair[0];
        int speed = pair[1];
        double time = ((double) (target - pos) / speed);
        return time;
    }
}
