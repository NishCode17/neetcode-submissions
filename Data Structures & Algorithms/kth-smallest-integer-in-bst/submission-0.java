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

    int k;
    int answer;

    public int kthSmallest(TreeNode root, int k) {
        this.k=k;
        inOrder(root);
        return answer;
    }

    public void inOrder(TreeNode root){
        if(root==null) return;

        inOrder(root.left);

        if(k==0) return;

        k--;

        if(k==0){
            answer=root.val;
            return;
        }
        inOrder(root.right);
    }
}
