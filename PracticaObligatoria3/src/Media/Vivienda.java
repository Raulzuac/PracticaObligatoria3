package Media;

import java.time.LocalDate;

public class Vivienda {
    //Atributos
    private String nombre;
    private int id;
    private Direccion direccion;
    private Reserva reserva1;
    private Reserva reserva2;
    private double precioNoche;
    private static int numViviendas=0;
    //Constructores
    public Vivienda(String nombre,String localidad,String calle,int numero,int precioNoche){
        this.precioNoche=precioNoche;
        this.nombre=nombre;
        this.direccion=new Direccion(localidad,calle,numero);
        this.id=numViviendas;
        numViviendas++;
    }
    public Vivienda(String nombre,String localidad,String calle,int numero,int portal,int piso,String puerta,int precioNoche){
        this.precioNoche=precioNoche;
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
    public boolean reservable(){return reserva1==null||reserva2==null;}

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

    public double getPrecioNoche() {
        return precioNoche;
    }

    public void setNombre(String nombre){
         this.nombre=nombre;
    }
    public String reservada(){
        if (reserva1==null && reserva2==null)return "";
        if (reserva1!=null)return reserva1.fechaReserva();
        return reserva2.fechaReserva();
    }
    public void reserva1ToNull(){
        reserva1=null;
    }
    public void reserva2ToNull(){
        reserva2=null;
    }
    @Override
    public String toString() {
        return """
                ╭────────────────────────────────────────────╮
                 Nombre de la vivienda:%s
                %s
                 Precio por noche: %s
                ╰────────────────────────────────────────────╯
                """.formatted(nombre,direccion,precioNoche);
    }
}
