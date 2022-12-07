package Media;

import java.time.LocalDate;

public class Vivienda {
    //Atributos
    private String nombre;
    private int id;
    private Direccion direccion;
    private Reserva reserva1;
    private Reserva reserva2;
    private static int numViviendas=0;
    //Constructores
    public Vivienda(String nombre,String localidad,String calle,int numero){
        this.nombre=nombre;
        this.direccion=new Direccion(localidad,calle,numero);
        this.id=numViviendas;
        numViviendas++;
    }
    public Vivienda(String nombre,String localidad,String calle,int numero,int portal,int piso,String puerta){
        this.nombre=nombre;
        this.direccion=new Direccion(localidad,calle,numero,portal,piso,puerta);
        this.id=numViviendas;
        numViviendas++;
    }

    public String getNombre() {
        return nombre;
    }
    public String getLocalidad(){
        return this.direccion.getLocalidad();
    }

    public Reserva getReserva1() {
        return reserva1;
    }

    public boolean setReserva(Reserva r){
        if (this.reserva1==null){
            this.reserva1=r;
            return true;
        }
        if (this.reserva2==null){
            this.reserva2=r;
            return true;
        }
        return false;
    }
    public boolean puedeReservar(){
        if (reserva1==null || reserva2==null)return true;
        return false;
    }

    public Reserva getReserva2() {
        return reserva2;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return """
                ╭────────────────────────────────────────────╮
                 Nombre de la vivienda:%s
                 %s
                """.formatted(nombre,direccion);
    }
}
