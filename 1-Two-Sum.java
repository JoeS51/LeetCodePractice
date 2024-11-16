class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            System.out.println(temp);
            if (m.containsKey(temp)) {
                int[] res = new int[2];
                res[0] = i;
                res[1] = m.get(temp);
                return res;
            }
            System.out.println(nums[i] + " " + i);
            m.put(nums[i], i);
        }
        return new int[2];
    }
}