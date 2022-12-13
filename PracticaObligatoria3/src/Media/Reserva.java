package Media;

import java.awt.image.DataBufferUShort;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reserva {
    //Atributos
    private int id;
    private LocalDate fini;
    private LocalDate ffin;
    private Vivienda vivienda;
    private Usuario usuario;
    private static int numReservas=0;
    //Constructores
    public Reserva(LocalDate fini,LocalDate ffin,Vivienda vivienda,Usuario u){
        this.fini=fini;
        this.ffin=ffin;
        this.id=numReservas;
        this.vivienda= vivienda;
        this.usuario=u;
        numReservas++;
    }
    public void modifica(LocalDate fini,LocalDate ffin){
        this.fini=fini;
        this.ffin=ffin;
    }
    public boolean coincide(LocalDate l1, LocalDate l2){
        if ((l1.isBefore(fini) && l2.isBefore(fini)) || (l1.isAfter(ffin) && l2.isAfter(ffin)))return false;
        return true;
    }


    public int getId() {
        return id;
    }

    public Vivienda getVivienda() {
        return vivienda;
    }

    public String fechaReserva(){
        return fini.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))+"   ----------   "+ffin.format(DateTimeFormatter.ofPattern("dd-MM-yyy"));
    }
    public double getPrecioTotal(){
        int dias=(int) ChronoUnit.DAYS.between(fini,ffin);
        return dias*vivienda.getPrecioNoche();
    }
    @Override
    public String toString() {
        return String.format("""
                ╭────────────────────────────────────────────╮
                         Ticket de la reserva %s
                  Vivienda: %s
                  Fecha de la reserva:
                  %s
                  Precio total: %s
                  Huespedes: %s
                ╰────────────────────────────────────────────╯
                """,id,vivienda.getNombre(),fechaReserva(),getPrecioTotal(),vivienda.getHuespedes());
        //return "Reserva de la vivienda "+vivienda.getNombre()+",por "+usuario.getNombre()+" desde la fecha: "+fini.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))+" hasta la fecha: "+ffin.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
}
