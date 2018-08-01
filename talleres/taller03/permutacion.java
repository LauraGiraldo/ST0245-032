public class Permutation {
    
 public static void main(String args[]) {

      per("","ab");
    
 }


 public static void per(String base, String s){
 
     if (s.length() == 0) {
 
       System.out.println(base);
        
     }

 
     for (int i = 0; i < s.length(); i++)
{

       per(base + s.charAt(i), s.substring(0,i)+s.substring(i+1));
  
     }
    
 }

}