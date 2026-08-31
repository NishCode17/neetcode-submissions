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
    private HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder,0,preorder.length-1,
        inorder,0,inorder.length-1);
    }
    
    public TreeNode build(int[] preorder,int prStart,int prEnd,int[] inorder, int inStart,int inEnd){

        if(prStart>prEnd || inStart>inEnd)return null;

        TreeNode root=new TreeNode(preorder[prStart]);

        int index=map.get(root.val);

        int leftSize=index-inStart;

        root.left=build(preorder,prStart+1,prStart+leftSize,
        inorder,inStart,index-1);

        root.right=build(preorder,prStart+leftSize+1,prEnd,
        inorder,index+1,inEnd);

        return root;

    }




}
