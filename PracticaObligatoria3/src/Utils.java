import Media.FernanByB;

public class Utils {
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
