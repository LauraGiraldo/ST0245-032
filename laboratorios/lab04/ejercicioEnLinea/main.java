public class main {
    public static void main(String ...args){
        Node root= new Node("Laura");
        Node papa= new Node("Carlos");
        Node mama= new Node("Beatriz");
        Node abueloM= new Node("Luis");
        Node abuelaM= new Node("Maria");
        Node bisabueloM= new Node("Jose");
        Node bisabuelaM= new Node(" ");
        Node bisabueloM2= new Node(" ");
        Node bisabuelaM2= new Node(" ");
        Node abueloP= new Node("Carlos");
        Node abuelaP= new Node("Ana");
        Node bisabueloP= new Node(" ");
        Node bisabuelaP= new Node(" ");
        Node bisabueloP2= new Node(" ");
        Node bisabuelaP2= new Node(" ");

        root.setLeft(mama);
        root.setRight(papa);
        mama.setLeft(abuelaM);
        mama.setRight(abueloM);
        abuelaM.setLeft(bisabuelaM);
        abuelaM.setRight(bisabueloM);
        abueloM.setLeft(bisabuelaM2);
        abueloM.setRight(bisabueloM2);
        papa.setLeft(abuelaP);
        papa.setRight(abueloP);
        abuelaP.setLeft(bisabuelaP);
        abuelaP.setRight(bisabueloP);
        abueloP.setLeft(bisabuelaP2);
        abueloP.setRight(bisabueloP2);

        System.out.println("Árbol familiar: ");
        posOrden(root);
    }

    private static void posOrden(Node root){

        if(root!= null){
            posOrden(root.getLeft());
            posOrden(root.getRight());
            System.out.println(root.getDato());
        }
    }

}
