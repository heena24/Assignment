import java.io.*;

/**
 * Created by heena.h on 06/03/17.
 */
public class MostUsedWords {
    // use of trie data structure for words storage

    String path;

    MostUsedWords(String givenDir) {
        path = givenDir;
    }

    public void printMostUsedWords() throws IOException {
        // Fetch all files from the given directory

        StringBuffer strBuff = new StringBuffer(path);
        if(path.charAt(path.length()-1) != '/')
        {
            path = strBuff.append("/").toString();
        }

        File folder = new File(path);

        if (folder.isDirectory()) {
            // read all files from the given directory
            File[] list = folder.listFiles();

            for (File file : list) {
                if (file.isFile()) {
                    TrieNode root = new TrieNode(' ');
                    // Also create minheap
                    MinHeap minHeap = new MinHeap(10);
                    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                    String line = null;
                    while( (line = br.readLine())!= null ){
                        // \\s+ means any number of whitespaces between tokens
                        String [] tokens = line.split("\\s+");
                        for (String word : tokens) {
                            insertIntoTrieAndHeap(root,minHeap,word.toLowerCase());
                        }
                    }
                    System.out.println("Word count for file : " + file.getName());
                    minHeap.display();
                }
            }

        }

    }

    public void insertIntoTrieAndHeap(TrieNode root, MinHeap minHeap, String word) {
        TrieNode.insert(root,word, minHeap);
    }

}
