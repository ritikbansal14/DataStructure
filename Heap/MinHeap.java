package Heap;

import java.util.Arrays;

public class MinHeap {
    private int capacity = 10;
    private int size = 0;

    int[] items = new int[capacity];

    private int getLeftChildIndex(int parent) { return 2*parent +1;}
    private int getRightChildIndex(int parent) { return 2 * parent +2;}
    private int getParentIndex(int childIndex) {return (childIndex-1)/2;}

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }
    private boolean hasRightChild(int parent) {
        return getRightChildIndex(parent) < size;
    }
    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private int getLeftChild(int parent) {
        return items[getLeftChild(parent)];
    }
    private int getRightChild(int parent) {
        return items[getRightChild(parent)];
    }
    private int getParent(int index) {
        return items[getParentIndex(index)];
    }

    private void swap(int one,int two) {
        int temp = items[one];
        items[one] = items[two];
        items[two]  = temp;
    }
    private void ensureCapacity() {
        if(size == capacity) {
            items = Arrays.copyOf(items, capacity*2);
            capacity *=2;
        }
    }
    public int peek() {
        if(size == 0) throw new IllegalStateException();
        return items[0];
    }

    public int poll() {
        if(size == 0) throw new IllegalStateException();
        int item = items[0];
        items[0] = items[size-1];
        size--;
        heapifyDown();
        return item;
    }
    public void add(int item) {
        // check if capacity 
        ensureCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    public void heapifyUp() {
        int index = size-1;
        while(hasParent(index) && getParent(index) > items[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }
    public void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChild(index);
            if(hasRightChild(index) && getRightChild(index) < getLeftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }
            if(items[index] < items[smallerChildIndex]) {
                break;
            }
            else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }
}