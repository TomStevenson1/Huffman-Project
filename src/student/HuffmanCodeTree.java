package student;

import provided.BinarySequence;

public class HuffmanCodeTree {

   /**
    * Represents the root node of the Huffman code tree.
    */
   private HuffmanNode root;

   /**
    * Constructs a HuffmanCodeTree with the provided root node.
    *
    * @param root The root node of the Huffman code tree.
    */
   public HuffmanCodeTree(HuffmanNode root) {
      this.root = root;
   }

   /**
    * Constructs a HuffmanCodeTree by generating a tree from the given codebook.
    * Creates a new root node as an invalid node and populates the tree based on the provided codebook.
    *
    * @param codebook The HuffmanCodeBook used to generate the Huffman code tree.
    */
   public HuffmanCodeTree(HuffmanCodeBook codebook) {
      this.root = new HuffmanNode(null, null); // Create a new root node as an invalid node
      traverseAndPut(codebook.getTree().getRoot());

   }

   /**
    * Private method to traverse the HuffmanCodeBook tree and update the HuffmanCodeTree.
    * Recursively traverses the HuffmanCodeBook tree and updates the HuffmanCodeTree.
    *
    * @param currentNode The current node in the HuffmanCodeBook tree being traversed.
    */
   private void traverseAndPut(HuffmanCodeBook.Node currentNode) {
      if (currentNode != null) {
         traverseAndPut(currentNode.getLeft()); // Recursively traverse left subtree
         BinarySequence sequence = currentNode.getSeq();
         char character = currentNode.getCharacter();
         if (sequence != null && character != '\u0000') {
            put(sequence, character); // Update the tree with sequence and character
         }
         traverseAndPut(currentNode.getRight()); // Recursively traverse right subtree
      }
   }

   /**
    * Checks if the Huffman code tree is valid.
    *
    * @return true if the Huffman code tree is valid, otherwise false.
    */
   public boolean isValid() {
      return root.isValidTree();
   }

   /**
    * Inserts a sequence and its corresponding character into the Huffman code tree.
    *
    * @param seq    The sequence to be inserted.
    * @param letter The character corresponding to the sequence.
    */
   public void put(BinarySequence seq, char letter) {
      HuffmanNode current = root;

      for (boolean bit : seq) {
         if (bit) {
            if (current.getOne() == null) {
               current.setOne(new HuffmanNode(null, null));
            }
            current = current.getOne();
         } else {
            if (current.getZero() == null) {
               current.setZero(new HuffmanNode(null, null));
            }
            current = current.getZero();
         }
      }
      current.setData(letter);
   }

   /**
    * Decodes a given binary sequence into its corresponding characters based on the Huffman code tree.
    *
    * @param s The binary sequence to be decoded.
    * @return The decoded string based on the Huffman code tree.
    */
   public String decode(BinarySequence s) {
      StringBuilder result = new StringBuilder();
      HuffmanNode node = root;

      for (boolean bit : s) {
         if (bit) {
            node = node.getOne();
         } else {
            node = node.getZero();
         }

         if (node.isLeaf()) {
            result.append(node.getData());
            node = root;
         }
      }

      return result.toString();
   }
}
