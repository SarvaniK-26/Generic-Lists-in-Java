import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.function.Consumer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import sun.net.www.content.text.Generic;

public class GSTest {
    @Test
    void checkStackPrint(){ // tests print method from GenericList (stack)
        GenericStack<Integer> list0 = new GenericStack<Integer>(0);
        for(int i = 1;i<6;i++){
            list0.push(i);
        }

        list0.print();
    }

    @Test
    void checkStackLength(){ // tests getLength method for stack (from genericList)
        GenericStack<Integer> list1 = new GenericStack<Integer>(0);
        for(int i = 0;i<50;i++){
            list1.push(i);
        }

        assertEquals(51,list1.getLength(),"wrong value");
    }


    @Test
    void checkStackRemove(){ // tests pop for full list (implements delete from GenericList) for Stack
        GenericStack<Integer> list2 = new GenericStack<Integer>(1);
        for(int i = 0; i<45;i++){
            list2.push(i);
        }

        for(int i = 0;i<45;i++){
            list2.pop();
        }
        assertEquals(1,list2.getLength(),"wrong value");

    }

    @Test
    void checkStackRemoveTail(){ // tests removeTail method for stack
        GenericStack<Integer> list3 = new GenericStack<Integer>(0);
        for(int i = 0;i<10;i++){
            list3.push(i);
        }
        assertEquals(0,list3.removeTail(),"wrong value");
    }


    @Test
    void checkStackDelete(){ // tests that pop works to delete one element
        GenericStack<Integer> list4 = new GenericStack<Integer>(0);
        for(int i = 0;i<51;i++){
            list4.push(i);
        }

        assertEquals(50,list4.pop(),"wrong value");
    }

    @Test
    void checkStackDumpList(){ // tests dumpList from GenericList for Stack
        GenericStack<Integer> stack1 = new GenericStack<Integer>(1);
        for(int i= 2;i<=10;i++){
            stack1.push(i);
        }
        ArrayList<Integer> stackcheck = stack1.dumpList();
        ArrayList<Integer> expectedList = new ArrayList<Integer>();

        for(int i = 10;i>=1;i--){
            expectedList.add(i);
        }

        Integer expectedArray[] = expectedList.toArray(new Integer [0]);
        Integer stackcheckArray[] = stackcheck.toArray(new Integer [0]);

        assertArrayEquals(expectedArray,stackcheckArray,"wrong values");
    }

    @Test
    void checkStackGetList(){ // tests get method from GenericList to get a element of Stack
        GenericStack<Integer> stack = new GenericStack<Integer>(0);
        for(int i = 1;i<=3;i++){
            stack.push(i);
        }

        assertEquals(3,stack.get(0),"wrong value");
    }

    @Test
    void checkStackSetLength(){ // tests set length from GenericList to set length of a stack
        GenericStack<Integer> stack = new GenericStack<>(1);
        stack.setLength(34);

        assertEquals(34,stack.getLength(),"wrong value");
    }

    @Test
    void checkStackSetIndex(){ // tests set index from GenericList to set the first index of a stack to a number
        GenericStack<Integer> stack = new GenericStack<>(1);
        for(int i = 2;i<=10;i++){
            stack.push(i);
        }
        stack.set(0,999);
        stack.print();
        assertEquals(999,stack.get(0),"wrong value");
    }

    @Test
    void checkStackListSetHead(){ // tests setHead from GenericList to set the head of Stack to a new number
        GenericStack<Integer> stack = new GenericStack<>(1);
        GenericList<Integer>.Node<Integer> test = stack.new Node<Integer>(999);
        stack.setHead(test);
        assertEquals(999,stack.getHead().data,"wrong value");
    }


    @Test
    void checkStackIteratorhasNext(){ // tests if stack has next element
        GenericStack<Integer> stack = new GenericStack<>(1);
        for(int i = 2;i<5;i++){
            stack.push(i);
        }
        Iterator<Integer> iterator  = stack.iterator();

        assertEquals(true,iterator.hasNext(),"wrong value");
    }

    @Test
    void checkStackIteratorNext(){ // tests next method part of GLLiterator
        GenericStack<Integer> stack = new GenericStack<>(1);
        for(int i = 2;i<5;i++){
            stack.push(i);
        }
        Iterator<Integer> iterator  = stack.iterator();

        assertEquals(4, iterator.next(),"wrong value");
    }

    @Test
    void checkStackIteratorHasPrevious(){ // tests next method part of GLLiterator (Hasprev)
        GenericStack<Integer> stack = new GenericStack<>(1);
        for(int i = 2;i<5;i++){
            stack.push(i);
        }
        Iterator<Integer> descendingIterator  = stack.iterator();

        assertEquals(true,descendingIterator.hasNext(),"wrong value");
    }

    @Test
    void checkStackIteratorPrevious(){  // tests next method part of GLLiterator (prev)
        GenericStack<Integer> stack = new GenericStack<>(1);
        for(int i = 2;i<5;i++){
            stack.push(i);
        }
        Iterator<Integer> descendingIterator  = stack.descendingIterator();

        assertEquals(2,descendingIterator.next(),"wrong value");
    }

    @Test
    void checkStackListIteratorHasNext(){ // GLListIterator test for has next
        GenericStack<Integer> stack = new GenericStack<>(1);
        for(int i = 2;i<5;i++){
            stack.push(i);
        }

        ListIterator<Integer> listIterator = stack.listIterator(0);
        assertEquals(true,listIterator.hasNext(),"wrong value");
    }

    @Test
    void checkStackListIteratorNext(){ // GLListIterator test for next
        GenericStack<Integer> stack = new GenericStack<>(1);
        for(int i = 2;i<5;i++){
            stack.push(i);
        }

        ListIterator<Integer> listIterator = stack.listIterator(1);
        assertEquals(3,listIterator.next(),"wrong value");
    }

    @Test
    void checkStackListIteratorHasPrev(){ // tests GLListIterator for hasPrevious
        GenericStack<Integer> stack = new GenericStack<>(1);
        for(int i = 2;i<5;i++){
            stack.push(i);
        }

        ListIterator<Integer> listIterator = stack.listIterator(1);
        assertEquals(true,listIterator.hasPrevious(),"wrong value");
    }

    @Test
    void checkStackListIteratorPrev(){ // tests GLListIterator for previous
        GenericStack<Integer> stack = new GenericStack<>(1);
        for(int i = 2;i<5;i++){
            stack.push(i);
        }

        ListIterator<Integer> listIterator = stack.listIterator(1);
        assertEquals(4,listIterator.previous(),"wrong value");
    }

    @Test
    void checkStackListIteratorNextIndex(){ // tests GLListIterator for nextIndex
        GenericStack<Integer> stack = new GenericStack<>(1);
        for(int i = 2;i<5;i++){
            stack.push(i);
        }

        ListIterator<Integer> listIterator = stack.listIterator(2);
        assertEquals(3,listIterator.nextIndex(),"wrong value");

    }

    @Test
    void checkStackListIteratorPrevIndex(){ // tests GLListIterator for prevIndex
        GenericStack<Integer> stack = new GenericStack<>(1);
        for(int i = 2;i<5;i++){
            stack.push(i);
        }

        ListIterator<Integer> listIterator = stack.listIterator(3);
        assertEquals(2,listIterator.previousIndex(),"wrong value");

    }

    @Test
    void forEach(){ // tests forEach for iterator
        GenericStack<Integer> list = new GenericStack<>(1);
        for(int i = 2;i<5;i++){
            list.push(i);
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
