import provided.BinarySequence;
import student.HuffmanCodeBook;

public class Main {
    public static void main(String[] args) {
        // Create a BinarySequence object
        BinarySequence sequence = new BinarySequence("1010110"); // Replace this with your desired bit string

        // Create an instance of HuffmanCodeBook
        HuffmanCodeBook book = new HuffmanCodeBook();

        // Add the character 'c' along with the BinarySequence to HuffmanCodeBook
        book.addSequence('c', sequence);

        // Perform additional operations or tests if needed
    }
}
