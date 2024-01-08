package student;

public class HuffmanNode {

    /**
     * Represents the left child node.
     */
    private HuffmanNode left;

    /**
     * Represents the right child node.
     */
    private HuffmanNode right;

    /**
     * Represents the character stored in the node.
     */
    private Character character;

    /**
     * Constructs a HuffmanNode with provided left and right child nodes.
     *
     * @param zero The left child node.
     * @param one The right child node.
     */
    public HuffmanNode(HuffmanNode zero, HuffmanNode one) {
        this.character = null;
        this.left = zero;
        this.right = one;
    }

    /**
     * Constructs a HuffmanNode with the given character and no child nodes.
     *
     * @param character The character to be stored in the node.
     */
    public HuffmanNode(char character) {
        this.character = character;
        this.left = null;
        this.right = null;
    }

    /**
     * Retrieves the left child node of this HuffmanNode.
     *
     * @return The left child node.
     */
    public HuffmanNode getZero() {
        return left;
    }

    /**
     * Sets the left child node of this HuffmanNode.
     *
     * @param zero The HuffmanNode to be set as the left child node.
     */
    public void setZero(HuffmanNode zero) {
        this.left = zero;
    }


    /**
     * Retrieves the right child node of this HuffmanNode.
     *
     * @return The right child node.
     */
    public HuffmanNode getOne() {
        return right;
    }

    /**
     * Sets the right child node of this HuffmanNode.
     *
     * @param one The HuffmanNode to be set as the right child node.
     */
    public void setOne(HuffmanNode one) {
        this.right = one;
    }

    /**
     * Retrieves the character stored in this HuffmanNode.
     *
     * @return The character stored in the node.
     */
    public Character getData() {
        return character;
    }

    /**
     * Sets the character to be stored in this HuffmanNode.
     *
     * @param character The character to be stored in the node.
     */
    public void setData(char character) {
        this.character = character;
    }

    /**
     * Checks if the node is a leaf node by verifying if it has no child nodes and contains a character.
     *
     * @return True if the node is a leaf node, otherwise false.
     */
    public boolean isLeaf() {
        return left == null && right == null && character != null;
    }


    /**
     * Checks if the node is a valid internal or leaf node.
     * @return true if it's a valid internal or leaf node, otherwise false.
     */
    public boolean isValidNode() {
        // Check if it's an internal node
        if (isLeaf()) { // Check if it's a leaf node
            return true;
        } else {
            // Check if it's an internal node
            return character == null && left != null && right != null;
        }
    }

    /**
     * Checks if the tree rooted at this node is valid.
     * @return true if the tree is valid, otherwise false.
     */
    public boolean isValidTree() {
        return isValidTreeHelper(this);
    }

    /**
     * Helper method to validate the tree recursively starting from a given node.
     * @param node The node to start validation from.
     * @return true if the tree is valid, otherwise false.
     */
    private boolean isValidTreeHelper(HuffmanNode node) {
        if (node == null) {
            return true; // Null nodes are considered valid
        }

        if (node.isLeaf()) {
            // Leaf node: data is not null, and both children are null
            return node.getData() != null && node.getZero() == null && node.getOne() == null;
        } else {
            // Internal node: data is null, and both children are not null
            return node.getData() == null && node.getZero() != null && node.getOne() != null
                    && isValidTreeHelper(node.getZero()) && isValidTreeHelper(node.getOne());
        }
    }
}
