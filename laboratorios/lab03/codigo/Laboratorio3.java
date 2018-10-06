/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author xakol
 */
public class Laboratorio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //exercise 1 array
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        SmartInsert(a, 1);
        //exercise 1 list
        LinkedList<Integer> l = new LinkedList<>();
        l.add(1);
        SmartInsert(l, 1);
        //exercise 2 list
        l = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            l.add(1);
        }
        l.add(9);
        System.out.println(pivot(l));
        //ejercicio 2 array
         a = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            a.add(1);
        }
        a.add(9);
        System.out.println(pivot(a));
    }

    public static void SmartInsert(ArrayList<Integer> l, int data) {
        if (!l.contains(data)) {
            l.add(data);
        } else {
            System.out.println("This number has been already added");
        }
    }

    public static void SmartInsert(LinkedList<Integer> l, int data) {
        if (!l.contains(data)) {
            l.addLast(data);
        } else {
            System.out.println("This number has been already added");
        }
    }

    public static int pivot(LinkedList<Integer> l) {
        int sum1 = 0;
        int sum2 = 0;
        int menor = 1000000000;
        int indice = 0;
        Iterator I = l.iterator();
        while (I.hasNext()) {
            int num = (int) I.next();

            sum1 += num;
        }
        int k = 0;
        I = l.iterator();
        while (I.hasNext()) {
            if (Math.abs(sum1 - sum2) < menor) {
                menor = Math.abs(sum1 - sum2);
                indice = k;
            } else {
                return indice;
            }
            int num = (int) I.next();

            sum2 += num;
            sum1 -= num;

            k++;
        }
        return indice;
    }
    
    public static int pivot(ArrayList<Integer> a) {
        int sum1 = 0;
        int sum2 = 0;
        int menor = 1000000000;
        int indice = 0;
        for (int i = 0; i < a.size(); i++) {
            int num = a.get(i);

            sum1 += num;
        }
        for (int i = 0; i < a.size(); i++) {
            if (Math.abs(sum1 - sum2) < menor) {
                menor = Math.abs(sum1 - sum2);
                indice = i;
            } else {
                return indice;
            }
            int num = a.get(i);

            sum2 += num;
            sum1 -= num;
        }
        return indice;
    }

    public static void exercise3(Fridge[] fridges, Shops[] requests) {

        Stack<Fridge> viNu = new Stack();

        Queue<Shops> anRe = new LinkedList<>();

        for (int i = 0; i < fridges.length; i++) {
            viNu.push(fridges[i]);
        }

        for (int i = 0; i < requests.length; i++) {
            anRe.add(requests[i]);
        }

        while (!anRe.isEmpty()) {

            Shops tienda = anRe.poll();
            String name = tienda.name;
            int pedido = tienda.cant;

            while (!viNu.isEmpty() && pedido != 0) {

                Fridge fridge = viNu.pop();
                int code = fridge.code;
                String des = fridge.des;

                System.out.println("The fridge with code " + code + " has been sent to the shop " + name);
                pedido--;
            }
        }
    }

}
