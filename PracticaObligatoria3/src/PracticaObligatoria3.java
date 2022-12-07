import Media.FernanByB;
import Media.Usuario;
import jdk.jshell.execution.Util;

import java.time.LocalDate;
import java.util.Scanner;

public class PracticaObligatoria3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
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
                    case "1" -> logueado = Utils.loggin(f);
                    case "2" -> Utils.registraUsuario(f);
                    case "3" -> Utils.registrarPropietario(f);
                    case "4" -> Utils.registrarAdministrador(f);
                    default  -> Utils.opcionNoValida();
                }
            } else {
                Utils.menu(logueado, f,salida);
            }
        }


    }
}
