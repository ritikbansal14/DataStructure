public class LinkedList{
    int currentSize;
    SinglyNode head;
    SinglyNode back;

	public LinkedList() {
        currentSize =  0;
        head = null;
        back = null;
    }
    
    public void addToFirst(SinglyNode node) {
        node.next = head;
        head = node;
    }

    public void deleteFirst() throws Exception {
        if(head == null) {
            throw new Exception("Invalid Operation");
        }
        head = head.next;
        currentSize--;
    }

    public void deleteLast() throws Exception {
        remove(currentSize);
    }

    public void remove(int index) throws Exception {
        if (index < 0 && index > currentSize-1) {
            throw new Exception("Invalid Operation");
        }
        if(index == 0) {
           deleteFirst(); 
           return ;
        }
        SinglyNode head = this.head;
        while(index-- > 1) {
            head = head.next;
        }
        head.next = head.next.next;
    }

    public void append(int data) {
        SinglyNode newNode = new SinglyNode(data);
        append(newNode);
    }

    public void append(SinglyNode newNode) {
        if(currentSize == 0 ) {
            head = newNode;
            back = newNode;
        }
        else {
            back.next = newNode;
            back = newNode;
        }
        currentSize++;
    }

    public void add(int data,int pos) throws Exception {
        SinglyNode temp = head;
        SinglyNode node = new SinglyNode(data);
        if(pos < 0 || pos > currentSize) {
            throw new Exception("Invalid Position");
        }
        if(pos == 0) {
            addToFirst(node);
            return;
        }
        else if (pos == currentSize) {
            append(data);
            return ;
        }
        while(temp  != null && pos > 1) {
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
        currentSize++;
    }

    public boolean havingLoop() {
        if(containsLoop() != null) return true;
        return false;
    }

    public void rightShift() {
        SinglyNode preBack = head;
        SinglyNode temp = head;
        if (head == null) {
            return ;
        }
        while (temp.next != null) {
            preBack = temp;
            temp = temp.next;
        }
        preBack.next = null;
        temp.next = head;
        head = temp;
    }

    public SinglyNode containsLoop() {
        if (this.head == null) return head;
        SinglyNode slow = head, fast = head.next;
        while(fast != null && fast.next != null) {
            if(slow == fast) return slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return null;
    }

    public void traverse() {
        SinglyNode temp = head;
        while (temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public SinglyNode getMiddle(SinglyNode head) {
        SinglyNode middle = head, preMiddle = null;
        while(head != null && head.next!= null) {
            preMiddle = middle;
            middle = middle.next;
            head = head.next.next;
        }
        return preMiddle;
    }

    public int loopLength() {
        SinglyNode fast = containsLoop(), slow = head;
        int length = 0;
        if(fast == null) return 0;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
            length++;
        }
        return length;
    }

    public void mergeSort() throws Exception {
        if (havingLoop()) {
            throw new Exception("Can't Sort, Contains Loop");
        }
        this.head = mergeSort(this.head);
    }

    public SinglyNode mergeSort(SinglyNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        SinglyNode middle = getMiddle(head);
        SinglyNode next = middle.next;
        middle.next = null;
        return merge(mergeSort(head),mergeSort(next));
    } 

    public SinglyNode merge(SinglyNode head1, SinglyNode head2) {
        SinglyNode head = null;
        SinglyNode back = head;
        if(head1.data < head2.data) {
            head = head1;
            head1 = head1.next;
        }
        else {
            head = head2;
            head2 = head2.next;
        }
        back = head;
        while (head1 != null && head2 != null) {
            if(head1.data < head2.data) {
                back.next = head1;
                back = head1;
                head1 = head1.next;
            }
            else {
                back.next = head2;
                back = head2;
                head2 = head2.next;
            }
        }
        if(head1 != null) {
            back.next = head1;
        }
        else {
            back.next = head2;
        }
        return head;
    }

    public void removeDuplicatesSorted() {
        SinglyNode temp = head;
        while (temp != null) {
            SinglyNode t = temp.next;
            while (t != null && t.data == temp.data) {
                t = t.next;
            }
            if(temp.next != t) {
                temp.next = t;
            }
            temp = temp.next;
        }
    }
}