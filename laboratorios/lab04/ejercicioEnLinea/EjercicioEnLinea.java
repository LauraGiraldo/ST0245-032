public class EjercicioEnLinea{
	
	// Sirve como raíz del árbol
	public Node root;


	/**
	* @param n el dato del nodo que se busca buscar
	* Metodo auxiliar de insetarAux.
	*
	*/
    public void insertar(int n) {
        insertarAux(root, n);
    }
    
    /**
	* @param node es la raíz del arbol
	* @param n el data del nodo que se busca insertar
	* nota: metodo recursivo.
	* Inserta un dato respetando claro las desigualdades en el árbol
	*/
    private void insertarAux(Node node, int n) {
      Node temp= new Node(n);
      
      if(node==null)
        node==temp;
      if (n > node.data)
         return InsertarAux(node.right, n); // T(n) = T(n-1) + C
      if (n < node.data)
         return InsertarAux(node.left, n);
         
    }

    
	/**
	* @param node el nodo desde el cual se imprimirá
	* imprime el arbol de forma pos orden
	*/
	private void recursivePrintAUX(Node node)
	{
		if (node != null)
		{
			recursivePrintAUX(node.left);
			recursivePrintAUX(node.right);
			System.out.println(node.data);
		}
		
	}

	/**
	* Metodo auxiliar de recursivePrintAUX
	*
	*/
	public void recursivePrint()
	{
		recursivePrintAUX(root);
	}
