import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.ArrayList;


public abstract class GenericList<T> implements Iterable<T>{
    public class Node <T>{
        public T data;
        public Node <T> next;

        public Node(T val){
            data = val;
        }
    }

    private Node <T> head;
    private int length;

    public void print(){
        Node<T> curr = head;
        if(curr == null){ // checks for empty list
            System.out.println("Empty List");
        }

        for(int i = 0;i<length;i++){
            System.out.println(curr.data);
            curr = curr.next;
        }

    }

    public abstract void add(T data);

    public T delete(){
        if(head == null){
            return null;
        }
        // set new curr to head
        Node<T> curr = head;
        head = head.next; // iterate head
        curr.next = null;
        length--; // decrement length
        return curr.data;

    }

    public ArrayList<T> dumpList(){
        ArrayList <T> list = new ArrayList<>(length);

        for(int i = 0;i<length;i++){
            list.add(head.data);
            head = head.next;
        }

        return list;
    }

    public T get(int index){
        Node <T> temp = head;
        if(index < 0 || index >= length){
            return null;
        }

        for (int i = 0; i < index; i++) {
            temp = temp.next; // iterate till index is found
        }

        return temp.data;
    }

    public T set(int index, T element){
        if (index < 0 || index >= length) {
            return null;
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) { // iterate till index is found
            current = current.next;
        }
        current.data = element; // set node's new data to element
        return element;
    }

    public int getLength(){
        return this.length;
    }

    public Node<T> getHead(){

        return this.head;
    }

    public void setHead(Node<T> head){
        this.head = head;
    }

    public void setLength(int length){
        this.length = length;
    }


    public ListIterator<T> listIterator(int index){
        GLListIterator<T> iterator  = new GLListIterator<T>(this);

        int i = 0;
        while(i != index){ // increment until index == i
            iterator.next(); // iterates to next
            i++;
        }


        return iterator;
    }

    public Iterator <T> descendingIterator(){
        return new ReverseGLLIterator<>(this);
    }

    public Iterator <T> iterator(){
        return new GLLIterator<T>(this);
    }

}
