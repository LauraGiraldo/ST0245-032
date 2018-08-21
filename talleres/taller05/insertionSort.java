  public class Taller5
{
   public static void main(String[] args) {
        
        for (int i = 10000; i <= 200000; i = i + 10000) {
            int[] a = new int[i];
            for (int j = 0; j < i; j++) {
                a[j] = (int) (Math.random()*j);
            }
            long start = System.currentTimeMillis();
            insertionSort(a);
            long fin = System.currentTimeMillis();
            System.out.println(fin - start);
        }
    }
  public static int[] insertionSort(int[] a) {

        for (int i = 0; i < a.length; i++) {
            int min = a[i];
            for (int j = i; j < a.length; j++) {
                if (a[j] < min) {
                    min = a[j];
                    int aux = a[i];
                    a[i] = min;
                    a[j] = aux;
                }
            }
        }
        return a;
    }
}
 






