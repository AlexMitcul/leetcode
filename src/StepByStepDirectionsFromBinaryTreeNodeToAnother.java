import Tree.TreeNode;

import java.util.Stack;

public class StepByStepDirectionsFromBinaryTreeNodeToAnother {

    String getPath(TreeNode node, int endValue) {
        if (node == null) return "";

        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<String> pathStack = new Stack<>();
        nodeStack.push(node);
        pathStack.push("");

        while (!nodeStack.isEmpty()) {
            TreeNode currentNode = nodeStack.pop();
            String currentPath = pathStack.pop();

            if (currentNode.val == endValue) {
                return currentPath;
            }

            if (currentNode.right != null) {
                nodeStack.push(currentNode.right);
                pathStack.push(currentPath + "R");
            }

            if (currentNode.left != null) {
                nodeStack.push(currentNode.left);
                pathStack.push(currentPath + "L");
            }
        }

        return "";
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        String pathToStart = getPath(root, startValue);
        String pathToDest = getPath(root, destValue);

        int i = 0;
        while (i < pathToStart.length() && i < pathToDest.length() && pathToStart.charAt(i) == pathToDest.charAt(i)) i++;

        StringBuilder res = new StringBuilder();
        res.append("U".repeat(pathToStart.length() - i));
        res.append(pathToDest.substring(i));

        return res.toString();
    }

}
