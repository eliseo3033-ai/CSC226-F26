package medical_action_tracking;

public class LinkedStack<T> {
    private class Node {
        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
        }
    }

    private Node top;
    private int size;

    public void push(T item) {
        // TODO: Reject null items, then link a new node at the top and update size.
        if (item == null) { //does not push if item == null
            throw new IllegalArgumentException();
        }
            Node newNode = new Node(item); //creates a new node
            newNode.next = top; //points the new node to what we have currently on top
            top = newNode; //set the top to the new node
            size++;
        
    }

    public T pop() {
        // TODO: Remove and return the top item, or return null when empty.
       if (isEmpty()) return null;
       else {
        T savedData = top.data; //access data and store it in a varible
        top = top.next; //set the top to whats underneath it
        size--;
        return savedData; //return the data we saved
       }
    }

    public T peek() {
        // TODO: Return the top item without removing it, or null when empty.
         if (isEmpty()) return null;
         else {
         T itemPeeking = top.data;
         return itemPeeking;
         }
    }

    public boolean isEmpty() {
        // TODO: Determine whether the stack contains any items.
        return top == null;
    }

    public int size() {
        // TODO: Return the number of stacked items.
        return size;
    }

    @Override
    public String toString() {
        // TODO: Build [top, next, ...] by traversing the stack without changing it.
        String toBePrinted = "["; //this is the start of what will be returned
        Node lastIn = top; //whatever is last in the stack is the top

        while (lastIn != null) { //a loop that will continue until there is nothing left in the stack
           toBePrinted += lastIn.data;

           if (lastIn.next != null) { //this determines to add a comma after each node
            toBePrinted += ", ";
           }           
            lastIn = lastIn.next; //goes over to the next node below it

        }
        toBePrinted += "]";
        return toBePrinted;
    }
}
