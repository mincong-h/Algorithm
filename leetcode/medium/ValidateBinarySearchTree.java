/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return root == null
            || (isValid(root.left, null, root.val)
                && isValid(root.right, root.val, null));
    }

    /**
     * Is binary search tree valid?
     *
     * @param root the tree node
     * @param min left boundary, null if no boundary
     * @param max right boundary, null if no boundary
     * @return is BST valid
     */
    private boolean isValid(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min) {
            return false;
        }
        if (max != null && root.val >= max) {
            return false;
        }
        return isValid(root.left, min, root.val)
            && isValid(root.right, root.val, max);
    }
}
