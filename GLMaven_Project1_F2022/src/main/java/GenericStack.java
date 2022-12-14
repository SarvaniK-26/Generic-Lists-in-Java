import java.util.Iterator;

public class GenericStack<T> extends GenericList<T> {
    private Node<T> tail;

    public GenericStack(T val){
        Node <T> head = new Node<T>(val);
        this.setHead(head);
        this.tail = head;
        this.setLength(1); // length must be 1 at start b/c of head
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
                // finds second to last moment
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

        // adjust for length
        int length = getLength();
        length--;
        setLength(length);

        return tail.data;
    }

    public void add(T data){
        Node <T> newFront = new Node<T>(data);
        if(getHead() == null){
            setHead(newFront);
        }
        else{ // set new Node to head
            newFront.next = getHead();
            setHead(newFront);
        }
        int length = getLength();
        length++;
        setLength(length);
    }

    public void push(T data){
        add(data);
    }

    public T pop(){
        return this.delete();
    }

}
