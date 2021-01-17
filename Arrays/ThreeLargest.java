package Arrays;
import java.util.Scanner;

/**
 * ThreeLargest
 */
public class ThreeLargest {
    public static void printLargestThree(int size,int[] arr) {
        int x,y,z;
        x = y = z = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > x) {
                z = y;
                y = x;
                x = arr[i];
            } else if(arr[i] > y) {
                z = y;
                y = arr[i];
            } else if(arr[i] > z) {
                z = arr[i];
            }
        }
        System.out.println(x+" "+y+" "+z);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int i = 0;i<size;i++) {
            arr[i] = sc.nextInt();
        }
        printLargestThree(size, arr);
        sc.close();
    }
}