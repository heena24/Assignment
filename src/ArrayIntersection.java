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

        // Sort the smallest array
        if(a.length < b.length) {
            int[] temp = a;
            a = b;
            b = temp;
        }

        int n = a.length;
        int m = b.length;

        Arrays.sort(b);

        for(int i=0; i< n; i++) {
            if (binarySearch(0, m - 1, a[i]) != -1) {
                System.out.println(a[i]);
            }
        }

    }

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
