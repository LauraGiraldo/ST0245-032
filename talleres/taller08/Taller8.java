
package taller8;
import java.util.*;
/**
 *
 * @author xakol
 */
/**
 * La clase Taller8 tiene la intención de
 * enfatizar en el uso de pilas y colas ya 
 * implementadas en java
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Queue.html"> Ver más acerca de colas<a/>
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html"> Ver más acerca de pilas <a/> 
 * @author Mauricio Toro, Andrés Páez 
 */
public class Taller8 {
	
    /**
    * @param stack es una pila ya implementada que se crea en el test
    * Este método se encarga de poner la pila stack en orden inverso
    * Nota: recuerde que la funcion pop() no solo expulsa la última 
    * posición de una pila si no que tambien devuelve su valor.
    * @return una pila que haga el inverso de stack
    */
    public static Stack<Integer> inversa (Stack<Integer> stack){
        Stack<Integer> inversa = new Stack();
        Stack<Integer> aux = stack;
        while(!aux.empty()){
            inversa.push(aux.pop());
        }
        return inversa;
    }
    
    
    /**
    * @param queue es una cola ya implementada que se crea en el test
    * Este método se encarga de atender a personas.
    * Nota: Se debe imprimir en consola a quién atiende y sacarlo de la cola
    * existe una función "pull" que hace el trabajo más fácil
    * 
    */
    public static void cola(Queue<String> queue){
        System.out.println(queue.poll());
    }
    
    
    /**
    * @param string es una cadena de texto que viene de este modo 3 4 5 * + o de esta manera 2 3 * 5 +
    * todo viene separado por espacios por lo que la funcion split.("") vendría muy bien para separarlos
    * Se intenta hacer el calculo por medio del metodo polaco posfijo
    * @return un entero resultado de la operación
    */
    public static int polaca  (String string){
        Stack<Integer> pila = new Stack();
        String[] split = string.split(" ");
        for (int i = 0; i < split.length; i++) {
            if(Character.isDigit(split[i].charAt(0))){
                pila.push(Integer.parseInt(split[i])); 
                System.out.print(pila.peek());
            }else if(split[i].charAt(0) == '+'){
                pila.push(pila.pop()+pila.pop());
                System.out.print(pila.peek());
            }else if(split[i].charAt(0) == '*'){
                pila.push(pila.pop()*pila.pop());
                System.out.print(pila.peek());
            }else if(split[i].charAt(0) == '/'){
                pila.push(pila.pop()/pila.pop());
                System.out.print(pila.peek());
            }else if(split[i].charAt(0) == '-'){
                int num1 = pila.pop();
                int num2 = pila.pop();
                pila.push(num2 - num1);
                System.out.print(pila.peek());
            }
           
        }
        System.out.print(pila.peek());
        return pila.pop();
    }
    /**
    * @param almacen es un arreglo de neveras organizadas de la mas nueva a la mas vieja
    * @param pedidos es un arreglo de tiendas que hicieron pedidos, ordenadas de el pedido mas antiguo a el mas reciente
    * Este metodo se encarga de enviar los pedidos de neveras a las tiendas.
    */
    public static void entregar(Nevera[] almacen, Tiendas[] pedidos){
        //Se crea una pila donde estaran las neveras de las mas viejas a las mas nuevas
        Stack<Nevera> viNu = new Stack();
        //Se crea una lista donde estaran los pedidos de el mas antiguo a el mas reciente
        Queue<Tiendas> anRe = new LinkedList<>();
        //Se llena la pila con las neveras del arreglo, quedando las mas nuevas a lo ultimo y las mas viejas arriba    
        for (int i = 0; i < almacen.length; i++) {
            viNu.push(almacen[i]);
        }
        //Se llena la lista con las tiendas que hicieron pedidos con el mismo orden
        for (int i = 0; i < pedidos.length; i++) {
            anRe.add(pedidos[i]);
        }
        //mientras haya pedidos en la lista.
        while(!anRe.isEmpty()){
            //Se almacena la información de la tienda
            Tiendas tienda = anRe.poll();
            String nombre = tienda.name;
            int pedido = tienda.cant;
            //mientras haya neveras y neveras pedidas por la tienda.
            while(!viNu.isEmpty() && pedido != 0){
                //Se almacena la información de la nevera
                Nevera nevera = viNu.pop();
                int code = nevera.code;
                String des = nevera.des;
                //Se imprime el codigo de la nevera y la tienda a la que corresponde
                System.out.println("La nevera con codigo "+code+" fue enviada a la tienda "+nombre);
                pedido--;
            }
        }        
    }
}
    

