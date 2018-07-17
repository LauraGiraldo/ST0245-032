public class Fecha {
    
    private final short dia;
    private final short mes;
    private final short anyo;

    public Fecha(short dia, short mes, short anyo) {
        this.dia= dia;
        this.mes= mes;
        this.anyo= anyo;
    }

    public int dia() {
        return dia;

    }

    public int mes() {
        return mes;
    }

    public int anio() {
        return anyo;
    }

    // -1 si esta fecha es anterior a la otra
    // 0 si son iguales
    // 1 si esta fecha es posterior a la otra
    public int comparar(Fecha otra) {
      if(otra.anio()==anyo && otra.mes()==mes && otra.dia()==dia){
          return 0;
      }else{  
        if(otra.anio()>anyo && otra.mes()>mes && otra.dia()>dia){
            return -1;
        }else{
            return 1;
        }
      }
    }

    public String toString() {
        return "Fecha: dia "+dia+" mes "+mes+" año "+anyo;
    }
}
