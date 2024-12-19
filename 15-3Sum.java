class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> threeSums = new ArrayList<>();

        for (int i = 0; i < nums.length-2; i++) {
            if (i > 0) {
                if (nums[i] == nums[i-1]) continue;
            }
            int currNum = nums[i];
            // find numbers that addded together will get currNum to 0
            int target = 0 - currNum;
            int lo = i + 1;
            int hi = nums.length - 1;
            while (lo < hi) {
                int loNum = nums[lo];
                int hiNum = nums[hi];
                int total = loNum + hiNum;
                if (total == target) {
                    List<Integer> validList = new ArrayList<>();
                    validList.add(currNum);
                    validList.add(loNum);
                    validList.add(hiNum);
                    threeSums.add(validList);
                    int newLo = lo+1;
                    while (newLo < nums.length && nums[newLo] == nums[lo]) {
                        newLo++;
                    }
                    lo = newLo;
                    int newHi = hi-1;
                    while (newHi >= 0 && nums[hi] == nums[newHi]) {
                        newHi--;
                    }
                    hi = newHi;
                } else if (total < target) {
                    int newLo = lo+1;
                    while (newLo < nums.length && nums[newLo] == nums[lo]) {
                        newLo++;
                    }
                    lo = newLo;
                } else {
                    int newHi = hi-1;
                    while (newHi >= 0 && nums[hi] == nums[newHi]) {
                        newHi--;
                    }
                    hi = newHi;
                }
            }
        }

        return threeSums;
    }
}