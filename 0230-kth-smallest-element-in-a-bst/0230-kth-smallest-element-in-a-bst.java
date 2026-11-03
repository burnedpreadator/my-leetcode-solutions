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
class Solution {
    private int count = 0;
    private int result = -1;
    public int kthSmallest(TreeNode root, int k) {
        /** calculate the total length of th bst (brute force) */
        count = k;
        calculatelen(root);
        return result;
    }

    private void calculatelen(TreeNode node){
        if(node == null){
            return;
        }
        calculatelen(node.left);

        count--;
        if(count == 0){
            result = node.val;
            return;
        }

        if(count>0){
            calculatelen(node.right);
        }
    }
}