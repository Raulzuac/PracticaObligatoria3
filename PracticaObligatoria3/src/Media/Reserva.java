package Media;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reserva {
    //Atributos
    private int id;
    private LocalDate fini;
    private LocalDate ffin;
    private Vivienda vivienda;
    private static int numReservas=0;
    //Constructores
    public Reserva(LocalDate fini,LocalDate ffin,Vivienda vivienda){
        this.fini=fini;
        this.ffin=ffin;
        this.id=numReservas;
        this.vivienda= vivienda;
        numReservas++;
    }

    @Override
    public String toString() {
        return "Reserva nº"+id+" desde la fecha: "+fini.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))+" hasta la fecha: "+ffin.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
}
