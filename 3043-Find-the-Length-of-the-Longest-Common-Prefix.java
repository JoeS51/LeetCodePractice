class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        TrieNode root1 = new TrieNode();
        TrieNode root2 = new TrieNode();
        makeTrie(arr1, root1);
        makeTrie(arr2, root2);
        return findLongestPath(root1, root2);
    }

    private void makeTrie(int[] arr1, TrieNode root) {
        for (int i = 0; i < arr1.length; i++) {
            String number = arr1[i] + "";
            TrieNode tempRoot = root;
            for (char num : number.toCharArray()) {
                int currNum = Character.getNumericValue(num);
                if (tempRoot.children[currNum] != null) tempRoot = tempRoot.children[currNum];
                else {
                    TrieNode temp = new TrieNode();
                    tempRoot.children[currNum] = temp;
                    tempRoot = temp;
                }
                
            }
        }
    }

    private int findLongestPath(TrieNode root1, TrieNode root2) {
        if (root1 == null || root2 == null) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < 10; i++) {
            TrieNode child1 = root1.children[i];
            TrieNode child2 = root2.children[i];
            if (child1 != null && child2 != null) {
                max = Math.max(max, 1 + findLongestPath(child1, child2));
            }
        }
        return max;
    }

    class TrieNode {
        TrieNode[] children;
        TrieNode () {
            children = new TrieNode[10];
        }
    }
}