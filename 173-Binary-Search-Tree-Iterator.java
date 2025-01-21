/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {

    List<TreeNode> list;
    int index;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        index = 0;
        helper(root, list);
    }
    
    public int next() {
       TreeNode n = list.get(index);
       index++;
       return n.val;
    }
    
    public boolean hasNext() {
       if (index < list.size()) {
        return true;
       }
       return false;
    }

    private void helper(TreeNode root, List<TreeNode> l) {
        if (root == null) return;
        helper(root.left, l);
        l.add(root);
        helper(root.right, l);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */