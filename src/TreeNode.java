import com.sun.source.tree.Tree;
import org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.RegexConversion;

import java.util.*;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
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
                current.left = left;
                queue.add(left);
            }
            i++;
            if (!values[i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                current.right = right;
                queue.add(right);
            }
        }

        return root;
    }
}



