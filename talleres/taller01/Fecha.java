public class Fecha {

    private final byte dia;
    private final byte mes;
    private final byte anyo;

    public Fecha(byte dia, byte mes, byte anyo) {
        this.dia = dia;
        this.mes = mes;
        this.anyo = anyo;
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

    public int comparar(Fecha otra) {
        if (anyo < otra.anio()) {
            return -1;
        }
        if (anyo == otra.anio()) {
            if (mes < otra.mes()) {
                return -1;
            }
            if (mes > otra.mes()) {
                return 1;
            }
            if (mes == otra.mes()) {
                if (dia < otra.dia()) {
                    return -1;
                }
                if (dia > otra.dia()) {
                    return 1;
                }

                if (dia == otra.dia()) {
                    return 0;
                }
            }
        }

        return 1;
    }

    @Override
    public String toString() {
        return "Fecha: " + dia + "/" + mes + "/" + anyo;
    }
}
