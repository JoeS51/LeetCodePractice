class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        TreeSet<Integer> ts = new TreeSet<>();
        int min = Integer.MAX_VALUE;
        for (int i = x; i < nums.size(); i++) {
            ts.add(nums.get(i-x));
            Integer ceil = ts.ceiling(nums.get(i));
            Integer floor = ts.floor(nums.get(i));
            if (ceil != null) min = Math.min(min, ceil - nums.get(i));
            if (floor != null) min = Math.min(min, nums.get(i) - floor);
        }
        return min;
    }
}