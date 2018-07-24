class Punto1
{
	
 public static void main (String[] args){

  System.out.println(MCD(345,150));

 }

 public static int MCD(int a, int b){

  if (b == 0) return a;
	
  else return MCD(b,a%b);
	
 }

}