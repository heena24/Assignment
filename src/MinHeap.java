/**
 * Created by heena.h on 06/03/17.
 */
public class MinHeap {
    int capacity;
    int count;
    MinHeapNode[] heapNodes;

    MinHeap(int newCapacity) {
        capacity = newCapacity;
        heapNodes = new MinHeapNode[capacity];
        for (int i=0 ;i< capacity; i++) {
            heapNodes[i] = new MinHeapNode();
        }
        count = 0;
    }

    /**
     * Method to insert element into heap
     * @param trieNode
     * @param word
     */
    public void insertMinHeap(TrieNode trieNode, String word) {
            // Already visited word
            if (trieNode.indexMinHeap != -1) {
                ++heapNodes[trieNode.indexMinHeap].frequency;
                minHeapify(trieNode.indexMinHeap);
            } else if (count < capacity) { // Addition of new word
                int counter = count;
                heapNodes[counter].frequency = trieNode.frequency;
                heapNodes[counter].word = word;
                heapNodes[counter].trieNode = trieNode;
                trieNode.indexMinHeap = count;

                count++;
                // build min heap
                buildMinHeap();
            } else if (trieNode.frequency > heapNodes[0].frequency) { // Addition of word with max freq than heap root
                heapNodes[0].trieNode.indexMinHeap = -1;
                heapNodes[0].trieNode = trieNode;
                heapNodes[0].trieNode.indexMinHeap = 0;
                heapNodes[0].frequency = trieNode.frequency;
                heapNodes[0].word = word;

                // Heapify the head after insertion
                minHeapify(0);
            }
    }

    /**
     * Method to heapify the heap after addition of new element
     *
     * O (n log n)
     */
    public void buildMinHeap() {
        int n;
        n = count - 1;

        for (int i= (n-1)/2; i>=0; i--) {
            minHeapify(i);
        }
    }

    /**
     * Method to heapify the heap after modification of its element
     * @param index
     *
     * O(log n)
     */
    public void minHeapify(int index) {
        int l = 2*index + 1;
        int r = 2*index + 2;
        int smallest = index;

        if (l < capacity && heapNodes[l].frequency < heapNodes[smallest].frequency) {
            smallest = l;
        }

        if(r < capacity && heapNodes[r].frequency < heapNodes[smallest].frequency) {
            smallest = r;
        }

        if (smallest != index) {
            swapNode(heapNodes[index],heapNodes[smallest]);
            minHeapify(smallest);
        }
    }

    public void swapNode(MinHeapNode x, MinHeapNode y) {
        MinHeapNode temp = x;
        x = y;
        y = temp;
    }

    /**
     * Method to print the elements of heap
     */

    public void display() {
        for (int i=0; i< count; i++) {
            System.out.println(heapNodes[i].word + " : " + heapNodes[i].frequency);
        }
    }
}
