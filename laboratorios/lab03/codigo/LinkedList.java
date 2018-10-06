package lab3;

/**
 *
 * @author Andrés and Laura, using part of Mauricio's code
 */
public class LinkedList {

    private Node first;
    private Node last;
    private int size;

    public LinkedList() {
        size = 0;
        first = null;
    }

    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.insert(4, 0);
        l.insert(2, 0);
        l.insert(1, 0);
        l.insert(3, 2);
        l.remove(0);
    }

    /**
     * Returns the node at the specified position in this list.
     *
     * @param index - index of the node to return
     * @return the node at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    private Node getNode(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < size) {
            Node temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            throw new IndexOutOfBoundsException();

        }
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index - index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    public int get(int index) throws IndexOutOfBoundsException {
        Node temp = getNode(index);
        return temp.data;
    }

// Returns the size of the list
    public int size() {
        return size;
    }

    /**
     * Inserts data in index position
     *
     * @param index - index where we are going to insert
     * @throws IndexOutOfBoundsException
     * @complexity O(n) inserting elements in the middle of the list
     */
    public void insert(int data, int index) {

        if (index == 0) {

            Node temp = new Node(data);
            temp.next = first;
            if (first != null) {
                first.prev = temp;

            }

            first = temp;
            size++;
            last = getNode(size - 1);
            last.next = first;
            first.prev = last;

        } else {

            size++;
            Node aux = new Node(data);
            Node temp = getNode(index - 1);
            Node temp2 = getNode(index);
            temp.next = aux;
            aux.prev = temp;
            aux.next = temp2;
            temp2.prev = aux;
            last = getNode(size - 1);
            last.next = first;
            first.prev = last;

        }

    }

    public void remove(int index) {
        if (index == 0) {

            first = first.next;
            first.prev = last;
            last.next = first;
            size--;

        } else {
            size--;
            Node temp = getNode(index - 1);
            Node temp2 = temp.next.next;
            temp.next = temp2;
            temp2.prev = temp;

        }
    }

    public boolean contains(int data) {
        Node temp1 = first;
        Node temp2 = last;
        int i = 0;
        while (temp1.next != null && size / 2 <= i) {
            if (temp1.data == data) {

                return true;
            }
            temp1 = temp1.next;
            i++;
        }

        i = size - 1;

        while (temp2.next != null && size / 2 <= i) {
            if (temp2.data == data) {

                return true;
            }
            temp2 = temp2.next;
            i++;
        }

        return false;
    }
}
