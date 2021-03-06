package Array;

import java.util.Arrays;

/**
 * La clase MiArrayList tiene la intención de representar un objeto que simule
 * el comportamiento de la clase ya implementada "ArrayList" es claro que no se
 * puede utilizar dicha estructura ya utilizada dentro de este ejercicio. Para
 * más información de la clase ArrayList:
 *
 * @see
 * <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html">
 * Ver documentacion ArrayList </a>
 *
 *
 * @author Mauricio Toro, Andres Paez
 * @version 1
 */
public class MiArrayList {

    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private int elements[];

    /**
     * El metodo constructor se utiliza para incializar variables a valores
     * neutros como 0 o null. El contructor no lleva parámetros en este caso.
     */
    public MiArrayList() {
        this.size = 0;
        this.elements = new int[DEFAULT_CAPACITY];
    }

    /**
     * Tiene la intención de retornar la longitud del objeto
     *
     * @return longitud del objeto
     *
     * El size esta influenciado por las funciones add y del
     */
    public int size() {
        return this.size;
    }

    /**
     * @param e el elemento a guardar Agrega un elemento e a la última posición
     * de la lista
     *
     */
    public void add(int e) {

        if (size == elements.length) {
            int[] aux = new int[elements.length * 2];
            for (int i = 0; i < elements.length; i++) {
                aux[i] = elements[i];

            }
            elements = aux;
            elements[size] = e;
            size = size + 1;
        } else {
            elements[size] = e;
            size = size + 1;
        }
    }

    /**
     * @param i es un íncide donde se encuentra el elemento posicionado Retorna
     * el elemento que se encuentra en la posición i de la lista.
     *
     */
    public int get(int i) {
        if (i >= 0 && i < size) {
            return elements[i];

        } else {
            throw new RuntimeException("No hay elementos en esa posición");
        }

    }

    /**
     * @param index es la posicion en la cual se va agregar el elemento
     * @param e el elemento a guardar Agrega un elemento e en la posición index
     * de la lista
     *
     */
    public void add(int index, int e) {
        if (size == elements.length) {
            int[] aux = new int[elements.length * 2];
            if (index >= 0 && index < size) {
                for (int i = 0; i < index; i++) {
                    aux[i] = elements[i];
                }
                aux[index] = e;

                for (int i = index + 1; i < elements.length; i++) {
                    aux[i] = elements[i];
                }
            }
            elements = aux;
            size = size + 1;
        } else {
            int[] aux = new int[elements.length];
            if (index >= 0 && index < size) {
                for (int i = 0; i < index; i++) {
                    aux[i] = elements[i];
                }
                aux[index] = e;

                for (int i = index + 1; i < elements.length; i++) {
                    aux[i] = elements[i];
                }
            }
            elements = aux;
            size = size + 1;
        }
    }

    /**
     * @param index es la posicion en la cual se va agregar el elemento
     *
     * ELimina el elemento en la posición index de la lista
     *
     */
    public void del(int index) {
        if (0 <= index && index < elements.length - 1) {
            for (int i = 0; i < elements.length - 1; i++) {
                elements[index] = elements[index + 1];
            }
        }
        this.size -= 1;
    }
}
