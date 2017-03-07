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

    public void insertMinHeap(TrieNode trieNode, String word) {
            if (trieNode.indexMinHeap != -1) {
                ++heapNodes[trieNode.indexMinHeap].frequency;
                heapify(trieNode.indexMinHeap);
            } else if (count < capacity) {
                int counter = count;
                heapNodes[counter].frequency = trieNode.frequency;
                heapNodes[counter].word = word;
                heapNodes[counter].trieNode = trieNode;
                trieNode.indexMinHeap = count;

                count++;
                // build min heap
                buildMinHeap();
            } else if (trieNode.frequency > heapNodes[0].frequency) {
                heapNodes[0].trieNode.indexMinHeap = -1;
                heapNodes[0].trieNode = trieNode;
                heapNodes[0].trieNode.indexMinHeap = 0;
                heapNodes[0].frequency = trieNode.frequency;
                heapNodes[0].word = word;

                // call minheapify
                heapify(0);
            }
    }

    public void buildMinHeap() {
        int n, i;
        n = count - 1;

        for (i= (n-1)/2; i>=0; i--) {
            heapify(i);
        }
    }

    public void heapify(int i) {
        int l = 2*i + 1;
        int r = 2*i + 2;
        int smallest = i;

        if (l < capacity && heapNodes[l].frequency < heapNodes[smallest].frequency) {
            smallest = l;
        }

        if(r < capacity && heapNodes[r].frequency < heapNodes[smallest].frequency) {
            smallest = r;
        }

        if (smallest != i) {
            swapNode(heapNodes[i],heapNodes[smallest]);
            heapify(smallest);
        }
    }

    public void swapNode(MinHeapNode x, MinHeapNode y) {
        MinHeapNode temp = x;
        x = y;
        y = temp;
    }

    public void display() {
        for (int i=0; i< count; i++) {
            System.out.println(heapNodes[i].word + " : " + heapNodes[i].frequency);
        }
    }
}
