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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> zigzag= new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flip = true;
        
        while(!queue.isEmpty()){
            int queueLength = queue.size();
            List<Integer> currlist = new ArrayList<>();

            for(int i=0; i < queueLength; i++){
                TreeNode curr = queue.poll();
                if(flip){
                    currlist.add(curr.val);
                }else{
                    currlist.add(0, curr.val);
                }

                if(curr.left != null) queue.add(curr.left);
                if(curr.right!=null) queue.add(curr.right);
            }

            zigzag.add(currlist);
            flip = !flip;
        }

        return zigzag;
    }
}