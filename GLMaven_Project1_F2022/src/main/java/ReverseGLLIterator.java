import sun.net.www.content.text.Generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ReverseGLLIterator <E> implements Iterator<E> {
    public GenericList<E>.Node<E> curr;
    public GenericList<E>.Node<E> head;
    public int index;

    public ReverseGLLIterator(GenericList<E> genericList){
        curr = genericList.getHead();
        head = genericList.getHead();
        index = genericList.getLength()-1;
    }


    @Override
    public boolean hasNext(){
        // only head doesn't have a previous
        if(index != 0) {
            return true;
        }
        return false;
    }

    @Override
    public E next() {
        if (!hasNext()){
            throw new NoSuchElementException();
        }

        GenericList<E>.Node<E> prev = null;
        curr = head;

        int i = 0;
        while(index != i){ // increment until index is equal to i
            prev = curr;
            curr = curr.next; // iterate curr
            i++;
        }

        curr = prev;
        index--; // increment index

        return curr.data; // returns only curr's data (not prev)
    }

}

