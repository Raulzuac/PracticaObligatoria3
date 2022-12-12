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
    public static String falloLogin() {
        return ("""
                ╭────────────────────────────────────────────╮
                │                                            │
                │         Credenciales incorrectas,          │
                │ pulsa ENTER para volver al menu principal  │
                │                                            │
                ╰────────────────────────────────────────────╯
                """);
    }
    public static void espera(){
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print(".");
        }
    }

    public static String menu(String n, FernanByB f) {
        char c = n.charAt(0);
        switch (c) {
            case '3': {
                return String.format("""
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
            }
            case '2': {
                return String.format("""
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
            }
            case '1': {
                return String.format("""
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
            }
            default:return "";
        }
    }
}
