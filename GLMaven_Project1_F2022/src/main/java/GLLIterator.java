import java.util.Iterator;
import java.util.NoSuchElementException;

public class GLLIterator <E> implements Iterator<E>  {
    public GenericList<E>.Node<E> curr;

    public GLLIterator(GenericList<E> genericList){
         curr = genericList.getHead();
    }

    @Override
    public boolean hasNext() {
        // if next is null then no next
        if(curr.next != null){
            return true;
        }

        return false;
    }

    @Override
    public E next() {
        // if curr is null then at tail
        if (curr == null){
            throw new NoSuchElementException();
        }
        GenericList<E>.Node<E> temp = curr;
        curr = curr.next;
        return temp.data;
    }
}
