package linkedlist;

import java.lang.IndexOutOfBoundsException; // Usar esto cuando se salga el índice
import linkedlist.Node;
// Una lista simplemente enlazada

public class LinkedList {

    private Node first;
    private int size;

    public LinkedList() {
        size = 0;
        first = null;
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

// Retorna el tamaño actual de la lista
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
                first = temp;
                size++;
   
            }else{
            size++;
            Node aux = new Node(data);
            Node temp = getNode(index-1);
            Node temp2 = getNode(index);
            temp.next = aux;
            aux.next = temp2;
        }

        
    }

// Borra el dato en la posición index
    public void remove(int index) {
         if (index == 0) {
            
                first = first.next;
                size--;
   
            }else{
            size--;
            Node temp = getNode(index-1);
            temp.next= temp.next.next;
           
        }
    }

// Verifica si está un dato en la lista
    public boolean contains(int data) {
        Node temp = first;
        while (temp.next != null) {
            if (temp.data == data) {
                
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    
    // Verifica si está un dato en la lista y retorna su posición si no esta retorna -1
    public int IndexOf(int data) {
        int aux=0;
        Node temp = first;
        while (temp.next != null) {
            if (temp.data == data) {
                
                return aux;
            }
            temp = temp.next;
            aux++;
        }
        
        return -1;
    }
    

}
