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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        preorder(root,sb);
        return sb.toString();
    }
    
    public void preorder(TreeNode root, StringBuilder sb){
        if(root==null){
            sb.append("#,");
            return;
        }

        sb.append(root.val).append(",");
        preorder(root.left,sb);
        preorder(root.right,sb);
    }

    private int index=0;

    public TreeNode deserialize(String data) {
        String[] tokens = data.split(",");
        index = 0;                
        return build(tokens);
    }

    private TreeNode build(String[] tokens) {

        String token = tokens[index++];
        if (token.equals("#")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(token));

        node.left = build(tokens);
        node.right = build(tokens);

        return node;
    }
}