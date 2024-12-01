class Solution {
    public int getLargestOutlier(int[] nums) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        int sum = 0;
        for (int i : nums) {
            sum += i;
            numsMap.put(i, numsMap.getOrDefault(i, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            int tempSum = sum - i;
            System.out.print(tempSum + " ");
            if (tempSum % 2 != 0) continue;
            if ((numsMap.containsKey(tempSum / 2) && tempSum/2 != i) || (numsMap.containsKey(tempSum / 2) && numsMap.get(tempSum / 2) > 1 && tempSum / 2 == i)) {
                max = Math.max(max, i);
            }
        }
        return max;
    }
}