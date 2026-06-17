class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> set = new HashMap<>();
        set.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            int sum = target - nums[i];
            if (set.containsKey(sum)) {
                return new int[] {set.get(sum), i};
            } else {
                set.put(nums[i], i);
            }
        }
        return new int[] {0, 0};
    }
}
