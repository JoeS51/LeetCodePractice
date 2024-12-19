class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length;
        int[] newArr = new int[len * len];
        int ind = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                newArr[ind] = matrix[i][j];
                ind++;
            }
        }
        Arrays.sort(newArr);
        return newArr[k-1];
    }
}