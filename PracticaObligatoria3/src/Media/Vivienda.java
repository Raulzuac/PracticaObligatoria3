package Media;

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
}
