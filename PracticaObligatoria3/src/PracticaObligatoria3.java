import Media.FernanByB;
import Media.Reserva;
import Media.Usuario;
import Media.Vivienda;
import jdk.jshell.execution.DirectExecutionControl;
import jdk.jshell.execution.Util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PracticaObligatoria3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String passCreacionAdmin = "Aguacate";
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
        if (!f.nuevaVivienda("20", "Pisito en la playa", "Torremolinos", "nose", 10, 1, 2, "b", 30,5))
            Utils.pisosLlenos();
        if (!f.nuevaVivienda("21", "Casa en la montaña", "Torremolinos",
                "La unica que hay", 1, 40,4))
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
                        } else {
                            System.out.println("Bienvenido al menú de registro de usuario.");
                            System.out.println("Introduce tu nombre");
                            String nombre = s.nextLine();
                            System.out.println("Introduce tu nombre de usuario (lo utilizarás para loguearte)");
                            String usuario = s.nextLine();
                            System.out.println("Introduce tu clave");
                            String pass = s.nextLine();
                            f.nuevoUsuario(nombre, usuario, pass);
                        }

                        break;
                    case "3":
                        if (f.propietariosLlenos()) {
                            System.out.println("NO se puede crear el propietario porque hemos alcanzado el máximo de" +
                                    "propietarios posibles.\nPulsa ENTER para continuar.");
                            Utils.espearaENTER();
                        } else {
                            System.out.println("Bienvenido al menú de registro de propietario.");
                            System.out.println("Introduce tu nombre");
                            String nombre = s.nextLine();
                            System.out.println("Introduce tu nombre de usuario (lo utilizarás para loguearte)");
                            String usuario = s.nextLine();
                            System.out.println("Introduce tu clave");
                            String pass = s.nextLine();
                            f.nuevoPropietario(nombre, usuario, pass);
                        }
                        break;
                    case "4":
                        if (f.adminLlenos()) {
                            System.out.println("No se puede crear el administrador porque hemos alcanzado el número" +
                                    " máximo de administradores.\nPulsa ENTER para continuar");
                            Utils.espearaENTER();
                        } else {
                            System.out.println("Introduce la contraseña para poder crear un administrador");
                            if (!s.nextLine().equals(passCreacionAdmin))
                                System.out.println("Credencial incorrecta,volviendo al menú");
                            else {
                                System.out.println("Bienvenido al menú de creacion de administrador");
                                System.out.println("Introduce tu nombre");
                                String nombre = s.nextLine();
                                System.out.println("Introduce tu usuario (lo utilizaras para loguearte)");
                                String usuario = s.nextLine();
                                System.out.println("Introduce tu clave");
                                String pass = s.nextLine();
                                f.nuevoAdmin(nombre, usuario, pass);
                            }
                        }
                        break;
                    default: {
                        System.out.println("Opción no válida, pulsa ENTER para volver.");
                        Utils.espearaENTER();
                    }

                }
            } else {
                System.out.println(Utils.menu(logueado, f));
                String opt = "";
                opt = s.nextLine();
                switch (logueado.charAt(0)) {
                    case '1': {//Switch del menú de administrador
                        switch (opt) {
                            case "1": {
                                if (f.getVivienda1() == null && f.getVivienda2() == null)
                                    System.out.println("No existe ninguna vivienda en el sistema");
                                else {
                                    if (f.getVivienda1() != null) System.out.println(f.getVivienda1());
                                    if (f.getVivienda2() != null) System.out.println(f.getVivienda2());
                                }
                                System.out.println("Pulsa ENTER para continuar");
                                Utils.espearaENTER();
                                break;
                            }
                            case "2": {
                                boolean flag=false,flag2=false;
                                if (f.getUsuario1() == null && f.getUsuario2() == null)
                                    flag=true;
                                else {
                                    if (f.getUsuario1() != null) System.out.println(f.getUsuario1());
                                    if (f.getUsuario2() != null) System.out.println(f.getUsuario2());
                                }
                                if (f.getPropietario1()==null && f.getPropietario2()==null)flag=true;
                                else {
                                    if (f.getPropietario1()!=null) System.out.println(f.getPropietario1());
                                    if (f.getPropietario2()!=null) System.out.println(f.getPropietario2());
                                }
                                if (flag && flag2) System.out.println("No hay ningún usuario en el sistema");
                                System.out.println("Pulsa ENTER para continuar");
                                Utils.espearaENTER();
                                break;
                            }
                            case "3": {
                                boolean flag = true;
                                if (f.getVivienda1() != null && f.getVivienda2() != null) {
                                    if (f.getVivienda1() != null) {
                                        if (f.getVivienda1().getReserva1() != null) {
                                            System.out.println(f.getVivienda1().getReserva1());
                                            flag = false;
                                        }
                                        if (f.getVivienda1().getReserva2() != null) {
                                            System.out.println(f.getVivienda1().getReserva2());
                                            flag = false;
                                        }
                                    }
                                    if (f.getVivienda2() != null) {
                                        if (f.getVivienda2().getReserva1() != null) {
                                            System.out.println(f.getVivienda2().getReserva1());
                                            flag = false;
                                        }
                                        if (f.getVivienda2().getReserva2() != null) {
                                            System.out.println(f.getVivienda2().getReserva2());
                                            flag = false;
                                        }
                                    }
                                }
                                if (flag) System.out.println("No hay ninguna reserva en el sistema");
                                System.out.println("Pulsa ENTER para continuar");
                                Utils.espearaENTER();
                                break;
                            }
                            case "4": {
                                System.out.println(f.getAdminById(logueado));
                                System.out.println("Pulsa ENTER para continuar");
                                Utils.espearaENTER();
                                break;
                            }
                            case "5": {
                                System.out.println("A continuación vas a modificar tu perfil, si deseas cancelar la" +
                                        " operación deja la clave en blanco y no se modificará nada de tu usuario.");
                                System.out.println("Introduce tu nuevo nombre");
                                String nombre = s.nextLine();
                                System.out.println("Introduce tu nuevo usuario");
                                String usuario = s.nextLine();
                                System.out.println("Introduce tu nueva clave (dejala en blanco para cancelar)");
                                String pass = s.nextLine();
                                if (pass != "") f.getAdminById(logueado).modificaAdmin(nombre, usuario, pass);
                                logueado = "";
                                System.out.println("Admin modificado, pulsa ENTER para continuar");
                                Utils.espearaENTER();
                                break;
                            }
                            case "6": {
                                logueado = "";
                                break;
                            }
                            default: {
                                System.out.println("No has introducido un valor válido, pulsa ENTER para continuar");
                                Utils.espearaENTER();
                            }

                        }
                        break;
                    }
                    case '2': {//Menu del propietario
                        switch (opt) {
                            case "1": {
                                if (f.getPropietarioById(logueado).getVivienda() != null) {
                                    System.out.println(f.getPropietarioById(logueado).getVivienda());
                                    System.out.println("Pulsa ENTER para continuar");
                                    Utils.espearaENTER();
                                } else {
                                    System.out.println("No tienes ninguna vivienda en alquiler, pulsa ENTER para continuar");
                                    Utils.espearaENTER();
                                }
                                break;
                            }
                            case "2": {
                                if (f.getPropietarioById(logueado).getVivienda() != null) {
                                    System.out.println(f.getPropietarioById(logueado).getVivienda());
                                    System.out.println("Inserta el nombre de la vivienda que quieres edtar");
                                    String nombreVivienda = s.nextLine();
                                    if (!nombreVivienda.equals(f.getPropietarioById(logueado).getVivienda().getNombre())) {
                                        System.out.println("No has insertado el nombre de ninguna de tus viviendas,pulsa ENTER para continuar");
                                        Utils.espearaENTER();
                                    } else {
                                        System.out.println("Inserta el nuevo nombre de la vivienda (dejalo en blanco para cancelar la operación)");
                                        String nuevoNOmbre = s.nextLine();
                                        if (nuevoNOmbre != "") {
                                            f.getPropietarioById(logueado).getVivienda().setNombre(nuevoNOmbre);
                                            System.out.println("La vivienda se ha modificado correctamente, pulsa ENTER para continuar");
                                        } else
                                            System.out.println("La vivienda no se ha modificado, pulsa ENTER para continuar");
                                        Utils.espearaENTER();
                                    }

                                } else {
                                    System.out.println("¿La vivienda que quieres crear es un piso o una casa? c(casa)/p(piso))");
                                    if (s.nextLine().equalsIgnoreCase("c")) {
                                        System.out.print("Introduce el nombre de la casa: ");
                                        String nombre = s.nextLine();
                                        System.out.print("Introduce la localidad de la casa: ");
                                        String localidad = s.nextLine();
                                        System.out.print("Introduce la calle de la casa: ");
                                        String calle = s.nextLine();
                                        System.out.print("Introduce el número de la casa: ");
                                        int numero = Integer.parseInt(s.nextLine());
                                        System.out.print("Introduce el precio por noche: ");
                                        int precioNoche = Integer.parseInt(s.nextLine());
                                        System.out.println("Introduce el número máximo de huespedes");
                                        int huespedes=Integer.parseInt(s.nextLine());
                                        f.getPropietarioById(logueado).setVivienda(new Vivienda(nombre, localidad, calle, numero, precioNoche,huespedes));
                                        System.out.println("La vivienda ha sido creada, pulsa ENTER para continuar");
                                        Utils.espearaENTER();
                                    } else {
                                        System.out.print("Introduce el nombre del piso: ");
                                        String nombre = s.nextLine();
                                        System.out.print("Introduce la localidad del piso: ");
                                        String localidad = s.nextLine();
                                        System.out.print("Introduce la calle del piso: ");
                                        String calle = s.nextLine();
                                        System.out.print("Introduce el número del piso: ");
                                        int num = Integer.parseInt(s.nextLine());
                                        System.out.print("Introduce el portal del piso: ");
                                        int portal = Integer.parseInt(s.nextLine());
                                        System.out.print("Introduce el piso en el que esta el piso: ");
                                        int piso = Integer.parseInt(s.nextLine());
                                        System.out.print("Introduce la puerta: ");
                                        String puerta = s.nextLine();
                                        System.out.print("Introduce el precio por noche: ");
                                        int precio = Integer.parseInt(s.nextLine());
                                        System.out.println("Introduce el número máximo de huespedes");
                                        int huespedes=Integer.parseInt(s.nextLine());
                                        f.getPropietarioById(logueado).setVivienda(new Vivienda(nombre, localidad, calle, num
                                                , portal, piso, puerta, precio,huespedes));
                                        System.out.println("La vivienda ha sido creada, pulsa ENTER para continuar");
                                        Utils.espearaENTER();
                                    }
                                }
                                break;
                            }
                            case "3": {
                                if (f.getPropietarioById(logueado).getVivienda().getReserva1() != null) {
                                    System.out.println(f.getPropietarioById(logueado).getVivienda().getReserva1());
                                }
                                if (f.getPropietarioById(logueado).getVivienda().getReserva2() != null) {
                                    System.out.println(f.getPropietarioById(logueado).getVivienda().getReserva2());
                                }
                                if (f.getPropietarioById(logueado).getVivienda().getReserva2() == null &&
                                        f.getPropietarioById(logueado).getVivienda().getReserva1() == null)
                                    System.out.println("Ninguna de tus viviendas tiene reservas");
                                System.out.println("Pulsa ENTER para continuar.");
                                Utils.espearaENTER();
                                break;
                            }
                            case "4": {
                                if (!f.getPropietarioById(logueado).getVivienda().reservable())
                                    System.out.println("Lo sentimos no puede establecer un periodo no disponible" +
                                            "todos los tramos estan ya ocupados");
                                else {
                                    System.out.println("Inserta la fecha en la que no estara disponible:");
                                    System.out.print("Dia: ");
                                    int dia = Integer.parseInt(s.nextLine());
                                    System.out.print("Mes: ");
                                    int mes = Integer.parseInt(s.nextLine());
                                    System.out.println("Año: ");
                                    int year = Integer.parseInt(s.nextLine());
                                    System.out.println("Ahora inserta la fecha en la que volverá a estar disponible la vivienda");
                                    System.out.print("Dia: ");
                                    int diaf = Integer.parseInt(s.nextLine());
                                    System.out.print("Mes: ");
                                    int mesf = Integer.parseInt(s.nextLine());
                                    System.out.print("Año: ");
                                    int yearf = Integer.parseInt(s.nextLine());
                                    if (!f.reservar(new Usuario(f.getPropietarioById(logueado).getNombre()), f.getPropietarioById(logueado).getVivienda(), dia, mes, year, diaf
                                            , mesf, yearf))
                                        System.out.println("No se ha podido hacer no disponible la vivienda porque ya tenia una reserva entre las fechas que has especificado");
                                    else System.out.println("Ya se ha marcado como no disponible.");
                                    System.out.println("Pulsa ENTER para continuar");
                                    Utils.espearaENTER();

                                }
                                break;
                            }
                            case "5": {
                                System.out.println(f.getPropietarioById(logueado));
                                System.out.println("Pulsa ENTER para continuar");
                                Utils.espearaENTER();
                                break;
                            }
                            case "6": {
                                System.out.println("A continuación vas a modificar tu perfil, si deseas cancelar la" +
                                        " operación deja la clave en blanco y no se modificará nada de tu usuario.");
                                System.out.println("Introduce tu nuevo nombre");
                                String nombre = s.nextLine();
                                System.out.println("Introduce tu nuevo usuario");
                                String usuario = s.nextLine();
                                System.out.println("Introduce tu nueva clave (dejala en blanco para cancelar)");
                                String pass = s.nextLine();
                                if (pass != "")
                                    f.getPropietarioById(logueado).modificaPropietario(nombre, usuario, pass);
                                System.out.println("Propietario modificado, pulsa ENTER para continuar");
                                logueado = "";
                                Utils.espearaENTER();
                                break;
                            }
                            case "7": {
                                logueado = "";
                                break;
                            }
                            default: {
                                System.out.println("No has introducido un valor válido, pulsa ENTER para continuar");
                                Utils.espearaENTER();
                            }
                        }
                        break;
                    }
                    case '3': {//Menu del usuario
                        switch (opt) {
                            case "1": {
                                System.out.println("Bienvenido al menú de búsqueda de usuarios, introduzca la localidad en la que quiere buscar: ");
                                String localidad = s.nextLine();
                                System.out.print("Buscando las viviendas disponibles");
                                Utils.espera();
                                int encontradas = f.buscarVivienda(localidad);
                                System.out.println(encontradas);
                                switch (encontradas) {
                                    case 1: {
                                        System.out.println("Se han encontrado 1 viviendas en esta localidad,inserte el número correspondiente para reservarla, cualquier otro para cancelar");
                                        System.out.println("----------1---------\n" + f.getVivienda1());
                                        if (!s.nextLine().equals("1")) {
                                            System.out.println("La operación ha sido cancelada, pulsa ENTER para continuar");
                                            Utils.espearaENTER();
                                        } else {
                                            if (!f.getVivienda1().reservable()) {
                                                System.out.println("Lo sentimos, en estos momentos esa vivienda no es reservable, pulsa ENTER para continuar");
                                                Utils.espearaENTER();
                                            } else {
                                                System.out.println("La vivienda está reservada en el siguiente tramo:\n" + f.getVivienda1().reservada());
                                                System.out.print("Desea reservarla (s/n):");
                                                if (s.nextLine().equalsIgnoreCase("n")) {
                                                    System.out.println("Cancelando la operación, pulsa ENTER para continuar");
                                                    Utils.espearaENTER();
                                                } else {
                                                    LocalDate finicio = null;
                                                    LocalDate ffin = null;
                                                    Vivienda v = f.getVivienda1();
                                                    Reserva r;
                                                    do {
                                                        System.out.println("Inserta la fecha de inicio de la reserva, con el siguiente formato(dd-mm-aaaa)");
                                                        String inicio = s.nextLine();
                                                        finicio = LocalDate.parse(inicio, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                                                        System.out.println("Inserta la fecha de fin de la reserva, con el siguiente formato(dd-mm-aaaa)");
                                                        String fin = s.nextLine();
                                                        ffin = LocalDate.parse(fin, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                                                        r = new Reserva(finicio, ffin, v, f.getUsuarioById(logueado));
                                                    } while (!f.reservar(f.getUsuarioById(logueado), v, finicio, ffin));
                                                    Utils.generarTicketResrerva(r);
                                                    double pago;
                                                    do {
                                                        System.out.println("Inserta la candidad requerida para hacer la reserva");
                                                        pago = Double.parseDouble(s.nextLine());
                                                        if (pago < r.getPrecioTotal())
                                                            System.out.println("No has introducido suficiente dinero.");
                                                    } while (pago < r.getPrecioTotal());
                                                    System.out.println("Su reserva ha sido realizada con exito, pulsa ENTER para continuar");
                                                    Utils.espearaENTER();
                                                }
                                            }
                                        }
                                        break;
                                    }
                                    case 2: {
                                        System.out.println("Se han encontrado 1 viviendas en esta localidad, inserte el número correspondiente para reservarla, cualquier otro para cancelar");
                                        System.out.println("----------1----------\n" + f.getVivienda2());
                                        if (!s.nextLine().equals("1")) {
                                            System.out.println("La operación ha sido cancelada, pulsa ENTER para continuar");
                                            Utils.espearaENTER();
                                        } else {
                                            if (!f.getVivienda2().reservable()) {
                                                System.out.println("Lo sentimos, esa vivienda no es reservable en estos momentos, pulsa ENTER para continuar");
                                                Utils.espearaENTER();
                                            } else {
                                                System.out.println("La vivienda está reservada en el siguiente tramo:\n" + f.getVivienda2().reservada());
                                                System.out.print("Desea reservarla? (s/n):");
                                                if (!s.nextLine().equalsIgnoreCase("1")) {
                                                    System.out.println("Cancelando la operación, pulsa ENTER para continuar");
                                                    Utils.espearaENTER();
                                                } else {
                                                    LocalDate finicio = null;
                                                    LocalDate ffin = null;
                                                    Vivienda v = f.getVivienda2();
                                                    Reserva r;
                                                    do {
                                                        System.out.println("Inserta la fecha de inicio de la reserva, con el siguiente formato(dd-mm-aaaa)");
                                                        String inicio = s.nextLine();
                                                        finicio = LocalDate.parse(inicio, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                                                        System.out.println("Inserta la fecha de fin de la reserva, con el siguiente formato(dd-mm-aaaa)");
                                                        String fin = s.nextLine();
                                                        ffin = LocalDate.parse(fin, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                                                        r = new Reserva(finicio, ffin, v, f.getUsuarioById(logueado));
                                                    } while (!f.reservar(f.getUsuarioById(logueado), v, finicio, ffin));
                                                    Utils.generarTicketResrerva(r);
                                                    double pago;
                                                    do {
                                                        System.out.println("Inserta la candidad requerida para hacer la reserva");
                                                        pago = Double.parseDouble(s.nextLine());
                                                        if (pago < r.getPrecioTotal())
                                                            System.out.println("No has introducido suficiente dinero.");
                                                    } while (pago < r.getPrecioTotal());
                                                    System.out.println("Su reserva ha sido realizada con exito, pulsa ENTER para continuar");
                                                    Utils.espearaENTER();
                                                }
                                            }
                                        }
                                        break;
                                    }
                                    case 3: {
                                        System.out.println("Se han encontrado 2 viviendas en esta localidad, inserte el número correspondiente, para reservarla, cualquier otro para cncelar");
                                        System.out.println("----------1----------\n" + f.getVivienda1());
                                        System.out.println("----------2----------\n" + f.getVivienda2());
                                        String opcion = s.nextLine();
                                        switch (opcion) {
                                            case "1": {
                                                if (!f.getVivienda1().reservable()) {
                                                    System.out.println("Lo sentimos, esa vivienda no es reservable en esos momentos, pulsa ENTER para continuar");
                                                    Utils.espearaENTER();
                                                } else {
                                                    System.out.println("La vivienda está reservada en el siguiente tramo:\n" + f.getVivienda1().reservada());
                                                    System.out.print("Desea reservarla (s/n):");
                                                    if (!s.nextLine().equalsIgnoreCase("s")) {
                                                        System.out.println("Cancelando la operación, pulsa ENTER para continuar");
                                                        Utils.espearaENTER();
                                                    } else {
                                                        LocalDate finicio = null;
                                                        LocalDate ffin = null;
                                                        Vivienda v = f.getVivienda1();
                                                        Reserva r;
                                                        do {
                                                            System.out.println("Inserta la fecha de inicio de la reserva, con el siguiente formato(dd-mm-aaaa)");
                                                            String inicio = s.nextLine();
                                                            finicio = LocalDate.parse(inicio, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                                                            System.out.println("Inserta la fecha de fin de la reserva, con el siguiente formato(dd-mm-aaaa)");
                                                            String fin = s.nextLine();
                                                            ffin = LocalDate.parse(fin, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                                                            r = new Reserva(finicio, ffin, v, f.getUsuarioById(logueado));
                                                        } while (!f.reservar(f.getUsuarioById(logueado), v, finicio, ffin));
                                                        Utils.generarTicketResrerva(r);
                                                        double pago;
                                                        do {
                                                            System.out.println("Inserta la candidad requerida para hacer la reserva");
                                                            pago = Double.parseDouble(s.nextLine());
                                                            if (pago < r.getPrecioTotal())
                                                                System.out.println("No has introducido suficiente dinero.");
                                                        } while (pago < r.getPrecioTotal());
                                                        System.out.println("Su reserva ha sido realizada con exito, pulsa ENTER para continuar");
                                                        Utils.espearaENTER();
                                                    }
                                                }
                                                break;
                                            }
                                            case "2": {
                                                if (!f.getVivienda2().reservable()) {
                                                    System.out.println("Lo sentimos, esa vivienda no es reservable en esos momentos, pulsa ENTER para continuar");
                                                    Utils.espearaENTER();
                                                } else {
                                                    System.out.println("La vivienda está reservada en el siguiente tramo:\n" + f.getVivienda2().reservada());
                                                    System.out.print("Desea reservarla? (s/n):");
                                                    if (!s.nextLine().equalsIgnoreCase("s")) {
                                                        System.out.println("Cancelando la operación, pulsa ENTER para continuar");
                                                        Utils.espearaENTER();
                                                    } else {
                                                        LocalDate finicio = null;
                                                        LocalDate ffin = null;
                                                        Vivienda v = f.getVivienda2();
                                                        Reserva r;
                                                        do {
                                                            System.out.println("Inserta la fecha de inicio de la reserva, con el siguiente formato(dd-mm-aaaa)");
                                                            String inicio = s.nextLine();
                                                            finicio = LocalDate.parse(inicio, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                                                            System.out.println("Inserta la fecha de fin de la reserva, con el siguiente formato(dd-mm-aaaa)");
                                                            String fin = s.nextLine();
                                                            ffin = LocalDate.parse(fin, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                                                            r = new Reserva(finicio, ffin, v, f.getUsuarioById(logueado));
                                                        } while (!f.reservar(f.getUsuarioById(logueado), v, finicio, ffin));
                                                        Utils.generarTicketResrerva(r);
                                                        double pago;
                                                        do {
                                                            System.out.println("Inserta la candidad requerida para hacer la reserva");
                                                            pago = Double.parseDouble(s.nextLine());
                                                            if (pago < r.getPrecioTotal())
                                                                System.out.println("No has introducido suficiente dinero.");
                                                        } while (pago < r.getPrecioTotal());
                                                        System.out.println("Su reserva ha sido realizada con exito, pulsa ENTER para continuar");
                                                        Utils.espearaENTER();
                                                    }
                                                }
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    case 0:
                                        System.out.println("No se ha encontrado ninguna vivienda en esa localidad, pulsa ENTER para continuar");
                                        Utils.espearaENTER();

                                }
                                break;
                            }
                            case "2": {
                                System.out.println("Estas son tus reservas:");
                                if (f.getUsuarioById(logueado).getReserva1() != null)
                                    System.out.println(f.getUsuarioById(logueado).getReserva1());
                                if (f.getUsuarioById(logueado).getReserva2() != null)
                                    System.out.println(f.getUsuarioById(logueado).getReserva2());
                                System.out.println("Pulsa ENTER para continuar");
                                Utils.espearaENTER();
                                break;
                            }
                            case "3": {
                                Reserva r1 = null, r2 = null, r = null;
                                if (f.getUsuarioById(logueado).getReserva1() != null) {
                                    if (f.getUsuarioById(logueado).getReserva2() != null) {
                                        r1 = f.getUsuarioById(logueado).getReserva1();
                                        r2 = f.getUsuarioById(logueado).getReserva2();
                                    }
                                    r1 = f.getUsuarioById(logueado).getReserva1();
                                }
                                if (r1 == null && r2 == null) {
                                    System.out.println("No tienes nada que reservar, pulsa ENTER para continuar");
                                    Utils.espearaENTER();
                                } else {
                                    if (r1 != null && r2 != null) {
                                        System.out.println("¿Que reserva quieres editar?");
                                        System.out.println("1.-\n" + r1);
                                        System.out.println("2.-\n" + r2);
                                        String respuesta = s.nextLine();
                                        switch (respuesta) {
                                            case "1" -> {
                                                r = r1;
                                                r.getVivienda().reserva1ToNull();
                                            }
                                            case "2" -> {
                                                r = r2;
                                                r.getVivienda().reserva2ToNull();
                                            }
                                            default -> {
                                                System.out.println("No has introducido un valor válido, pulsa ENTER para continuar");
                                                Utils.espearaENTER();
                                            }
                                        }
                                    } else {
                                        if (r1 != null) {
                                            System.out.println("¿Que reserva quieres editar?");
                                            System.out.println("1.-\n" + r1);
                                            if (!s.nextLine().equalsIgnoreCase("1")) {
                                                System.out.println("No has introducido un valor válido, pulsa ENTER para continuar");
                                                Utils.espearaENTER();
                                            } else {
                                                r = r1;
                                            }
                                        }
                                        if (r2 != null) {
                                            System.out.println("¿Que reserva quieres editar?");
                                            System.out.println("1.-\n" + r2);
                                            if (!s.nextLine().equalsIgnoreCase("1")) {
                                                System.out.println("No has introducido un valor válido, pulsa ENTER para continuar");
                                                Utils.espearaENTER();
                                            } else {
                                                r = r2;
                                            }
                                        }
                                    }
                                    if (r != null) {
                                        double precio = r.getPrecioTotal();
                                        System.out.println("Vamos a modificar la fecha de tu reserva, introduce una nueva fecha para saber si está libre y se puede modificar la reserva");
                                        System.out.println("Inserta la fecha de inicio de la reserva, con el siguiente formato(dd-mm-aaaa)");
                                        String inicio = s.nextLine();
                                        LocalDate finicio = LocalDate.parse(inicio, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                                        System.out.println("Inserta la fecha de fin de la reserva, con el siguiente formato(dd-mm-aaaa)");
                                        String fin = s.nextLine();
                                        LocalDate ffin = LocalDate.parse(fin, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                                        if (!f.reserbable(r.getVivienda(), finicio, ffin)) {
                                            System.out.println("No se pudo modificar la reserva, pulsa ENTER para continuar");
                                            Utils.espearaENTER();
                                        } else {
                                            r.modifica(finicio, ffin);
                                            double diferencia = precio - r.getPrecioTotal();
                                            if (diferencia != 0) {
                                                if (diferencia > 0) {
                                                    System.out.println("Al cambiar las fechas te hemos devuelto " + diferencia + " EUROS");
                                                } else {
                                                    diferencia = Math.abs(diferencia);
                                                    System.out.println("Al cambiar las fechas ahora tienes que introducir " + diferencia + " EUROS");
                                                    double pago;
                                                    do {
                                                        System.out.println("Introduce " + diferencia + " EUROS para continuar con la modificación");
                                                        pago = Double.parseDouble(s.nextLine());
                                                        if (pago < diferencia)
                                                            System.out.println("No has introducido suficiente dinero");
                                                    } while (pago < diferencia);
                                                }
                                            }
                                            System.out.println("La reserva ha sido modificada correctamente, pulsa ENTER para continuar");
                                            Utils.espearaENTER();
                                        }
                                    }
                                }
                                break;
                            }
                            case "4": {
                                System.out.println(f.getUsuarioById(logueado));
                                Utils.espearaENTER();
                                break;
                            }
                            case "5": {
                                System.out.println("Ok, vamos a proceder a modificar tu perfil, si quieres dejar algún campo como estaba" +
                                        "anteriormente dejalo en blanco");
                                System.out.println("Inserta tu nombre: (Antes era " + f.getUsuarioById(logueado).getNombre() + ")");
                                String nombre = s.nextLine();
                                System.out.println("Inserta tu usuario: (Antes era " + f.getUsuarioById(logueado).getNombre() + ")");
                                String usuario = s.nextLine();
                                System.out.println("Inserta tu contraseña: (Por seguridad no te puedo decir cual era antes)");
                                String pass = s.nextLine();
                                f.getUsuarioById(logueado).modificar(nombre, usuario, pass);
                                System.out.println("Su usuario ha sido modificado con exito, pulsa ENTER para continuar");
                                Utils.espearaENTER();
                                break;
                            }
                            case "6": {
                                logueado = "";
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
