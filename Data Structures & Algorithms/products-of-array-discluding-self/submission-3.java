class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] preMultiple = new int[nums.length];
        preMultiple[0] = 1;
        for (int i = 1; i < nums.length; i++) {
           preMultiple[i] = preMultiple[i-1] * nums[i-1]; 
        }
        int multiplier = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            int res = multiplier * preMultiple[i];
            multiplier *= nums[i];
            nums[i] = res;
        }
        return nums;
    }
}  