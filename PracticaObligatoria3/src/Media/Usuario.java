package Media;

public class Usuario {
    //Atributos
    private String id;
    private String nombre;
    private String user;
    private String pass;
    private Reserva reserva1;
    private Reserva reserva2;
    private static int numUsuarios = 0;
    //Constructores
    public Usuario(String nombre,String user, String pass){
        this.nombre=nombre;
        this.user=user;
        this.pass=pass;
        this.id="3"+numUsuarios;
        this.reserva1=null;
        this.reserva2=null;
        numUsuarios++;
    }
    //Métodos
    public boolean loginUsuario(String user,String pass){
        return this.user.equals(user) && this.pass.equals(pass);
    }
    public boolean nuevaReserva(Reserva r){
        if (reserva1!=null && reserva2!=null)return false;
        if (reserva1==null){
            reserva1=r;
            return true;
        }
        reserva2=r;
        return true;
    }

    public static int getNumUsuarios() {
        return numUsuarios;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return this.nombre;
    }
}
