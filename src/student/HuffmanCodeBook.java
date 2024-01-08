package student;

import provided.BinarySequence;

/**
 * HuffmanCodeBook class contains methods to manipulate Huffman codes.
 */
public class HuffmanCodeBook {

    /**
     * tree is a tree which will be a BST that contains our sequences and characters. Sorted by character value.
     */
    private Tree tree;

    /**
     * our root is our base value for our tree ie the top of our tree.
     */
    private Node root;

    /**
     * Constructs a HuffmanCodeBook object with an initialized tree and null root.
     * The tree is instantiated as a new Tree object.
     */
    public HuffmanCodeBook() {
        this.tree = new Tree(); // Initialize the tree in the constructor
        this.root = null;
    }

    /**
     * Retrieves the tree containing sequences and characters.
     *
     * @return The tree containing sequences and characters.
     */
    public Tree getTree() {
        return tree;
    }

    /**
     * Sets the tree containing sequences and characters.
     *
     * @param tree The tree containing sequences and characters to be set.
     */
    public void setTree(Tree tree) {
        this.tree = tree;
    }

    /**
     * Retrieves the root node of the tree.
     *
     * @return The root node of the tree.
     */
    public Node root() {
        return root;
    }

    /**
     * Sets the root node of the tree.
     *
     * @param root The root node to be set.
     */
    public void setRoot(Node root) {
        this.root = root;
    }
    /**
     * Retrieves the root node of the HuffmanCodeBook tree.
     *
     * @return The root node of the tree.
     */
    public Node getRoot() {
        return root;
    }

    /**
     * Adds a new sequence to the HuffmanCodeBook tree.
     *
     * @param c   The character associated with the sequence.
     * @param seq The binary sequence to be added.
     */
    public void addSequence(char c, BinarySequence seq) {
        Node newNode = new Node(seq, c);
        tree.addNode(newNode);
    }

    /**
     * Checks if a character exists in the HuffmanCodeBook tree.
     *
     * @param letter The character to check.
     * @return True if the character exists in the tree, otherwise false.
     */
    public boolean contains(char letter) {
        Node temp = tree.search(letter);

        // Check if the character is found in the tree
        return temp != null && temp.getCharacter() == letter;
    }

    /**
     * Checks if all characters in a string exist in the HuffmanCodeBook tree.
     *
     * @param letters The string containing characters to check.
     * @return True if all characters are found in the tree, otherwise false.
     */
    public boolean containsAll(String letters) {
        for (int i = 0; i < letters.length(); i++) {
            char currentChar = letters.charAt(i);

            // If any character is not present in the tree, return false
            if (!contains(currentChar)) {
                return false;
            }
        }
        // All characters found in the tree, return true
        return true;
    }

    /**
     * Retrieves the binary sequence for a specific character from the HuffmanCodeBook tree.
     *
     * @param c The character to retrieve the sequence for.
     * @return The binary sequence associated with the character, or null if not found.
     */
    public BinarySequence getSequence(char c) {
        Node temp = tree.search(c);
        return temp != null ? temp.getSeq() : null;
    }

    /**
     * Encodes a string using the HuffmanCodeBook tree.
     *
     * @param s The string to be encoded.
     * @return The encoded binary sequence.
     */
    public BinarySequence encode(String s) {
        BinarySequence result = new BinarySequence();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            BinarySequence tempSeq = getSequence(current);
            result.append(tempSeq);
        }
        return result;
    }

    /**
     * Node class represents a node in the HuffmanCodeBook tree.
     */
    public static class Node {

        /**
         * Binary sequence associated with the node.
         */
        private BinarySequence sequence;

        /**
         * Character associated with the node.
         */
        private Character character;

        /**
         * Left child node.
         */
        private Node left;

        /**
         * Right child node.
         */
        private Node right;

        /**
         * Constructs a Node with a binary sequence and a character.
         *
         * @param sequence  The binary sequence associated with the node.
         * @param character The character associated with the node.
         */
        public Node(BinarySequence sequence, Character character) {
            this.sequence = sequence;
            this.character = character;
            this.left = null;
            this.right = null;
        }

        /**
         * Retrieves the binary sequence associated with the node.
         *
         * @return The binary sequence.
         */
        public BinarySequence getSeq() {
            return sequence;
        }

        /**
         * Retrieves the character associated with the node.
         *
         * @return The character.
         */
        public Character getCharacter() {
            return character;
        }

        /**
         * Sets the binary sequence for the node.
         *
         * @param sequence The binary sequence to set.
         */
        public void setSequence(BinarySequence sequence) {
            this.sequence = sequence;
        }

        /**
         * Sets the character for the node.
         *
         * @param character The character to set.
         */
        public void setCharacter(Character character) {
            this.character = character;
        }

        /**
         * Retrieves the left child node.
         *
         * @return The left child node.
         */
        public Node getLeft() {
            return left;
        }

        /**
         * Retrieves the right child node.
         *
         * @return The right child node.
         */
        public Node getRight() {
            return right;
        }

        /**
         * Sets the left child node.
         *
         * @param node The node to set as the left child.
         */
        public void setLeft(Node node) {
            this.left = node;
        }

        /**
         * Sets the right child node.
         *
         * @param node The node to set as the right child.
         */
        public void setRight(Node node) {
            this.right = node;
        }

    }

    /**
     * Tree class represents the tree structure in the HuffmanCodeBook.
     */
    public static class Tree {

        /**
         * Root node of the tree.
         */
        private Node root;

        /**
         * Constructs an empty tree with a null root.
         */
        public Tree() {
            this.root = null;
        }

        /**
         * Retrieves the root node of the tree.
         *
         * @return The root node of the tree.
         */
        public Node getRoot() {
            return root;
        }

        /**
         * Adds a new node to the tree.
         *
         * @param newNode The node to add.
         */
        public void addNode(Node newNode) {
            if (root == null) {
                root = newNode; // If tree is empty, set the new node as the root
            } else {
                Node current = root;
                Node parent;

                while (true) {
                    parent = current;

                    // Check if the new node's character value is less than the current node's character value
                    if (newNode.getCharacter() < current.getCharacter()) {
                        current = current.getLeft(); // Move to the left child

                        if (current == null) {
                            parent.setLeft(newNode); // If the left child is null, insert the new node here
                            return;
                        }
                    } else {
                        current = current.getRight(); // Move to the right child

                        if (current == null) {
                            parent.setRight(newNode); // If the right child is null, insert the new node here
                            return;
                        }
                    }
                }
            }
        }

        /**
         * Searches for a node with a specific character value.
         *
         * @param character The character to search for.
         * @return The node if found, otherwise null.
         */
        public Node search(char character) {
            Node current = root;

            while (current != null && current.getCharacter() != character) {
                if (character < current.getCharacter()) {
                    current = current.getLeft(); // Move to the left subtree
                } else {
                    current = current.getRight(); // Move to the right subtree
                }
            }

            return current; // Returns the node if found, or null if not found
        }
    }

}
