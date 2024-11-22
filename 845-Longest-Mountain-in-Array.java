class Solution {
    public int longestMountain(int[] arr) {
        int left = 0;
        int longestMountain = 0;
        while (left < arr.length-2) {
            int right = left + 1;
            if (arr[left] >= arr[right]) {
                left++;
                continue;
            }
            boolean rising = true;
            while (rising) {
                if (right+1 < arr.length && arr[right] < arr[right+1]) right++;
                else rising = false;
            }
            boolean falling = true;
            while (falling) {
                if (right+1 < arr.length && arr[right] > arr[right+1]) {
                    right++;
                    longestMountain = Math.max(longestMountain, right - left + 1);
                } else {
                    falling = false;
                    left = right;
                }
            }
        }
        return longestMountain;
    }
}