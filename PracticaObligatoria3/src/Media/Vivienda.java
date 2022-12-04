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

    public void setReserva1(LocalDate fini,LocalDate ffin,Vivienda v) {
        this.reserva1 = new Reserva(fini,ffin,v);
    }

    public Reserva getReserva2() {
        return reserva2;
    }

    public void setReserva2(LocalDate fini,LocalDate ffin,Vivienda v) {
        this.reserva2 = new Reserva(fini,ffin,v);
    }
}
