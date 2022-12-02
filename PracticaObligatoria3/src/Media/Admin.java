package Media;

public class Admin {
    //Atributos
    private String id;
    private String nombre;
    private String user;
    private String pass;
    private static int numAdmin=0;

    //Constructores
    public Admin(String nombre,String user,String pass){
        this.nombre=nombre;
        this.user=user;
        this.pass=pass;
        this.id="1"+numAdmin;
        numAdmin++;
    }
    public boolean loginadmin(String user,String pass){
        return this.user.equals(user) && this.pass.equals(pass);
    }
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

}
