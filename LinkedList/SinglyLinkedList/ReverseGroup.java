
public class ReverseGroup {
    public static SinglyNode reverseInGroup(SinglyNode head, int k) {
        if( head == null) {
            return head;
        }
        int count = k;
        SinglyNode temp = head, pre = null, next;
        while (--count >= 0 && temp != null) {
            next = temp.next;
            temp.next = pre;
            pre = temp;
            temp = next;
        }
        head.next = reverseInGroup(temp, k);
        return pre;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        list.append(6);
        list.append(7);
        list.append(8);
        list.append(9);
        list.head =  reverseInGroup(list.head, 3);
        list.traverse();
    }
}
