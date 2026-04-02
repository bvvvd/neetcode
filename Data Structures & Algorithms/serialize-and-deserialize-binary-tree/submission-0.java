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
        StringBuilder builder = new StringBuilder();
        traverse(root, builder);
        if (builder.charAt(builder.length() - 1) == ';') {
            builder.deleteCharAt(builder.length() - 1);
        }
        return builder.toString();
    }

    private void traverse(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append("n;");
            return;
        }

        builder.append("" + root.val)
            .append(";");
        traverse(root.left, builder);
        traverse(root.right, builder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(";");

        return buildTree(values, new int[]{0});
    }

    private TreeNode buildTree(String[] values, int[] index) {
        if (index[0] >= values.length) {
            index[0]++;
            return null;
        }

        if (values[index[0]].equals("n")) {
            index[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(values[index[0]]));
        index[0]++;
        root.left = buildTree(values, index);
        root.right = buildTree(values, index);

        return root;
    }
}
