package Media;

public class Propietario {
    //Atributos
    private String id;
    private String nombre;
    private String user;
    private String pass;
    private Vivienda vivienda;
    private static int numeroPropietarios=0;
    //Constructores
    public Propietario(String nombre,String user,String pass){
        this.nombre=nombre;
        this.user=user;
        this.pass=pass;
        this.vivienda=null;
        this.id="2"+numeroPropietarios;
        numeroPropietarios++;
    }

    //Métodos
    public boolean loginPropietario(String user,String pass){
        return this.user.equals(user) && this.pass.equals(pass);
    }
    public static int getNumeroPropietarios() {
        return numeroPropietarios;
    }

    public Vivienda getVivienda() {
        return vivienda;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setVivienda(Vivienda vivienda) {
        this.vivienda = vivienda;
    }

    @Override
    public String toString() {
        return String.format("""
                ╭────────────────────────────────────────────╮
                 Nombre:%s
                 Usuario:%s
                 Pass:%s 
                ╰────────────────────────────────────────────╯
                """,nombre,user,pass);
    }

    public void modificaPropietario(String nombre, String usuario, String pass) {
        this.nombre=nombre;
        this.user=usuario;
        this.pass=pass;
    }
}
