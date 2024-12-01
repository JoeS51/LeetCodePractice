class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] update : updates) {
            res[update[0]] += update[2];
            if (update[1] + 1 < length) res[update[1] + 1] -= update[2];
        }
        int[] modifiedArray = new int[length];
        int sum = 0;
        for (int i = 0; i < length; i++) {
            System.out.print(res[i] + \ \);
            sum += res[i];
            modifiedArray[i] = sum;
        }
        return modifiedArray;
    }
}