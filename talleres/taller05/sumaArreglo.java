public class Taller5
{
   public static void main(String[] args){
      for (int i = 10000000; i <= 200000000; i = i + 10000000){
        int[] a = new int[i];
        for (int j = 0; j < i; j++ ){
          a[j] = j;
        }
        long start = System.currentTimeMillis();
          suma(a);
        long fin = System.currentTimeMillis();       
        System.out.println(fin-start);
      }
  }
  public static int suma(int[] a){
    int suma = 0; 
    for(int i = 0; i < a.length; i++) 
      suma += a[i];  
    return suma; 
  }
  
}
