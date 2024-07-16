import Tree.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CreateBinaryTreeFromDescriptions {

    public void fillTree(TreeNode node, HashMap<Integer, HashMap<Integer, Integer>> map) {
        if (node == null || !map.containsKey(node.val)) return;

        var directions = map.get(node.val);
        if (directions.containsKey(1)) {
            var value = directions.get(1);
            node.left = new TreeNode(value);
            fillTree(node.left, map);
        }
        if (directions.containsKey(0)) {
            var value = directions.get(0);
            node.right = new TreeNode(value);
            fillTree(node.right, map);
        }
    }

    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

        Set<Integer> heads = new HashSet<>();
        for (var node : descriptions) {
            heads.add(node[0]);
            heads.add(node[1]);
        }

        for (var node : descriptions) {
            if (!map.containsKey(node[0]))
                map.put(node[0], new HashMap<>());
            map.get(node[0]).put(node[2], node[1]);
            heads.remove(node[1]);
        }
        TreeNode head = new TreeNode(heads.iterator().next());
        fillTree(head, map);

        return head;
    }

}
