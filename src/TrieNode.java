/**
 * Created by heena.h on 06/03/17.
 */
public class TrieNode {
    boolean isLeaf;
    int frequency;
    int indexMinHeap;
    char character;
    TrieNode[] child = new TrieNode[26];

    TrieNode(char c) {
        isLeaf = false;
        frequency = 0;
        indexMinHeap = -1;
        for( int i = 0; i < 26; ++i ) {
            child[i] = null;
        }
        character = c;
    }

    /**
     * Method to add a word into a Trie
     * @param root
     * @param word
     * @param minHeap
     * @return
     */
    public static TrieNode insert(TrieNode root, String word, MinHeap minHeap) {
        int length = word.length();

        TrieNode temp = root;
        if ( !TrieNode.search(temp,word,minHeap) ) {
            for (int i=0; i< length; i++) {
                int index = charToIndex(word.charAt(i));
                if (temp.child[index] == null) {
                    temp.child[index] = new TrieNode(word.charAt(i));
                }

                temp = temp.child[index];
            }

            temp.isLeaf = true;
            temp.frequency += 1;
            minHeap.insertMinHeap(temp,word);
        }

        return temp;

    }

    /**
     * Method to search for a word in a Trie
     * @param root
     * @param word
     * @param minHeap
     * @return
     */
    public static boolean search(TrieNode root, String word,MinHeap minHeap) {
        int length = word.length();
        TrieNode temp = root;
        for (int i=0; i< length; i++) {
            int index = charToIndex(word.charAt(i));
            if (temp.child[index] == null) {
                return false;
            }

            temp = temp.child[index];
        }

        if (temp != null && temp.isLeaf) {
            temp.frequency += 1;
            minHeap.insertMinHeap(temp,word);
        }

        return (temp != null && temp.isLeaf);
    }

    public static int charToIndex(char c) {
        return (int) c - (int) 'a';
    }

}
