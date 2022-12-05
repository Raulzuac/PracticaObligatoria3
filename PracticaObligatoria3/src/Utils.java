import Media.FernanByB;

import java.util.Scanner;

public class Utils {
    public static void usuariosLlenos(){
        System.out.println("No se ha podido crear el usuario porque ya se ha alcanzado el máximo de usuarios." +
                "\nPulsa ENTER para continuar ");
        new Scanner(System.in).nextLine();
    }
    public static void propietariosLlenos(){
        System.out.println("No se ha podido crear el propietario porque se ha alcanzado el máximo de propietarios." +
                "\nPulsa ENTER para continuar.");
        new Scanner(System.in).nextLine();

    }
    public static void adminLlenos(){
        System.out.println("No se ha podido crear el admin porque se ha alcanzado el máximo de administradores.\n" +
                "Pulsa ENTER para continuar.");
        new Scanner(System.in).nextLine();
    }
    public static void pisosLlenos(){
        System.out.println("No se ha podido crear la vivienda porque este propietario ya tiene el máximo de viviendas disponibles.\n" +
                "Pulsa ENTER para continuar.");
        new Scanner(System.in).nextLine();
    }
    public static void noPudoReservar(){
        System.out.println("No se ha podido gestionar la reserva\n" +
                "Pulsa ENTER para continuar.");
        new Scanner(System.in).nextLine();
    }
    public static String menuLogin(){
        return """
                ╭────────────────────────────────────────────╮
                │           Bienvenido a FernanB&B           │
                │                                            │
                │    Introduce a continuación tu usuario     │
                │               y contraseña                 │
                │                                            │
                ╰────────────────────────────────────────────╯
                """;
    }
    public static String menu(String n, FernanByB f){
        char c=n.charAt(0);
        switch (c){
            case '3':{
                System.out.printf("""
                        ╭────────────────────────────────────────────╮
                                                                    
                          Menu de usuario               
                          Bienvenido: %s
                            
                                                                   
                        ╰────────────────────────────────────────────╯
                        """,f.nameById(n));

            }
            case '2':{
                return """
                        ╭────────────────────────────────────────────╮
                        │                                            │
                        │            Menu de propietario             │
                        │                                            │
                        ╰────────────────────────────────────────────╯
                        """;

            }
            case '1':{
                return """
                        ╭────────────────────────────────────────────╮
                        │                                            │
                        │           Menu de administrador            │
                        │                                            │
                        ╰────────────────────────────────────────────╯
                        """;

            }
            default:
                return """
                    ╭────────────────────────────────────────────╮
                    │                                            │
                    │         Credenciales incorrectas,          │
                    │  pulsa ENTER para volver al menu de login  │
                    │                                            │                    
                    ╰────────────────────────────────────────────╯
                    """;
        }
    }
}
