/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

/**
 *
 * @author xakol
 */
public class Fibonacci {
    
    public static long Fibo(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        
        return Fibo(n-1)+Fibo(n-2);
    }
    
    
    
    
}
