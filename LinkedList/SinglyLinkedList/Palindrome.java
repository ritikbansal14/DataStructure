import java.util.Scanner;

/**
 * Palindrome
 */
public class Palindrome {
    public static SinglyNode reverse(SinglyNode head) {
        SinglyNode pre, next;
        pre = null;
        while(head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static boolean compare(SinglyNode from1, SinglyNode to1,SinglyNode from2, SinglyNode to2) {
        while(from1 != to1 && from2 != to2) {
            if(from1.data != from2.data) {
                return false;
            }
            from1 = from1.next;
            from2 = from2.next;
        }
        return true;
    }
    public static boolean isPalindrome(LinkedList list) {
        boolean result = true;
        SinglyNode head = list.head;
        SinglyNode middle = head;
        SinglyNode preMiddle = null;
        while(head != null && head.next != null) {
            preMiddle = middle;
            middle = middle.next;
            head = head.next.next;
        }
        if(head == null) {
            preMiddle.next = reverse(preMiddle.next);
            result = compare(list.head, preMiddle.next, preMiddle.next, null);
            preMiddle.next = reverse(preMiddle.next);
            return result;
        }
        middle.next = reverse(middle.next);
        result = compare(list.head, middle, middle.next, null);
        middle.next = reverse(middle.next);
        return result;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(2);
        list.append(1);
        list.traverse();
        System.out.println(isPalindrome(list));
        sc.close();
    }
}