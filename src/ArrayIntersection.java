import java.util.Arrays;

/**
 * Created by heena.h on 05/03/17.
 */
public class ArrayIntersection {
    int[] a;
    int[] b;
    ArrayIntersection (int[] newA, int[] newB) {
        a = newA;
        b = newB;
    }

    public void printIntersection() {

        // Find the smallest size array and swap with b
        if(a.length < b.length) {
            int[] temp = a;
            a = b;
            b = temp;
        }

        int n = a.length;
        int m = b.length;

        //Sort the smallest array : O(mlog(m))
        Arrays.sort(b);

        // O (mlog(m) + nlog(m)) => O((m+n)log(m) )
        for(int i=0; i< n; i++) {
            if (binarySearch(0, m - 1, a[i]) != -1) {
                System.out.println(a[i]);
            }
        }
    }

    // O(log(n)) : n number of elements
    public int binarySearch(int i, int j, int data) {

        if (j >= i) {
            int m = (i+j)/2;
            if (b[m] == data) return m;

            if (b[m] > data) {
                return binarySearch(i, m-1, data);
            } else {
                return binarySearch(m+1, j, data);
            }
        }

        return -1;
    }
}
