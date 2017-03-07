/**
 * Created by heena.h on 06/03/17.
 */
public class StringPermutation {

    public static void printPermutation(int l, int r, String givenString) {
        if (l == r) {
            System.out.println(givenString);
        } else {
            for (int i = l; i <= r; i++)
            {
                givenString = swapChar(givenString,l,i);
                printPermutation(l+1, r,givenString);
                givenString = swapChar(givenString,l,i);
            }
        }
    }

    public static String swapChar(String str, int i, int j)
    {
        char temp;
        char[] charArray = str.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

}
