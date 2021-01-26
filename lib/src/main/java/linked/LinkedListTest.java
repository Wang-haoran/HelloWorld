package linked;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> a = new LinkedList<>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");

        LinkedList<String> b = new LinkedList<>();
        b.add("Bob");
        b.add("Dour");
        b.add("Frances");
        b.add("Gloria");

        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();

        while (bIter.hasNext()) {
            if (aIter.hasNext()) aIter.next();
            aIter.add(bIter.next());
        }
        System.out.println(a);

        bIter = b.iterator();
        while (bIter.hasNext()) {
            bIter.hasNext();
            if (bIter.hasNext()) {
                bIter.next();
                //bIter.remove();
            }
        }
        System.out.println(b);

        a.removeAll(b);
        System.out.println(a);
    }
}
