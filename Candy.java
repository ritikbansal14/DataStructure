import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Candy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // types of candies
        int size = sc.nextInt();

        //reverse priority queue
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b.compareTo(a);
            }
        });

        // directly add types of candies to PQueue
        for (int i = 0; i < size; i++) {
            queue.add(sc.nextInt());
        }

        //number of groups 
        int m = sc.nextInt();
        int g[] = new int[m];
        for (int i = 0; i < g.length; i++) {
            g[i] = sc.nextInt();
        }
        //sorting array
        Arrays.sort(g);
        int sum = 0;
        for (int i = 0; i < g.length; i++) {
            //if current group size is less than or equals to the type of candies left in the PQueue
            if (g[i] <= queue.size()) {
                // then decrement each type by one and push
                for (int j = 0; j < g[i]; j++) {
                    int temp = queue.poll() - 1;
                    if (temp != 0)
                        queue.add(temp);
                }
                sum++;
            }
            else {
                break;
            }
        }
        System.out.println(sum);
        sc.close();
    }
}