/**
 * Created by heena.h on 07/03/17.
 */
public class HeapSort {

    public static void sort(int[] arr, int n) {
        for (int i= n/2 -1; i>=0; i--) {
            heapify(arr,i,n);
        }

        for (int i= n-1; i>=0; i--) {
            int temp  = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapify(arr,0,i);
        }
    }

    public static void heapify(int[] arr, int i, int n) {
        int l = 2*i + 1;
        int r = 2*i + 2;
        int largest = i;

        if (l < n && arr[l] > arr[largest]){
            largest = l;
        }

        if(r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr,largest,n);
        }
    }
}
