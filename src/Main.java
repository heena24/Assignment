import java.io.IOException;
import java.util.Scanner;

/**
 * Created by heena.h on 05/03/17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // Provide options for user input
        System.out.println("1. Print intersection of two given array elements.");
        System.out.println("2. Print all possible permutations of given string.");
        System.out.println("3. Print top 10 most used words.");
        System.out.println("Please enter your choice in number...");

        int choice = sc.nextInt();
        switch (choice) {
            case 1 :
                System.out.println("Enter the size of first array : ");
                int a = sc.nextInt();
                int[] A = new int[a];
                System.out.println("Enter elements of first array separated space :");
                for (int i=0; i<a; i++) {
                    A[i] = sc.nextInt();
                }

                System.out.println("Enter the size of second array : ");
                int b = sc.nextInt();
                int[] B = new int[b];
                System.out.println("Enter elements of first array separated space :");
                for (int i=0; i<b; i++) {
                    B[i] = sc.nextInt();
                }

                ArrayIntersection intersection = new ArrayIntersection(A,B);
                System.out.println("Intersection of arrays is : ");
                intersection.printIntersection();
                break;
            case 2 :
                System.out.println("Enter the string : ");
                String str = sc.next();
                System.out.println("Permutations of string are : ");
                StringPermutation.printPermutation(0, str.length()-1,str);
                break;
            case 3 :
                System.out.println("Enter the directory path : ");
                String dir = sc.next();
                MostUsedWords find = new MostUsedWords(dir);
                find.printMostUsedWords();
                break;
            default:
                System.out.println("Incorrect choice.");
        }
    }
}
