package Q5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class represents a two ways generic Cycled linked-list
 * from the drive:
 * https://drive.google.com/drive/folders/1h5AgB76g6ESpvD2MDFsbwfpgbjnFKlnA
 */
public class LinkedList<T> {
    // Variables
    private Node head;
    private int size;

    // Constructor
    public LinkedList() { // initializing the linked-list
        head = null;
        size = 0;
    }


    class ListIterator implements Iterator {
        private int count;
        private Node current;
        private boolean nextCall;

        public ListIterator() {
            count = 0;
            current = head;
            nextCall = false;
        }

        @Override
        public boolean hasNext() {
            return !(count == size); // if the counter hasn't got tot the size, meas we have next
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException(); // IF we don;t have next
            nextCall = true;
            T ans = (T) current.data;
            current = current.right;
            return ans;
        }

        @Override
        public void remove() {
            // Iterator.super.remove();
            if (!nextCall) throw new IllegalStateException();
            current.left.right = current.right;
            nextCall = false;
        }
    }

    // Copy constructor
    public LinkedList(LinkedList<T> list) {
        Node node = list.head;
        for (int i = 0; i < list.size; i++) { // we can to it also with Node running loop (Node n = list.head; n !=null; n = n.right){n.data = list.data
            add((T) node.data);
            node = node.right;
        }
    }

    public void add(T data) {
        if (head == null) {
            head = new Node(data);
            head.right = head.left = head;
        } else { // To make it cycled
            Node n = new Node(data);
            n.right = head;
            n.left = head.left;
            head.left.right = n;
            head.left = n;
        }
        size++;
    }

    public T remove(T data) { // We first need to find the data
        T ans = null;
        Node node = head;
        int i = 0;
        for (i = 0; i < size; i++) { // We an do the loop also by going over with nodes
            if (node.data.equals(data)) {
                break; // breaking the loop so we can handel the remove
            }
            node = node.right;
        }
        if (i == size) { // means we've finished going over the whole list and didn't find the data we've searched
            return null;
        }
        if (node == head) { // means this is the first element
            ans = (T) head.data;
            head.left.right = head.right;
            head.right.left = head.left;
            head = head.right;
        } else {
            ans = (T) node.data;
            node.left.right = node.right;
            node.right.left = node.left;
        }
        size--;
        return ans; // That how we know that it has been removed
    }

    @Override
    public String toString() {
        String ans = "";
        ans += "LinkedList{";
//                + "head=" + head.data;
        for (Node n = head; n != null; n = n.right) { // Loop by nodes
            ans += n.data;
        }
         /*
         for (int i = 0; i < size-1; i++) { // Loop by the size
			ans += n.data + ", ";
			n = n.next;
		}
		if(size > 0) ans += n.data;
		return ans + "]";
          */
        ans += ", size=" + size + '}';
        return ans;
    }

    public ListIterator iterator() {
        return new ListIterator();
    }
}
