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

    class QueueNode {
        TreeNode node;
        Integer min;
        Integer max;

        QueueNode(TreeNode node, Integer min, Integer max) {
            this.node = node;
            this.min = min;
            this.max = max;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if(root == null) return false;

        Queue<QueueNode> queue = new LinkedList<>();
        queue.add(new QueueNode(root, null, null));

        while(!queue.isEmpty()){
            QueueNode curr = queue.poll();
            TreeNode node = curr.node;
            Integer min = curr.min;
            Integer max = curr.max;

            if((min != null && node.val <= min) || (max != null && node.val >= max)){
                return false;
            }

            if(node.left!=null){
                queue.add(new QueueNode(node.left, min, node.val));
            }

            if(node.right!=null){
                queue.add(new QueueNode(node.right, node.val, max));
            }

        }

        return true;
    }

}