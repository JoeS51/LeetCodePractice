class Solution {
    Map<Integer, List<Integer>> map;
    public Solution(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                List<Integer> l = new ArrayList<>();
                map.put(nums[i], l);
            }
            map.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        Random random = new Random();
        List<Integer> validIndices = map.get(target);
        int i = random.nextInt(validIndices.size());
        return validIndices.get(i);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */