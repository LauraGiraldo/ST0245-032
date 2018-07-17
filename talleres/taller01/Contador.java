public class Contador {
    
    private int cuenta;
	private final String id;

    public Contador(int cuenta, String id) {
        this.cuenta=cuenta;
        this.id=id;
    }

    public void incrementar(int cantidad) {
        cuenta=cuenta+cantidad;
    }
    
     public void decrementar(int cantidad) {
        cuenta=cuenta-cantidad;
    }

    public int incrementos() {
       return cuenta;
    }

    public String toString() {
       return "Id: "+ id + " Estado del contador: "+ Integer.toString(cuenta);
    }
}
