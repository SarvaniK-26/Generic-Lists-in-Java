import static org.junit.jupiter.api.Assertions.*;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import sun.net.www.content.text.Generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.function.Consumer;

public class GQTest {
    @Test
    void checkQueueLength(){  // tests queue's length using getLength from GenericList
        GenericQueue<Integer> queue1 = new GenericQueue<Integer>(0);
        for(int i = 0;i<75;i++){
            queue1.enqueue(i);
        }
        assertEquals(76,queue1.getLength(),"wrong value");
    }

    @Test
    void checkQueuePrint(){ // tests print method from GenericList (stack)
        GenericQueue<Integer> queue0 = new GenericQueue<Integer>(0);
        for(int i = 1;i<6;i++){
            queue0.enqueue(i);
        }
        queue0.print();
    }


    @Test
    void checkQueueRemove(){ // tests enqueue function which implements delete from GenericList
        GenericQueue<Integer> queue2 = new GenericQueue<Integer>(1);
        for(int i = 0; i<45;i++){
            queue2.enqueue(i);
        }
        for(int i = 0;i<45;i++){
            queue2.dequeue();
        }
        assertEquals(1,queue2.getLength(),"wrong value");
    }

    @Test
    void checkQueueRemoveTail(){ // tests removeTail on a queue
        GenericQueue<Integer> queue3 = new GenericQueue<Integer>(0);
        for(int i = 1;i<11;i++){
            queue3.enqueue(i);
        }
        assertEquals(9,queue3.removeTail(),"wrong value");
    }

    @Test
    void checkQueueDelete(){ // tests deleting the first element from queue
        GenericQueue<Integer> queue3 = new GenericQueue<Integer>(0);
        for(int i = 1;i<11;i++){
            queue3.enqueue(i);
        }
        assertEquals(0,queue3.dequeue(),"wrong value");
    }

    @Test
    void checkDumpList(){ // tests dumpList from GenericList on Queue
        GenericQueue<Integer> queue5 = new GenericQueue<Integer>(1);
        for(int i= 2;i<=10;i++){
            queue5.enqueue(i);
        }
        ArrayList<Integer> queue3 = queue5.dumpList();
        ArrayList<Integer> expectedList = new ArrayList<Integer>();

        for(int i = 1;i<11;i++){
            expectedList.add(i);
        }

        Integer expectedArray[] = expectedList.toArray(new Integer [0]);
        Integer queue3Array[] = queue3.toArray(new Integer [0]);

        assertArrayEquals(expectedArray,queue3Array,"wrong values");
    }

    @Test
    void checkQueueGetList(){ // tests get method from GenericList on Queue
        GenericQueue<Integer> queue = new GenericQueue<Integer>(1);
        for(int i = 2;i < 11;i++){
            queue.enqueue(i);
        }

        assertEquals(10,queue.get(9),"wrong value");
    }

    @Test
    void checkQueueSetLength(){ // tests set length from GenericList on Queue
        GenericQueue<Integer> queue = new GenericQueue<>(1);
        queue.setLength(4);
        assertEquals(4,queue.getLength(),"wrong value");
    }

    @Test
    void checkQueueSetIndex(){ // tests set index from GenericList on Queue
        GenericQueue<Integer> queue = new GenericQueue<>(1);
        for(int i= 2;i<=10;i++){
            queue.enqueue(i);
        }
        queue.set(0,999);
        assertEquals(999,queue.get(0),"wrong value");
    }

    @Test
    void checkQueueListSetHead(){ // tests setHead from GenericList on Queue
        GenericQueue<Integer> queue = new GenericQueue<>(1);
        GenericList<Integer>.Node<Integer> test = queue.new Node<Integer>(54);
        queue.setHead(test);
        assertEquals(54,queue.getHead().data,"wrong value");
    }

    @Test
    void checkQueueIteratorhasNext(){ // tests if queue has next element
        GenericQueue<Integer> queue = new GenericQueue<>(1);
        for(int i = 2;i<5;i++){
            queue.enqueue(i);
        }
        Iterator<Integer> iterator  = queue.iterator();

        assertEquals(true,queue.iterator().hasNext(),"wrong value");
    }

    @Test
    void checkQueueIteratorNext(){ // tests next method part of GLLiterator
        GenericQueue<Integer> queue = new GenericQueue<>(1);
        for(int i = 2;i<5;i++){
            queue.enqueue(i);
        }

        Iterator<Integer> iterator  = queue.iterator();

        assertEquals(1,iterator.next(),"wrong value");
    }

    @Test
    void checkQueueIteratorNext2(){ // tests next method part of GLLiterator (moves to next 2 times)
        GenericQueue<Integer> queue = new GenericQueue<>(1);
        for(int i = 2;i<5;i++){
            queue.enqueue(i);
        }

        Iterator<Integer> iterator  = queue.iterator();
        iterator.next();

        assertEquals(2,iterator.next(),"wrong value");
    }

    @Test
    void checkQueueHasPrevious(){ // tests if queue has previous element (starts at the end of the list) will return true
        GenericQueue<Integer> queue = new GenericQueue<>(1);
        for(int i = 2;i<5;i++){
            queue.enqueue(i);
        }

        Iterator<Integer> descendingIterator  = queue.descendingIterator();
        Boolean check = descendingIterator.hasNext();
        assertEquals(true,check,"wrong value");
    }

    @Test
    void checkQueuePrevious(){
        GenericQueue<Integer> queue = new GenericQueue<>(1);
        for(int i = 2;i<5;i++){
            queue.enqueue(i);
        }

        Iterator<Integer> descendingIterator  = queue.descendingIterator();
        assertEquals(3,descendingIterator.next(),"wrong value");
    }

    @Test
    void checkQueueListIteratorHasNext(){ // GLListIterator test for has next
        GenericQueue<Integer> queue = new GenericQueue<>(1);
        for(int i = 2;i<5;i++){
            queue.enqueue(i);
        }

        ListIterator<Integer> listIterator = queue.listIterator(0);
        assertEquals(true,listIterator.hasNext(),"wrong value");
    }

    @Test
    void checkQueueListIteratorNext(){ // GLListIterator test for next
        GenericQueue<Integer> queue = new GenericQueue<>(1);
        for(int i = 2;i<5;i++){
            queue.enqueue(i);
        }

        ListIterator<Integer> listIterator = queue.listIterator(1);
        assertEquals(2,listIterator.next(),"wrong value");
    }

    @Test
    void checkQueueListIteratorHasPrev(){ // GLListIterator test for has prev
        GenericQueue<Integer> queue = new GenericQueue<>(1);
        for(int i = 2;i<5;i++){
            queue.enqueue(i);
        }

        ListIterator<Integer> listIterator = queue.listIterator(1);
        assertEquals(true,listIterator.hasPrevious(),"wrong value");
    }

    @Test
    void checkQueueListIteratorPrev(){ // GLListIterator test for previous
        GenericQueue<Integer> queue = new GenericQueue<>(1);
        for(int i = 2;i<5;i++){
            queue.enqueue(i);
        }

        ListIterator<Integer> listIterator = queue.listIterator(1);
        assertEquals(1,listIterator.previous(),"wrong value");
    }

    @Test
    void checkQueueListIteratorNextIndex(){ // GLListIterator test for next index
        GenericQueue<Integer> queue = new GenericQueue<>(1);
        for(int i = 2;i<5;i++){
            queue.enqueue(i);
        }

        ListIterator<Integer> listIterator = queue.listIterator(2);
        assertEquals(3,listIterator.nextIndex(),"wrong value");

    }

    @Test
    void checkQueueListIteratorPrevIndex(){ // GLListIterator test for previous index
        GenericQueue<Integer> queue = new GenericQueue<>(1);
        for(int i = 2;i<5;i++){
            queue.enqueue(i);
        }

        ListIterator<Integer> listIterator = queue.listIterator(3);
        assertEquals(2,listIterator.previousIndex(),"wrong value");

    }



    @Test
    void forEach(){ // tests forEach for iterator
        GenericQueue<Integer> list = new GenericQueue<>(1);
        for(int i = 2;i<5;i++){
            list.enqueue(i);
        }

        ListIterator<Integer> listIterator = list.listIterator(3);
        list.forEach(new Consumer<Integer>() {
        @Override
        public void accept(Integer integer) {
            while(listIterator.hasNext()){
                listIterator.next();
            }
          }
         }
       );
    }
}
