package Media;

public class Direccion {
    //Atributos
    private String localidad;
    private String calle;
    private int numero;
    private int portal;
    private int piso;
    private String puerta;
    private boolean casa;
    //Constructores
    public Direccion(String localidad,String calle,int numero,int portal,int piso,String puerta){
        this.localidad=localidad;
        this.calle=calle;
        this.numero=numero;
        this.portal=portal;
        this.piso=piso;
        this.puerta=puerta;
        this.casa=false;
    }
    public Direccion(String localidad,String calle,int numero){
        this.localidad=localidad;
        this.calle=calle;
        this.numero=numero;
        this.casa=true;
    }

    public String getLocalidad() {
        return localidad;
    }
}
