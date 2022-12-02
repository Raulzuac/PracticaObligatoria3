package Media;

public class FernanByB {
    //Atributos
    private Usuario usuario1;
    private Usuario usuario2;
    private Propietario propietario1;
    private Propietario propietario2;
    private Vivienda vivienda1;
    private Vivienda vivienda2;
    private Admin admin;
    //Constructor
    public FernanByB() {

    }
    //Métodos
    public boolean nuevoAdmin(String nombre,String user,String pass){
        if (admin!=null)return false;
        this.admin=new Admin(nombre,user,pass);
        return true;
    }
    public boolean nuevoUsuario(String nombre,String user, String pass){
        if (Usuario.getNumUsuarios()==2)return false;
        if (usuario1==null){
            this.usuario1=new Usuario(nombre,user,pass);
            return true;
        }
        this.usuario2 =new Usuario(nombre,user,pass);
        return true;
    }
    public boolean nuevoPropietario(String nombre,String user,String pass){
        if (Propietario.getNumeroPropietarios()==2)return false;
        if (propietario1==null){
            this.propietario1=new Propietario(nombre,user,pass);
            return true;
        }
        this.propietario2=new Propietario(nombre,user,pass);
        return true;
    }
    public int tieneVivienda(String id){
        if (propietario1.getId().equals(id)){
            if (propietario1.getVivienda()==null)return 1;
            return -1;
        }
        if (propietario2.getId().equals(id)){
            if (propietario2.getVivienda()==null)return 2;
            return -1;
        }
        return -1;
    }

    public boolean nuevaVivienda(String id,String nombre,String localidad,String calle,int numero){
        switch (tieneVivienda(id)){
            case 1:{
                this.vivienda1=new Vivienda(nombre,localidad,calle,numero);
                propietario1.setVivienda(vivienda1);
                return true;
            }
            case 2:{
                this.vivienda2=new Vivienda(nombre,localidad,calle,numero);
                propietario2.setVivienda(vivienda2);
                return true;
            }
        }
        return false;
    }
    public boolean nuevaVivienda(String id,String nombre,String localidad,String calle,int numero,int portal,int piso,String puerta){
        switch (tieneVivienda(id)){
            case 1:{
                this.vivienda1=new Vivienda(nombre,localidad,calle,numero,portal,piso,puerta);
                propietario1.setVivienda(vivienda1);
                return true;
            }
            case 2:{
                this.vivienda2=new Vivienda(nombre,localidad,calle,numero,portal,piso,puerta);
                propietario2.setVivienda(vivienda2);
                return true;
            }
        }
        return false;
    }
    public String login(String user,String pass){
        if (usuario1.loginUsuario(user,pass))return usuario1.getId();
        if (usuario2.loginUsuario(user,pass))return usuario2.getId();
        if (propietario1.loginPropietario(user,pass))return propietario1.getId();
        if (propietario2.loginPropietario(user,pass))return propietario2.getId();
        if (admin.loginadmin(user,pass))return admin.getId();
        return "";
    }
    public String nameById(String id){
        if (usuario1.getId().equals(id))return usuario1.getNombre();
        if (usuario2.getId().equals(id))return usuario2.getNombre();
        if (propietario1.getId().equals(id))return propietario1.getNombre();
        if (propietario2.getId().equals(id))return propietario2.getNombre();
        if (admin.getId().equals(id))return admin.getNombre();
        return "";
    }
}
