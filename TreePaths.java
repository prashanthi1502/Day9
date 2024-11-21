import java.util.ArrayList;
import java.util.List;

class BinaryTreeNode {
    int data;
    BinaryTreeElement left, right;

    public BinaryTreeNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class TreePaths {
    BinaryTreeElement root;

    // Method to find all root-to-leaf paths
    public void findRootToLeafPaths(BinaryTreeElement node, List<Integer> currentPath, List<List<Integer>> allPaths) {
        if (node == null) {
            return;
        }

        // Add the current node to the path
        currentPath.add(node.data);

        // If it's a leaf node, add the path to allPaths
        if (node.left == null && node.right == null) {
            allPaths.add(new ArrayList<>(currentPath));
        } else {
            // Otherwise, continue the path in both left and right subtrees
            findRootToLeafPaths(node.left, currentPath, allPaths);
            findRootToLeafPaths(node.right, currentPath, allPaths);
        }

        // Remove the current node from the path (backtrack)
        currentPath.remove(currentPath.size() - 1);
    }

    // Utility method to display all root-to-leaf paths
    public void printPaths() {
        List<List<Integer>> allPaths = new ArrayList<>();
        findRootToLeafPaths(root, new ArrayList<>(), allPaths);

        // Print all the paths
        for (List<Integer> path : allPaths) {
            for (int nodeValue : path) {
                System.out.print(nodeValue + " ");
            }
            System.out.println();
        }
    }

    // Utility method to insert a node into the binary tree
    public BinaryTreeElement insert(BinaryTreeElement node, int data) {
        if (node == null) {
            return new BinaryTreeElement(data);
        }
        if (data < node.data) {
            node.left = insert(node.left, data);
        } else {
            node.right = insert(node.right, data);
        }
        return node;
    }

    // Driver method
    public static void main(String[] args) {
        TreePaths tree = new TreePaths();

        // Insert nodes into the binary tree
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 3);
        tree.root = tree.insert(tree.root, 7);
        tree.root = tree.insert(tree.root, 15);
        tree.root = tree.insert(tree.root, 25);

        // Print all root-to-leaf paths
        System.out.println("Root-to-Leaf Paths:");
        tree.printPaths();
    }
}