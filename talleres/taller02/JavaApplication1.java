/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;


public class JavaApplication1 {

    
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
