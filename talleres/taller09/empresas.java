import java.util.Hashtable;
import java.util.Enumeration;

public class Hash {

    static Hashtable<String, String> empresas = new Hashtable<>();

    public static void Hash() {

        empresas.put("Google", "Estados Unidos");
        empresas.put("La locura", "Colombia");
        empresas.put("Nokia", "Finlandia");
        empresas.put("Sony", "Japón");
        
        Enumeration<String> enumeration = empresas.elements();
        Enumeration<String> e = empresas.keys();
        while (enumeration.hasMoreElements()) {
            System.out.println(" La empresa " + e.nextElement() +" está en " + enumeration.nextElement());
        }
    }

    public static void main(String ...args){

        Hash();
    }
}
