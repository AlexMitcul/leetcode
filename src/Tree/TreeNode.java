package Tree;

import java.util.*;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /*
     * Next two functions represent the (297. Serialize and Deserialize Binary Tree) LeetCode problem.
     *
     */

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) return "null";

        List<String> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                result.add("null");
                continue;
            }
            result.add(String.valueOf(node.val));
            queue.add(node.left);
            queue.add(node.right);
        }
        return String.join(",", result);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == null || data.isEmpty() || data.equals("null")) return null;

        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        for (int i = 1; i < values.length; i++) {
            TreeNode current = queue.poll();

            if (!values[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                Objects.requireNonNull(current).left = left;
                queue.add(left);
            }
            i++;
            if (!values[i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                Objects.requireNonNull(current).right = right;
                queue.add(right);
            }
        }

        return root;
    }

    public boolean compareTries(TreeNode root) {
        String thisTree = serialize(this);
        String anotherTree = serialize(root);

        return thisTree.equals(anotherTree);
    }

    /**
     * Find the lowest common ancestor in the binary tree. <a href="https://en.wikipedia.org/wiki/Lowest_common_ancestor">Wiki explanation</a>
     * Required to root, p and q be valid and exist in the tree.
     * <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/">LeetCode link</a>
     * @param root node
     * @param p first node
     * @param q second node
     * @return node - lowest common ancestor
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;

        if (root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null)
            return root;
        else if (left != null)
            return left;
        else
            return right;
    }
}



