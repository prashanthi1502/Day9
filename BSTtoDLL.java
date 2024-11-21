class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class BSTtoDLL {
    private TreeNode root;
    private TreeNode head = null;
    private TreeNode prev = null;

    // Method to convert BST to DLL
    public void convertToDLL(TreeNode current) {
        if (current == null) {
            return;
        }

        // Recur for the left subtree
        convertToDLL(current.left);

        // Convert the current node
        if (prev == null) {
            head = current; // The leftmost node becomes the head
        } else {
            prev.right = current;
            current.left = prev;
        }
        prev = current;

        // Recur for the right subtree
        convertToDLL(current.right);
    }

    // Utility method to display the DLL
    public void printDLL() {
        TreeNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.right;
        }
    }

    // Utility method to insert a node into the BST
    public TreeNode insert(TreeNode node, int data) {
        if (node == null) {
            return new TreeNode(data);
        }
        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        }
        return node;
    }

    // Driver method
    public static void main(String[] args) {
        BSTtoDLL tree = new BSTtoDLL();

        // Insert nodes into the BST
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 15);
        tree.root = tree.insert(tree.root, 25);

        // Convert BST to DLL
        tree.convertToDLL(tree.root);

        // Print the DLL
        System.out.println("Doubly Linked List:");
        tree.printDLL();
    }
}