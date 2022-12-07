import Media.FernanByB;
import java.util.Scanner;

public class Utils {
    public static void usuariosLlenos() {
        System.out.println("No se ha podido crear el usuario porque ya se ha alcanzado el máximo de usuarios." +
                "\nPulsa ENTER para continuar ");
        new Scanner(System.in).nextLine();
    }

    public static void propietariosLlenos() {
        System.out.println("No se ha podido crear el propietario porque se ha alcanzado el máximo de propietarios." +
                "\nPulsa ENTER para continuar.");
        new Scanner(System.in).nextLine();

    }

    public static void adminLlenos() {
        System.out.println("No se ha podido crear el admin porque se ha alcanzado el máximo de administradores.\n" +
                "Pulsa ENTER para continuar.");
        new Scanner(System.in).nextLine();
    }

    public static void pisosLlenos() {
        System.out.println("No se ha podido crear la vivienda porque este propietario ya tiene el máximo de viviendas disponibles.\n" +
                "Pulsa ENTER para continuar.");
        new Scanner(System.in).nextLine();
    }

    public static void noPudoReservar() {
        System.out.println("No se ha podido gestionar la reserva\n" +
                "Pulsa ENTER para continuar.");
        new Scanner(System.in).nextLine();
    }

    public static void espearaENTER() {
        new Scanner(System.in).nextLine();
    }

    public static void menuLogin() {
        System.out.println("""
                ╭────────────────────────────────────────────╮
                │                                            │
                │    Introduce a continuación tu usuario     │
                │               y contraseña                 │
                │                                            │
                ╰────────────────────────────────────────────╯
                """);
    }
    public static void menuVienvenida(){
        System.out.println("""
                ╭────────────────────────────────────────────╮
                │           Bienvenido a FernanB&B           │
                ├────────────────────────────────────────────┤
                │  Que quieres hacer                         │
                │  1.-Loguearme                              │
                │  2.-Registrarme como usuario               │
                │  3.-Registrarme como propietario           │
                │  4.-Registrarme como administrador         │
                ╰────────────────────────────────────────────╯
                """);
    }
    public static void opcionNoValida(){
        System.out.println("Opcion no valida, pulsa ENTER para volver al menú principal");
        espearaENTER();
    }
    public static String loggin(FernanByB f){
        Scanner s=new Scanner(System.in);
        Utils.menuLogin();
        System.out.print("Usuario: ");
        String user = s.nextLine();
        System.out.print("Clave: ");
        String clave = s.nextLine();
        String logueado = f.login(user, clave);
        if (logueado.equals("")) {
            Utils.falloLogin();
            Utils.espearaENTER();
        }
        return logueado;
    }
    public static void registraUsuario(FernanByB f){
        Scanner s=new Scanner(System.in);
        if (!f.usuariosllenos()){
            System.out.print("Inserta tu nombre: ");
            String nombre=s.nextLine();
            System.out.println("Inserta tu usuario: ");
            String usuario=s.nextLine();
            System.out.println("Inserta tu clave: ");
            String pass=s.nextLine();
            if (!f.nuevoUsuario(nombre,usuario,pass)) usuariosLlenos();
        }else usuariosLlenos();
    }
    public static void registrarPropietario(FernanByB f){
        Scanner s=new Scanner(System.in);
        if (!f.propietariosLlenos()){
            System.out.print("Inserta tu nombre: ");
            String nombre=s.nextLine();
            System.out.print("Inserta tu usuario: ");
            String usuario=s.nextLine();
            System.out.println("Inserta tu clave: ");
            String clave=s.nextLine();
            if (!f.nuevoPropietario(nombre,usuario,clave))propietariosLlenos();
        }else propietariosLlenos();
    }
    public static void registrarAdministrador(FernanByB f){
        Scanner s= new Scanner(System.in);
        if (!f.adminLlenos()) {
            System.out.print("Inserta la clave para poder crear un administrador: ");
            if (!s.nextLine().equals("aguacate")){
                System.out.println("La clave es incorrecta, volviendo al menú de inicio");
                espearaENTER();
            }else {
                System.out.print("Inserta tu nombre:");
                String nombre=s.nextLine();
                System.out.print("Inserta tu usuario: ");
                String usuario=s.nextLine();
                System.out.println("Inserta tu clave");
                String clave=s.nextLine();
                if (!f.nuevoAdmin(nombre,usuario,clave))adminLlenos();
            }
        }else adminLlenos();
    }
    public static void falloLogin() {
        System.out.println("""
                ╭────────────────────────────────────────────╮
                │                                            │
                │         Credenciales incorrectas,          │
                │ pulsa ENTER para volver al menu principal  │
                │                                            │
                ╰────────────────────────────────────────────╯
                """);
    }

    public static void menu(String n, FernanByB f,boolean salida) {
        char c = n.charAt(0);
        Scanner s=new Scanner(System.in);
        switch (c) {
            case '3': {
                System.out.printf("""
                        ╭────────────────────────────────────────────╮
                                                                    
                          Menu de usuario
                          Bienvenido: %s
                          
                          1.-Busqueda de alojamientos
                          2.-Ver mis reservas
                          3.-Modificar mis reservas
                          4.-Ver mi perfil
                          5.-Modificar mi perfil
                          6.-Cerrar sesión
                                                                   
                        ╰────────────────────────────────────────────╯
                        """, f.nameById(n));
                switch (s.nextLine()){
                    case "1":{
                        System.out.println("Inserta la localidad en la que quieres buscar alojamientos");
                        String localidad=s.nextLine();
                        int viviendas=f.buscarVivienda(localidad);
                        switch (viviendas){
                            case 1:{
                                System.out.println(f.getVivienda1());
                                break;
                            }
                            case 2:
                                System.out.println(f.getVivienda2());
                                break;
                            case 3:

                        }
                        break;
                    }
                }
                break;

            }
            case '2': {
                System.out.printf("""
                        ╭────────────────────────────────────────────╮
                                                                    
                          Menu de propietario
                          Bienvenido: %s
                            
                          1.-Ver mis viviendas en alquiler
                          2.-Editar mis viviendas
                          3.-Ver las reservas de mis viviendas
                          4.-Establecer un periodo de no disponible para una vivienda
                          5.-Ver mi perfil
                          6.-Cerrar sesion
                                                                   
                        ╰────────────────────────────────────────────╯
                        """, f.nameById(n));
                break;

            }
            case '1': {
                System.out.printf("""
                        ╭────────────────────────────────────────────╮
                                                                    
                          Menu de admin
                          Bienvenido: %s
                            
                          1.-Ver todas las viviendas en alquiler
                          2.-Ver todos los usuarios del sistema
                          3.-Ver todas las reservas de viviendas
                          4.-Ver mi perfil
                          5.-Modificar mi perfil
                          6.-Cerrar sesión
                                                                   
                        ╰────────────────────────────────────────────╯
                        """, f.nameById(n));
                break;

            }
        }
    }
}
