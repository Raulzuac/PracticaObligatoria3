import Media.FernanByB;
import Media.Usuario;
import jdk.jshell.execution.Util;

import java.time.LocalDate;
import java.util.Scanner;

public class PracticaObligatoria3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String passCreacionAdmin="Aguacate";
        String user = "";
        String clave = "";
        boolean salida = false;
        String logueado = "";
        //Creacion de datos de ejemplo
        FernanByB f = new FernanByB();
        if (!f.nuevoUsuario("Antonio", "antonio", "pass")) Utils.usuariosLlenos();
        if (!f.nuevoUsuario("Manolo", "manolo", "pass")) Utils.usuariosLlenos();
        if (!f.nuevoPropietario("Jose", "jose", "pass")) Utils.propietariosLlenos();
        if (!f.nuevoPropietario("Jesus", "jesus", "pass")) Utils.propietariosLlenos();
        if (!f.nuevoAdmin("Admin", "admin", "pass")) Utils.adminLlenos();
        if (!f.nuevaVivienda("20", "Pisito en la playa", "Torremolinos",
                "nose", 10, 1, 2, "b"))
            Utils.pisosLlenos();
        if (!f.nuevaVivienda("21", "Casa en la montaña", "Torreperojil",
                "La unica que hay", 1))
            Utils.pisosLlenos();
        LocalDate l = LocalDate.now();
        if (!f.reservar(f.getUsuarioById("30"), f.getviviendaById(0), 10, 10, 2022, 12, 10, 2022))
            Utils.noPudoReservar();

        //Bucle en el que funciona el programa
        while (!salida) {
            if (logueado.equals("")) {
                Utils.menuVienvenida();
                String opt = s.nextLine();
                switch (opt) {
                    case "1":
                        System.out.print("Introduce el usuario: ");
                        user = s.nextLine();
                        System.out.print("Introduce tu clave: ");
                        clave = s.nextLine();
                        logueado = f.login(user, clave);
                        break;
                    case "2":
                        if (f.usuariosllenos()) {
                            System.out.println("No se pueden hacer registros de usuarios porque " +
                                    "hemos alcanzado el máximo de usuarios posibles.\nPulsa ENTER para volver al inicio.");
                            Utils.espearaENTER();
                        }else {
                            System.out.println("Bienvenido al menú de registro de usuario.");
                            System.out.println("Introduce tu nombre");
                            String nombre=s.nextLine();
                            System.out.println("Introduce tu nombre de usuario (lo utilizarás para loguearte)");
                            String usuario=s.nextLine();
                            System.out.println("Introduce tu clave");
                            String pass=s.nextLine();
                            f.nuevoUsuario(nombre,usuario,pass);
                        }

                        break;
                    case "3":
                        if (f.propietariosLlenos()){
                            System.out.println("NO se puede crear el propietario porque hemos alcanzado el máximo de" +
                                    "propietarios posibles.\nPulsa ENTER para continuar.");
                            Utils.espearaENTER();
                        }else {
                            System.out.println("Bienvenido al menú de registro de propietario.");
                            System.out.println("Introduce tu nombre");
                            String nombre=s.nextLine();
                            System.out.println("Introduce tu nombre de usuario (lo utilizarás para loguearte)");
                            String usuario=s.nextLine();
                            System.out.println("Introduce tu clave");
                            String pass=s.nextLine();
                            f.nuevoPropietario(nombre,usuario,pass);
                        }
                        break;
                    case "4":
                        if (f.adminLlenos()){
                            System.out.println("No se puede crear el administrador porque hemos alcanzado el número" +
                                    " máximo de administradores.\nPulsa ENTER para continuar");
                            Utils.espearaENTER();
                        }else {
                            System.out.println("Introduce la contraseña para poder crear un administrador");
                            if (!s.nextLine().equals(passCreacionAdmin)) System.out.println("Credencial incorrecta,volviendo al menú");
                            else {
                                System.out.println("Bienvenido al menú de creacion de administrador");
                                System.out.println("Introduce tu nombre");
                                String nombre=s.nextLine();
                                System.out.println("Introduce tu usuario (lo utilizaras para loguearte)");
                                String usuario=s.nextLine();
                                System.out.println("Introduce tu clave");
                                String pass=s.nextLine();
                                f.nuevoAdmin(nombre,usuario,pass);
                            }
                        }
                        break;
                    default:{
                        System.out.println("Opción no válida, pulsa ENTER para volver.");
                        Utils.espearaENTER();
                    }

                }
            } else {
                System.out.println(Utils.menu(logueado,f));
                String opt="";
                opt=s.nextLine();
                switch (logueado.charAt(0)){
                    case '1':{//Switch del menú de administrador
                        switch (opt){
                            case "1":{
                                System.out.println(f.getVivienda1());
                                System.out.println(f.getVivienda2());
                                System.out.println("Pulsa ENTER para continuar");
                                Utils.espearaENTER();
                                break;
                            }
                            case "2":{
                                System.out.println(f.getUsuario1());
                                System.out.println(f.getUsuario2());
                                System.out.println("Pulsa ENTER para continuar");
                                Utils.espearaENTER();
                                break;
                            }
                            case "3":{
                                if (f.getVivienda1().getReserva1()!=null) System.out.println(f.getVivienda1().getReserva1());
                                if (f.getVivienda1().getReserva2()!=null) System.out.println(f.getVivienda1().getReserva2());
                                if (f.getVivienda2().getReserva1()!=null) System.out.println(f.getVivienda2().getReserva1());
                                if (f.getVivienda2().getReserva2()!=null) System.out.println(f.getVivienda2().getReserva2());
                                System.out.println("Pulsa ENTER para continuar");
                                Utils.espearaENTER();
                                break;
                            }
                            case "4":{
                                System.out.println(f.getAdminById(logueado));
                                System.out.println("Pulsa ENTER para continuar");
                                Utils.espearaENTER();
                                break;
                            }
                            case "5":{
                                System.out.println("A continuación vas a modificar tu perfil, si deseas cancelar la" +
                                        " operación deja la clave en blanco y no se modificará nada de tu usuario.");
                                System.out.println("Introduce tu nuevo nombre");
                                String nombre=s.nextLine();
                                System.out.println("Introduce tu nuevo usuario");
                                String usuario=s.nextLine();
                                System.out.println("Introduce tu nueva clave (dejala en blanco para cancelar)");
                                String pass=s.nextLine();
                                if (pass!="")f.getAdminById(logueado).modificaAdmin(nombre,usuario,pass);
                                System.out.println("Admin modificado, pulsa ENTER para continuar");
                                Utils.espearaENTER();
                                break;
                            }
                            case "6":{
                                logueado="";
                                break;
                            }

                        }
                        break;
                    }
                    case '2':{
                        switch (opt){
                            case "1":{
                                System.out.println(f.getPropietarioById(logueado).getVivienda());
                                System.out.println("Pulsa ENTER para continuar");
                                Utils.espearaENTER();
                                break;
                            }
                            case "2":{
                                System.out.println("Inserta el nombre de la vivienda que quieres edtar");
                                String nombreVivienda=s.nextLine();
                                if (!nombreVivienda.equals(f.getPropietarioById(logueado).getVivienda().getNombre())){
                                    System.out.println("No has insertado el nombre de ninguna de tus viviendas,pulsa ENTER para continuar");
                                    Utils.espearaENTER();
                                }
                                else {
                                    System.out.println("Inserta el nuevo nombre de la vivienda (dejalo en blanco para cancelar la operación)");
                                    String nuevoNOmbre=s.nextLine();
                                    if (nuevoNOmbre!=""){
                                        f.getPropietarioById(logueado).getVivienda().modificaVivienda(nuevoNOmbre);
                                        System.out.println("La vivienda se ha modificado correctamente, pulsa ENTER para continuar");
                                    }else System.out.println("La vivienda no se ha modificado, pulsa ENTER para continuar");
                                    Utils.espearaENTER();
                                }
                                break;
                            }
                            case "3":{
                                System.out.println(f.getPropietarioById(logueado).getVivienda().getReserva1());
                                System.out.println(f.getPropietarioById(logueado).getVivienda().getReserva2());
                                System.out.println("Pulsa ENTER para continuar.");
                                Utils.espearaENTER();
                                break;
                            }
                            case "4":{
                                if (!f.getPropietarioById(logueado).getVivienda().reservable())
                                    System.out.println("Lo sentimos no puede establecer un periodo no disponible" +
                                            "todos los tramos estan ya ocupados");
                                else {
                                    System.out.println("Inserta la fecha en la que no estara disponible:");
                                    System.out.print("Dia: ");
                                    int dia=Integer.parseInt(s.nextLine());
                                    System.out.print("Mes: ");
                                    int mes=Integer.parseInt(s.nextLine());
                                    System.out.println("Año: ");
                                    int year=Integer.parseInt(s.nextLine());
                                    System.out.println("Ahora inserta la fecha en la que volverá a estar disponible la vivienda");
                                    System.out.print("Dia: ");
                                    int diaf=Integer.parseInt(s.nextLine());
                                    System.out.print("Mes: ");
                                    int mesf=Integer.parseInt(s.nextLine());
                                    System.out.print("Año: ");
                                    int yearf=Integer.parseInt(s.nextLine());
                                    if (!f.reservar(new Usuario(f.getPropietarioById(logueado).getNombre()),f.getPropietarioById(logueado).getVivienda(),dia,mes,year,diaf
                                    ,mesf,yearf)) System.out.println("No se ha podido hacer no disponible la vivienda porque ya tenia una reserva entre las fechas que has especificado");
                                    else System.out.println("Ya se ha marcado como no disponible.");
                                    System.out.println("Pulsa ENTER para continuar");
                                    Utils.espearaENTER();

                                }
                                break;
                            }
                            case "5":{
                                System.out.println(f.getPropietarioById(logueado));
                                System.out.println("Pulsa ENTER para continuar");
                                Utils.espearaENTER();
                                break;
                            }
                            case "6":{//modificar propietario todo
                                break;
                            }
                        }
                        break;
                    }
                }
            }
        }


    }
}
