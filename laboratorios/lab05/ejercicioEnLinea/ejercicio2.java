/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author xakol
 */
public class ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n != 0) {
            DigraphAM g = new DigraphAM(n);
            int arc = sc.nextInt();
            for (int i = 0; i < arc; i++) {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                g.addArc(n1, n2, 1);
            }
            System.out.println(isBicolorable(g));
            n = sc.nextInt();
        }
    }

    public static String isBicolorable(Digraph g) {
        int n = g.size;
        int color[] = new int[n];
        for (int i = 0; i < n; i++) {
            color[i] = -1;
        }
        color[0] = 1;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {

                if (g.getWeight(j, i) != 0 && color[i] == -1) {

                    color[i] = 1 - color[j];

                } else if (g.getWeight(j, i) != 0 && color[j] == color[i]) {
                    return "NOT BICOLORABLE";
                }
            }
        }

        return "BICOLORABLE";
    }
}
