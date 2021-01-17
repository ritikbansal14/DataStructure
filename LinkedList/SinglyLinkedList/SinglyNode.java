public class SinglyNode {
    int data ;
    SinglyNode next;
    SinglyNode(int data,SinglyNode next) {
        this.data = data;
        this.next = next;
    }
    SinglyNode(int data) {
        this.data = data;
        this.next = null;
    }
    @Override
    public String toString() {
        return Integer.toString(this.data);
    }
}