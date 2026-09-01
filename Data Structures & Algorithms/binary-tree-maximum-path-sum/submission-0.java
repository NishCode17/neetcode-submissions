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

    int maxSum=Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    public int dfs(TreeNode root){
        if(root==null){
            return 0;
        }

        int leftGain=dfs(root.left);
        int rightGain=dfs(root.right);

        int left=Math.max(0,leftGain);
        int right=Math.max(0,rightGain);

        int currSum=root.val+left+right;

        maxSum=Math.max(maxSum,currSum);

        return root.val+Math.max(left,right);
    }
}
