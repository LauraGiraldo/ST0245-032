


public class combinations {

    
    public static void main(String[] args) {
        combinations(" ","abc");
    }
    
    public static void combinations(String base, String s){
      if(s.length()==0) {
          System.out.println(base);
      } else {
          combinations(base+s.charAt(0),s.substring(1));
          combinations(base,s.substring(1));
          //System.out.println(base);
      }
    }
}
