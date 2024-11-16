class Solution {
    public int rob(int[] nums) {
        int max1 = 0;
        int max2 = 0;
        if (nums.length == 1) return nums[0];
        int[] dp1 = new int[nums.length-1];
        int[] dp2 = new int[nums.length-1];
        int prev = 0;
        dp1[0] = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            if (i > 1) prev = dp1[i-2];
            dp1[i] = Math.max(nums[i] + prev, dp1[i-1]);
        }
        prev = 0;
        dp2[0] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            if (i > 2) prev = dp2[i-3];
            dp2[i-1] = Math.max(nums[i] + prev, dp2[i-2]);
        }
        return Math.max(dp1[dp1.length - 1], dp2[dp2.length - 1]);
    }
}