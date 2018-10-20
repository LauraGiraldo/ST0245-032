/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.util.ArrayList;

/**
 * Esta clase es una implementación de un digrafo usando matrices de adyacencia
 *
 * @author Mauricio Toro
 * @version 1
 */
public class DigraphAM extends Digraph {

    int matriz[][];

    public DigraphAM(int size) {
        super(size);
        matriz = new int[size][size];
    }

    @Override
    public int getWeight(int source, int destination) {
        return matriz[source][destination];
    }

    @Override
    public void addArc(int source, int destination, int weight) {
        matriz[source][destination] = weight;
    }

    @Override
    public ArrayList<Integer> getSuccessors(int vertex) {
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < matriz[vertex].length; i++) {
            if (matriz[vertex][i] != 0) {
                a.add(i);
            }
        }
        return a;
    }
}
