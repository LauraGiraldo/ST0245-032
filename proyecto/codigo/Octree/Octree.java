package Octree;

import java.util.ArrayList;
import java.util.LinkedList;
import javafx.geometry.Point3D;
import proyecto.PrevencionColisionesOctree;

public class Octree {

    public Point3D min;
    public Point3D max;
    public Point3D center;
    public Octree childNodes[];
    public ArrayList<Point3D> bees;
    public boolean hasChildren;

    public Octree(Point3D min, Point3D max, Point3D center) {
        this.min = min;
        this.max = max;
        this.center = center;
        this.bees = new ArrayList<>();
        hasChildren = false;
    }

    
    public void insert(Point3D p) {
            if (hasChildren) {
                int where = where(p);
                    childNodes[where].add(p);
                    //System.out.println("entro en hijo " + where);
               
            } else if (this.bees.size() == 8) {
                createChildren();
                for (int i = 0; i < this.bees.size(); i++) {
                    Point3D b = this.bees.get(i);
                    int where = where(b);
                    //System.out.println("Where " + where);
                    //System.out.println("Añadiendo: "+b);
                    childNodes[where].add(b);
                    //System.out.println(i+". entro de raiz en hijo " + where);
                }
                /*while (!this.bees.isEmpty()) {
                    Point3D b = bees.poll();
                    int where = where(b);
                    System.out.println("Where "+where);

                        childNodes[where].add(b);
                        System.out.println("entro de raiz en hijo "+ where);
                    
                }*/
                int where = where(p);
                    //System.out.println("Where " + where);
                    //System.out.println("Añadiendo: "+p);
                    childNodes[where].add(p);
                this.bees.clear();
            } else {
                this.bees.add(p);
                //System.out.println("Entro en raiz");
            }       
    }

    private void createChildren() {
        this.hasChildren = true;
        childNodes = new Octree[8];

        Point3D nmin = min;
        Point3D nmax = new Point3D(center.getX(), center.getY(), center.getZ());
        Point3D ncenter = new Point3D((nmin.getX() + nmax.getX()) / 2, (nmin.getY() + nmax.getY()) / 2, (nmin.getZ() + nmax.getZ()) / 2);
        childNodes[0] = new Octree(nmin, nmax, ncenter);

        nmin = new Point3D(center.getX(), min.getY(), min.getZ());
        nmax = new Point3D(max.getX(), center.getY(), center.getZ());
        ncenter = new Point3D((nmin.getX() + nmax.getX()) / 2, (nmin.getY() + nmax.getY()) / 2, (nmin.getZ() + nmax.getZ()) / 2);
        childNodes[1] = new Octree(nmin, nmax, ncenter);

        nmin = new Point3D(min.getX(), center.getY(), min.getZ());
        nmax = new Point3D(center.getX(), max.getY(), center.getZ());
        ncenter = new Point3D((nmin.getX() + nmax.getX()) / 2, (nmin.getY() + nmax.getY()) / 2, (nmin.getZ() + nmax.getZ()) / 2);
        childNodes[2] = new Octree(nmin, nmax, ncenter);

        nmin = new Point3D(center.getX(), center.getY(), min.getZ());
        nmax = new Point3D(max.getX(), max.getY(), center.getZ());
        ncenter = new Point3D((nmin.getX() + nmax.getX()) / 2, (nmin.getY() + nmax.getY()) / 2, (nmin.getZ() + nmax.getZ()) / 2);
        childNodes[3] = new Octree(nmin, nmax, ncenter);

        nmin = new Point3D(min.getX(), min.getY(), center.getZ());
        nmax = new Point3D(center.getX(), center.getY(), max.getZ());
        ncenter = new Point3D((nmin.getX() + nmax.getX()) / 2, (nmin.getY() + nmax.getY()) / 2, (nmin.getZ() + nmax.getZ()) / 2);
        childNodes[4] = new Octree(nmin, nmax, ncenter);

        nmin = new Point3D(center.getX(), min.getY(), center.getZ());
        nmax = new Point3D(max.getX(), center.getY(), max.getZ());
        ncenter = new Point3D((nmin.getX() + nmax.getX()) / 2, (nmin.getY() + nmax.getY()) / 2, (nmin.getZ() + nmax.getZ()) / 2);
        childNodes[5] = new Octree(nmin, nmax, ncenter);

        nmin = new Point3D(min.getX(), center.getY(), center.getZ());
        nmax = new Point3D(center.getX(), max.getY(), max.getZ());
        ncenter = new Point3D((nmin.getX() + nmax.getX()) / 2, (nmin.getY() + nmax.getY()) / 2, (nmin.getZ() + nmax.getZ()) / 2);
        childNodes[6] = new Octree(nmin, nmax, ncenter);

        nmin = new Point3D(center.getX(), center.getY(), center.getZ());
        nmax = new Point3D(max.getX(), max.getY(), max.getZ());
        ncenter = new Point3D((nmin.getX() + nmax.getX()) / 2, (nmin.getY() + nmax.getY()) / 2, (nmin.getZ() + nmax.getZ()) / 2);
        childNodes[7] = new Octree(nmin, nmax, ncenter);

    }

    private int where(Point3D p) {
        double x = p.getX();
        double y = p.getY();
        double z = p.getZ();
        if (x > min.getX() && x < center.getX() && y > min.getY() && y < center.getY() && z > min.getZ() && z < center.getZ()) {
            return 0;
        }
        if (x > center.getX() && x < max.getX() && y > min.getY() && y < center.getY() && z > min.getZ() && z < center.getZ()) {
            return 1;
        }
        if (x > min.getX() && x < center.getX() && y > center.getY() && y < max.getY() && z > min.getZ() && z < center.getZ()) {
            return 2;
        }
        if (x > center.getX() && x < max.getX() && y > center.getY() && y < max.getY() && z > min.getZ() && z < center.getZ()) {
            return 3;
        }
        if (x > min.getX() && x < center.getX() && y > min.getY() && y < center.getY() && z > center.getZ() && z < max.getZ()) {
            return 4;
        }
        if (x > center.getX() && x < max.getX() && y > min.getY() && y < center.getY() && z > center.getZ() && z < max.getZ()) {
            return 5;
        }
        if (x > min.getX() && x < center.getX() && y > center.getY() && y < max.getY() && z > center.getZ() && z < max.getZ()) {
            return 6;
        }

        return 7;
    }

    private void add(Point3D b) {
        if (hasChildren) {
            int where = where(b);
            childNodes[where].add(b);
        } else if(this.bees.size() >=8){
           createChildren();
                for (int i = 0; i < this.bees.size(); i++) {
                    Point3D p = this.bees.get(i);
                    int where = where(p);
                    //System.out.println("Where " + where);

                    childNodes[where].add(p);
                    //System.out.println(i+". entro de raiz en hijo " + where);
                }
                int where = where(b);
                    //System.out.println("Where " + where);
                    //System.out.println("Añadiendo: "+b);
                    childNodes[where].add(b);
                this.bees.clear();
        }else{
             bees.add(b);
        }
         
    }

    public ArrayList<Point3D> colision(ArrayList<Point3D> colisiones) {
        ArrayList<Point3D> beesAr = new ArrayList<>();
        if (this.hasChildren) {
            for (int i = 0; i < 8; i++) {
                this.childNodes[i].colision(colisiones);
            }
        }
        for (int i = 0; i < this.bees.size(); i++) {
            beesAr.add(bees.get(i));
        }
        /*while (!bees.isEmpty()) {
            beesAr.add(bees.poll());
        }*/
        if (beesAr.size() > 1) {
            for (int i = 0; i < beesAr.size(); i++) {
                for (int j = i + 1; j < beesAr.size(); j++) {
                    if (PrevencionColisionesOctree.distancia(beesAr.get(i), beesAr.get(j)) <= 100) {
                        if (!colisiones.contains(beesAr.get(i))) {
                            colisiones.add(beesAr.get(i));
                        }
                        if (!colisiones.contains(beesAr.get(j))) {
                            colisiones.add(beesAr.get(j));
                        }
                    }

                }
            }
        }

        return colisiones;
    }

}
