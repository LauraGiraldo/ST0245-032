/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

/**
 * Clase Pareja para poder hacer una lista que tenga dos valores en sus nodos
 *
 * @author xakol
 * @version (a version number or a date)
 */
public class Pareja {

    public int vertice;
    public int peso;

    public Pareja(int v, int p) {
        this.vertice = v;
        this.peso = p;
    }

    @Override
    /*
    @author Arpan Pathak from https://www.youtube.com/watch?v=fjT3WDKiAkI
    */
    public String toString() {
        return "{" + vertice + "," + peso + '}';
    }

}
