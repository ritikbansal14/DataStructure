public class LoopDetection {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        list.traverse();
        list.rightShift();
        list.traverse();
        System.out.println(list.havingLoop());
        System.out.println(list.loopLength());
    }
}
