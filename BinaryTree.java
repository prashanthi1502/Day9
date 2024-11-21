class Node {
    int data;
    TreeNode left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class BinaryTree {
    TreeNode root;

    TreeNode findLCA(TreeNode node, int n1, int n2) {
        // Base case
        if (node == null) {
            return null;
        }

        // If either n1 or n2 matches with the node's data
        if (node.data == n1 || node.data == n2) {
            return node;
        }

        // Look for keys in left and right subtrees
        TreeNode leftLCA = findLCA(node.left, n1, n2);
        TreeNode rightLCA = findLCA(node.right, n1, n2);

        // If both calls return non-null, this node is the LCA
        if (leftLCA != null && rightLCA != null) {
            return node;
        }

        // Otherwise return the non-null child
        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    // Driver method to test above
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);

        int n1 = 4, n2 = 5;
        TreeNode lcaNode = tree.findLCA(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is: " + (lcaNode != null ? lcaNode.data : "not found"));
    }
}