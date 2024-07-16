package Tree;

import com.sun.source.tree.Tree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class TreeNodeTest {
    @Test
    public void testSerializeSingleElement() {
        TreeNode root = new TreeNode(1);
        String given = TreeNode.serialize(root);
        String expected = "1,null,null";

        assertEquals(given, expected);
    }

    @Test
    public void testSerializeSimpleTree() {
        // Constructing a simple binary tree:
        //     1
        //    / \
        //   2   3
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        String result = TreeNode.serialize(root);
        assertEquals("1,2,3,null,null,null,null", result);
    }

    @Test
    public void testSerializeComplexTree() {
        // Constructing a more complex binary tree:
        //     1
        //    / \
        //   2   3
        //  / \
        // 4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        String result = TreeNode.serialize(root);
        assertEquals("1,2,3,4,5,null,null,null,null,null,null", result);
    }

    @Test
    public void testSerializeNullRoot() {
        TreeNode root = null;
        String result = TreeNode.serialize(root);
        assertEquals("null", result);
    }

    @Test
    public void testSerializeTreeWithOnlyRightChildren() {
        // Constructing a binary tree with only right children:
        // 1
        //  \
        //   2
        //    \
        //     3
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);

        String result = TreeNode.serialize(root);
        assertEquals("1,null,2,null,3,null,null", result);
    }

    @Test
    public void testSerializeTreeWithOnlyLeftChildren() {
        // Constructing a binary tree with only left children:
        //     1
        //    /
        //   2
        //  /
        // 3
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);

        String result = TreeNode.serialize(root);
        assertEquals("1,2,null,3,null,null,null", result);
    }


    @Test
    public void testDeserializeSingleElement() {
        TreeNode root = TreeNode.deserialize("1,null,null");

        assertEquals("1,null,null", TreeNode.serialize(root));
    }

    @Test
    public void testDeserializeSimpleTree() {
        TreeNode root = TreeNode.deserialize("1,2,null,null,3,null,null");

        assertEquals("1,2,null,null,3,null,null", TreeNode.serialize(root));
    }

    @Test
    public void testDeserializeComplexTree() {
        TreeNode root = TreeNode.deserialize("1,2,3,null,null,4,5");

        assertEquals("1,2,3,null,null,4,5,null,null,null,null", TreeNode.serialize(root));
    }

    @Test
    public void testDeserializeNullRoot() {
        TreeNode root = TreeNode.deserialize(null);

        assertNull(root);
    }

    @Test
    public void testDeserializeEmptyString() {
        TreeNode root = TreeNode.deserialize("");

        assertNull(root);
    }

    @Test
    public void testDeserializeTreeWithOnlyRightChildren() {
        TreeNode root = TreeNode.deserialize("1,null,2,null,3,null,null");

        assertEquals("1,null,2,null,3,null,null", TreeNode.serialize(root));
    }

    @Test
    public void testDeserializeTreeWithOnlyLeftChildren() {
        TreeNode root = TreeNode.deserialize("1,2,null,3,null,null,null");

        assertEquals("1,2,null,3,null,null,null", TreeNode.serialize(root));
    }


    @Test
    public void testTriesAreEqual() {
        TreeNode tree1 = TreeNode.deserialize("1,2,null,3,null,null,null");
        TreeNode tree2 = TreeNode.deserialize("1,2,null,3,null,null,null");

        assertTrue(tree1.compareTries(tree2));
    }

    @Test
    public void testTriesAreNotEqual() {
        TreeNode tree1 = TreeNode.deserialize("1,2,null,3,null,null,null");
        TreeNode tree2 = TreeNode.deserialize("1,3,null,4,null,null,null");

        assertFalse(tree1.compareTries(tree2));
    }

    @Test
    public void lowestCommonAncestorTest() {
        TreeNode root = TreeNode.deserialize("3,5,1,6,2,0,8,null,null,7,4");
        TreeNode p = root.left; // 5
        TreeNode q = root.right; // 1
        TreeNode LCA = TreeNode.lowestCommonAncestor(root, p, q);

        assertEquals(LCA, root);
    }

    @Test
    public void lowestCommonAncestorWhenPisLCATest() {
        TreeNode root = TreeNode.deserialize("3,5,1,6,2,0,8,null,null,7,4");
        TreeNode p = root.left; // 5
        TreeNode q = root.left.right.right; // 4
        TreeNode LCA = TreeNode.lowestCommonAncestor(root, p, q);

        assertEquals(LCA, p);
    }

    @Test
    public void lowestCommonAncestorWhenQisLCATest() {
        TreeNode root = TreeNode.deserialize("3,5,1,6,2,0,8,null,null,7,4");
        TreeNode p = root.right.left; // 0
        TreeNode q = root.right; // 1
        TreeNode LCA = TreeNode.lowestCommonAncestor(root, p, q);

        assertEquals(LCA, q);
    }

}