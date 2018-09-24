import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import javafx.geometry.Point3D;
import java.util.ArrayList;
import java.lang.Math;
import java.util.LinkedList;

/**
 * Implementacion de un algoritmo para prevenir Colisiones Estructura de datos
 * utilizada: Arreglos Complejidad: Peor Caso O(n al cubo) y Mejor caso O(n al
 * cuadrado)
 *
 * @author Mauricio Toro
 * @version 1
 */
public class PrevencionColisiones1 {

    /**
     * Metodo para aproximar la distancia entre dos abejas roboticas
     *
     * @param abeja1 la primera abeja
     * @param abeja2 la segunda abeja
     * @return la distancia aproximada entre las dos abejas, aproximando 1 grado
     * como 111111 metros
     */
    public static double distancia(Point3D abeja1, Point3D abeja2) {
        return Math.sqrt(Math.pow((abeja1.getX() - abeja2.getX()) * 111111, 2)
                + Math.pow((abeja1.getY() - abeja2.getY()) * 111111, 2)
                + Math.pow(abeja1.getZ() - abeja2.getZ(), 2)
        );
    }

    /**
     * Metodo para leer un archivo de abejas y almacenarlas en un arreglo de
     * puntos en 3D
     *
     * @param numeroDeAbejas El numero de abejas a leer
     * @return un arreglo de puntos 3D donde cada elemento representa las
     * coordenadas de una abeja
     */
    public static Point3D[] leerArchivo(int numeroDeAbejas) throws FileNotFoundException, IOException {
        final String nombreDelArchivo = "ConjuntoDeDatosCon" + numeroDeAbejas + "abejas.txt";
        Point3D[] arregloDeAbejas = new Point3D[numeroDeAbejas];
        File archivo = new File(nombreDelArchivo);
        FileReader fr = new FileReader(archivo);
        try {
            BufferedReader br = new BufferedReader(fr);
            String lineaActual = br.readLine();
            lineaActual = br.readLine(); // Descarta la primera linea
            int index = 0;
            while (lineaActual != null) { // Mientras no llegue al fin del archivo
                String[] cadenaParticionada = lineaActual.split(",");
                Point3D abeja = new Point3D(Double.parseDouble(cadenaParticionada[0]),
                        Double.parseDouble(cadenaParticionada[1]),
                        Double.parseDouble(cadenaParticionada[2]));
                arregloDeAbejas[index++] = abeja;
                lineaActual = br.readLine();
            }
        } catch (IOException ioe) {
            System.out.println("Error leyendo el archivo de entrada");
        }
        return arregloDeAbejas;
    }

    /**
     * Algoritmo para prevenir colisiones (genera muchas respuestas repetidas)
     *
     * @param arregloDeAbejas Un arreglo con coordenadas de las abejas
     * @return una lista definida con arreglos con las abejas que tienen riesgo
     * de colision
     */
    public static LinkedList<Point3D> detectarColisiones(Point3D[] arregloDeAbejas) {

        LinkedList<Point3D> abejasConRiesgoDeColision = new LinkedList();
        for (int i = 0; i < arregloDeAbejas.length; ++i) {
            for (int j = i + 1; j < arregloDeAbejas.length; ++j) {
                if (distancia(arregloDeAbejas[i], arregloDeAbejas[j]) <= 100) {
                    abejasConRiesgoDeColision.add(arregloDeAbejas[i]);
                    abejasConRiesgoDeColision.add(arregloDeAbejas[j]);
                }
            }
        }
        return abejasConRiesgoDeColision;
    }

    /**
     * Metodo para escribir un archivo con la respuesta
     *
     * @param abejasConRiesgoDeColision Lista definida con arreglos con las
     * abejas con riesgo de colision
     * @param numeroDeAbejas Numero de abejas del conjunto de datos original
     */
    public static void guardarArchivo(LinkedList<Point3D> abejasConRiesgoDeColision, int numeroDeAbejas) {
        final String nombreDelArchivo = "respuestaConjuntoDeDatosCon" + numeroDeAbejas + "abejas.txt";
        try {
            PrintWriter escritor = new PrintWriter(nombreDelArchivo, "UTF-8");
            for (Point3D abeja : abejasConRiesgoDeColision) {
                escritor.println(abeja.getX() + "," + abeja.getY() + "," + abeja.getZ());
            }
            escritor.close();
        } catch (IOException ioe) {
            System.out.println("Error escribiendo el archivo de salida");
        }
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
  
        final int numeroDeAbejas = args.length == 0 ? 10 : Integer.parseInt(args[0]);
       
        Point3D[] arregloDeAbejas = leerArchivo(100000);
        
        /*for (int i = 0; i < 100; i++) {
            long startTime = System.currentTimeMillis();
            LinkedList<Point3D> abejasConRiesgoDeColision = detectarColisiones(arregloDeAbejas);
            // Guardar en un archivo las abejas con riesgo de colision   
            long estimatedTime = System.currentTimeMillis() - startTime;
            System.out.println(estimatedTime);
        }*/
        for (int i = 0; i < 30; i++) {
        int kb = 1024;
        Runtime memoria = Runtime.getRuntime();
        LinkedList<Point3D> abejasConRiesgoDeColision = detectarColisiones(arregloDeAbejas);
        guardarArchivo(abejasConRiesgoDeColision, numeroDeAbejas);
        long memory = (memoria.totalMemory() - memoria.freeMemory()) / kb;
        System.out.println(memory); 
        }
        
    }

}
