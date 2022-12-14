import java.util.Iterator;

public class GenericQueue<T> extends GenericList<T>{
    private Node <T> tail;

    public GenericQueue(T val){
        Node <T> head = new Node<T>(val);
        this.setHead(head);
        this.tail = head;
        setLength(1); // set length to 1 b/c head already exists
    }

    public T removeTail() {
        // checks if the list is empty
        if (getHead() == null || getHead().next == null) {
            return null;
        }
        else {
            // list has one element
            if (getHead() != tail) {
                Node curr = getHead();
                // finds second to last node
                while (curr.next != tail) {
                    curr = curr.next;
                }
                tail = curr; // second to last element is new tail
                tail.next = null;
            }

            // removes and points to null
            else {
                tail = null;
                this.setHead(null);
            }
        }
        // update length
        int length = getLength();
        length--;
        setLength(length);

        return tail.data;
    }

    public void add(T data){ // add to the back of the list
        Node<T> back = new Node<T>(data);

        if(getHead() == null){
            setHead(back);
            tail = back;
        }

        else{ // set new Node to tail's next
            tail.next = back;
            tail = back; // tail set to new element
        }

        // update length
        int length = getLength();
        length++;
        setLength(length);
    }

    public void enqueue(T data){
        add(data);
    }

    public T dequeue() {
        return this.delete();
    }


}
