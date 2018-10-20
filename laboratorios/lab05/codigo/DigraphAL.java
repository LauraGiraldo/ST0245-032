/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Esta clase es una implementación de un digrafo usando listas de adyacencia
 *
 * @author Mauricio Toro, Arpan Pathak from youtube: https://www.youtube.com/watch?v=fjT3WDKiAkI

 * @version 1
 */
public class DigraphAL extends Digraph {
    LinkedList<Pareja>[] G;
    public DigraphAL(int size) {
        super(size);
        G = new LinkedList[size];
        for (int i = 0; i < G.length; i++) {
            G[i] = new LinkedList<Pareja>();
        }
    }

    public void addArc(int source, int destination, int weight) {
        G[source].add(new Pareja(destination,weight));
    }

    public int getWeight(int source, int destination) {
        for (Pareja i : G[source]) {
            if(i.vertice == destination){
                return i.peso;
            }
        }
        return 0;
    }

    @Override
    public ArrayList<Integer> getSuccessors(int vertice) {
        ArrayList<Integer> a = new ArrayList<>();
        for (Pareja i : G[vertice]) {
            a.add(i.vertice);
        }
        return a;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < G.length; i++) {
            result += i+"=>"+G[i]+"\n";
        }
        return result;
    }
    
}
