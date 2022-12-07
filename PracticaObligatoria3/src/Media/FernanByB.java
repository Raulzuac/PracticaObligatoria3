package Media;

import java.time.LocalDate;

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
    public boolean nuevoAdmin(String nombre, String user, String pass) {
        if (admin != null) return false;
        this.admin = new Admin(nombre, user, pass);
        return true;
    }

    public boolean nuevoUsuario(String nombre, String user, String pass) {
        if (Usuario.getNumUsuarios() == 2) return false;
        if (usuario1 == null) {
            this.usuario1 = new Usuario(nombre, user, pass);
            return true;
        }
        this.usuario2 = new Usuario(nombre, user, pass);
        return true;
    }

    public boolean nuevoPropietario(String nombre, String user, String pass) {
        if (Propietario.getNumeroPropietarios() == 2) return false;
        if (propietario1 == null) {
            this.propietario1 = new Propietario(nombre, user, pass);
            return true;
        }
        this.propietario2 = new Propietario(nombre, user, pass);
        return true;
    }

    public int tieneVivienda(String id) {
        if (propietario1.getId().equals(id)) {
            if (propietario1.getVivienda() == null) return 1;
            return -1;
        }
        if (propietario2.getId().equals(id)) {
            if (propietario2.getVivienda() == null) return 2;
            return -1;
        }
        return -1;
    }

    public boolean nuevaVivienda(String id, String nombre, String localidad, String calle, int numero) {
        switch (tieneVivienda(id)) {
            case 1: {
                this.vivienda1 = new Vivienda(nombre, localidad, calle, numero);
                propietario1.setVivienda(vivienda1);
                return true;
            }
            case 2: {
                this.vivienda2 = new Vivienda(nombre, localidad, calle, numero);
                propietario2.setVivienda(vivienda2);
                return true;
            }
        }
        return false;
    }

    public boolean nuevaVivienda(String id, String nombre, String localidad, String calle, int numero, int portal, int piso, String puerta) {
        switch (tieneVivienda(id)) {
            case 1: {
                this.vivienda1 = new Vivienda(nombre, localidad, calle, numero, portal, piso, puerta);
                propietario1.setVivienda(vivienda1);
                return true;
            }
            case 2: {
                this.vivienda2 = new Vivienda(nombre, localidad, calle, numero, portal, piso, puerta);
                propietario2.setVivienda(vivienda2);
                return true;
            }
        }
        return false;
    }

    public String login(String user, String pass) {
        if (usuario1!=null && usuario1.loginUsuario(user, pass)) return usuario1.getId();
        if (usuario2!=null && usuario2.loginUsuario(user, pass)) return usuario2.getId();
        if (propietario1!=null && propietario1.loginPropietario(user, pass)) return propietario1.getId();
        if (propietario2!=null && propietario2.loginPropietario(user, pass)) return propietario2.getId();
        if (admin!=null && admin.loginadmin(user, pass)) return admin.getId();
        return "";
    }

    public String nameById(String id) {
        if (usuario1.getId().equals(id)) return usuario1.getNombre();
        if (usuario2.getId().equals(id)) return usuario2.getNombre();
        if (propietario1.getId().equals(id)) return propietario1.getNombre();
        if (propietario2.getId().equals(id)) return propietario2.getNombre();
        if (admin.getId().equals(id)) return admin.getNombre();
        return "";
    }

    public Usuario getUsuarioById(String id) {
        if (usuario1.getId().equals(id)) return usuario1;
        if (usuario2.getId().equals(id)) return usuario2;
        return null;
    }

    public Propietario getPropietarioById(String id) {
        if (propietario1.getId().equals(id)) return propietario1;
        if (propietario2.getId().equals(id)) return propietario2;
        return null;
    }

    public int buscarVivienda(String localidad) {
        int encontradas = 0;
        if (vivienda1 != null) {
            if (vivienda1.getLocalidad().equals(localidad)) encontradas = 1;
            if (vivienda2 != null) {
                if (vivienda2.getLocalidad().equals(localidad)) {
                    if (encontradas == 1) encontradas = 3;
                    else encontradas = 2;
                }
            }
        }
        return encontradas;
    }

    public boolean reservar(Usuario u,Vivienda v, int diai, int mesi, int yeari,int diaf,int mesf,int yearf){
        if (u.puedeReservar() && v.puedeReservar()){
            LocalDate fini=LocalDate.of(yeari,mesi,diai);
            LocalDate ffin=LocalDate.of(yearf,mesf,diaf);
            Reserva r= new Reserva(fini,ffin,v);
            u.insertarReserva(r);
            v.setReserva(r);
            return true;
        }
        return false;
    }
    public Vivienda getviviendaById(int id){
        if (vivienda1.getId()==id)return vivienda1;
        if (vivienda2.getId()==id)return vivienda2;
        return null;
    }
    public boolean usuariosllenos(){
        return usuario1!=null && usuario2!=null;
    }
    public boolean propietariosLlenos(){
        return propietario1!=null && propietario2!=null;
    }
    public boolean adminLlenos(){
        return admin!=null;
    }

    public Vivienda getVivienda1() {
        return vivienda1;
    }

    public Vivienda getVivienda2() {
        return vivienda2;
    }
}
