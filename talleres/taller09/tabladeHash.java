
public class UnaTablaDeHash
{
   /*
   * Utilizamos array por simplicidad sin embargo el uso de este no permite manejar coliciones
   * de manera eficiente, por lo cual esta primera versión de hash no implementa colisiones, esta
   * característica se implementará posteriormente.
   */
  int size=0;
   int[] tabla;
   /**
   * Este método define el array utilizado posiciones que nos ingresa el usuario
   * 
   */
   public UnaTablaDeHash(int size){
       tabla = new int[size];
   }

   /**
   * @param k es la llave del elemento que servirá como referencia al buscar
   * Este método se utiliza para darle una posicion dentro de la tabla, donde el %size asegura que solo
   * se utilicen digitos de 0 a size.
   */
   private int funcionHash(String k){
       //return ((int) k.charAt(0)) % size;
       int suma = 0;
       for(int i = 0; i < k.length(); i++)
         suma += ((int) k.charAt(i)) * i * (int) Math.pow(2,31-i);
       return suma % size;
   }

   /**
   * @param k es la llave del elemento que servirá como referencia al buscar
   * Este método se utiliza para obtener el elmento con la clave k, se enlaza con funcionHash
   */
   public int get(String k){
       int laFuncionHashDeK =  funcionHash(k);
   
       return tabla[laFuncionHashDeK];
   }

   /**
   * @param k es la llave del elemento que servirá como referencia al buscar posteriormente
   * @param v es el valor asociado a la llave k
   * Este método se utiliza para agregar un nuevo elemento
   */
   public void put(String k, int v){
         int laFuncionHashDeK =  funcionHash(k);
     
         tabla[laFuncionHashDeK] = v;
   }
}
