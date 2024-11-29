class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] freq = new int[nums.length];
        for (int[] query : queries) {
            freq[query[0]]++;
            if (query[1] + 1< nums.length) freq[query[1]+1]--;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += freq[i];
          //  System.out.print(freq[i] + " ");
          if (sum < nums[i]) return false; 
        }
        
        return true;
    }
}