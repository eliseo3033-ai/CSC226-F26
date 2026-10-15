package medical_action_tracking;

public class LinkedQueue<T> {
    private class Node {
        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    public LinkedQueue() {
        // TODO: Initialize an empty queue.
        front = null;
        rear = null;
        size = 0;
    }

    public void enqueue(T item) {
        // TODO: Add a node at the rear. Update both references when the queue is empty.
        if (item == null) {
            throw new IllegalArgumentException();
        }
        Node newNode = new Node(item);
        if (isEmpty()) { // if the node is first in the queue it will be the rear and front
            front = newNode;
            rear = newNode;
            size++;
        }
        else {
            rear.next = newNode; // a new node will point to the other and be set to the rear
            rear = newNode;
            size++;
        }
    }

    public T dequeue() {
        // TODO: Remove and return the front item, or return null if empty.
        // TODO: When removing the last item, make both front and rear null.
        if (isEmpty()) {
            return null;
        }
        else {
            T frontData = front.data; //save the data that is first in the queue
            front = front.next; // set the front to the node next in line
            size--;
            if (size == 0) { // set front and rear null if the last node is dequeued
                front = null;
                rear = null;
            }
            return frontData;
        }
    }

    public T peekFront() {
        // TODO: Return the front item without removing it, or null if empty.
        if (isEmpty()) return null;
        return front.data;
    }

    public boolean isEmpty() {
        // TODO: Determine whether the queue contains any items.
        return size == 0;
    }

    public int size() {
        // TODO: Return the number of queued items.
        return size;
    }

    @Override
    public String toString() {
        // TODO: Recursively build a string from front to rear without changing the queue.
        StringBuilder result = new StringBuilder("[");
        appendNodesRecursively(front, result);
        result.append("]");
        return result.toString();
    }

    private void appendNodesRecursively(Node current, StringBuilder result) {
        // TODO: Add the current node's data, then recursively visit current.next.
        // TODO: Stop at the null-node base case.

        if (current == null) return;

        result.append(current.data);

        if (current.next != null) {
            result.append(", ");
        }
        appendNodesRecursively(current.next, result);
    }
}
