import java.util.ListIterator;
import java.util.function.Consumer;
import java.util.*;


public class GLListIterator <E> implements ListIterator<E> {
    public GenericList<E>.Node<E> curr;
    public GenericList<E>.Node<E> head;
    public int index;
    public int length;

    public GLListIterator(GenericList<E> genericList){
        curr = genericList.getHead();
        head = genericList.getHead();
        length = genericList.getLength();
        index = 0;

    }

    @Override
    public boolean hasNext() {
        if(curr.next != null){
            return true;
        }

        return false;
    }

    @Override
    public E next() {
        if (curr == null){
            throw new NoSuchElementException();
        }
        GenericList<E>.Node<E> temp = curr;
        curr = curr.next;
        index++;
        return temp.data;
    }

    @Override
    public boolean hasPrevious() {
        if(index != 0) {
            return true;
        }
        return false;
    }

    @Override
    public E previous() {
        if (!hasNext()){
            throw new NoSuchElementException();
        }

        GenericList<E>.Node<E> prev = null;
        curr = head;

        int i = 0;
        while(curr != null && index != i){
            prev = curr;
            curr = curr.next;
            i++;
        }
        curr = prev;
        index--;
        return curr.data;
    }

    @Override
    public int nextIndex() { // increment to next index using public index variable
        int nextIndex = index;
        if(index > length){
            return length;
        }
        if(hasNext() == true){
             nextIndex++;
        }
         return nextIndex;
    }

    @Override
    public int previousIndex() { // decrement to previous index using public index variable
        int prevIndex = index;
        if(index < 0){
            return -1;
        }
        if(hasPrevious() == true){
            prevIndex--;
        }
        return prevIndex;
    }

    @Override
    public void remove() { // throw exception
        throw new UnsupportedOperationException("Exception message: remove");
    }

    @Override
    public void forEachRemaining(Consumer<? super E> action) { // throw exception
        throw new UnsupportedOperationException("Exception message: forEachRemaining");
    }

    @Override
    public void set(E e) { // throw exception
        throw new UnsupportedOperationException("Exception message: set");
    }

    @Override
    public void add(E e) { // throw exception
        throw new UnsupportedOperationException("Exception message: add");
    }
}
