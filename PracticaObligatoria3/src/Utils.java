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
    public static String menu(int n){
        switch (n){
            case 1:{
                return """
                        ╭────────────────────────────────────────────╮
                        │                                            │
                        │              Menu de usuario               │
                        │                                            │
                        ╰────────────────────────────────────────────╯
                        """;

            }
            case 2:{
                return """
                        ╭────────────────────────────────────────────╮
                        │                                            │
                        │            Menu de propietario             │
                        │                                            │
                        ╰────────────────────────────────────────────╯
                        """;

            }
            case 3:{
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
