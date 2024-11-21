class BinaryTreeElement {
    int data;
    BinaryTreeElement left, right;

    public BinaryTreeElement(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class TreeSum {
    BinaryTreeElement root;

    // Method to calculate the sum of all elements in the tree
    public int sumOfTree(BinaryTreeElement node) {
        if (node == null) {
            return 0;
        }

        // Sum the current node's data and the sums of the left and right subtrees
        return node.data + sumOfTree(node.left) + sumOfTree(node.right);
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
        TreeSum tree = new TreeSum();

        // Insert nodes into the binary tree
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 3);
        tree.root = tree.insert(tree.root, 7);
        tree.root = tree.insert(tree.root, 15);
        tree.root = tree.insert(tree.root, 25);

        // Calculate and print the sum of all elements in the tree
        int sum = tree.sumOfTree(tree.root);
        System.out.println("Sum of all elements in the tree: " + sum);
    }
}