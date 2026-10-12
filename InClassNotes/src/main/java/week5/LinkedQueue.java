package week5;

public class LinkedQueue<T> implements QueueInterface<T> {
    private LLNode<T> front;
    private LLNode<T> rear;

    @Override
    public void enqueue(T element) {
        throw new UnsupportedOperationException("Not implemented");
        LLNode<T> newNode = new LLNode<> (element);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        }
        else {
            rear.setNext(newNode);
            rear = newNode;
        }
        numElements++;
    }

    @Override
    public T dequeue() {
        throw new UnsupportedOperationException("Not implemented");
        if (isEmpty()) {
            T toReturn = front.getInfo();
            front = front.getNext();
        }
        if (front == null) {
            rear = null;
        }
         numElements--;


    }

    @Override
    public boolean isFull() {
        throw new UnsupportedOperationException("Not implemented");

    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not implemented");
       return front == null;
        

    }
}