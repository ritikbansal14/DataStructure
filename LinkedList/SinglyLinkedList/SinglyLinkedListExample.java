import java.util.Scanner;

public class SinglyLinkedListExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();
        int size = sc.nextInt();
        for (int i = 0; i < size; i++) {
            list.append(sc.nextInt());
        }
        sc.close();
    }
}