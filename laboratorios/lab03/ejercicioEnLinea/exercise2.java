package ejercicios;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author xakol
 */
public class exercise2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        while (!text.equalsIgnoreCase("")) {

            LinkedList<Character> l = new LinkedList<>();
            int index = 0;
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == '[') {
                    index = 0;
                } else if (text.charAt(i) == ']') {
                    index = l.size();
                } else {
                    l.add(index++, text.charAt(i));
                }
            }
            Iterator I = l.iterator();
            while (I.hasNext()) {
                System.out.print(I.next());
            }
            System.out.println("");
            text = sc.nextLine();
        }

    }

}
