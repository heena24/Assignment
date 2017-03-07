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

//    public static void print(TrieNode root) {
//        for (int i=0; i< root.child.length ; i++) {
//            if (root.child[i] != null) {
//                System.out.println(root.child[i].character);
//            }
//        }
//    }

    public static int charToIndex(char c) {
        return (int) c - (int) 'a';
    }

//    public static boolean isLowerCase(char ch) {
//        return ch >= 'a' && ch <= 'z';
//    }
//
//    public static boolean isUpperCase(char ch) {
//        return ch >= 'A' && ch <= 'Z';
//    }
}
