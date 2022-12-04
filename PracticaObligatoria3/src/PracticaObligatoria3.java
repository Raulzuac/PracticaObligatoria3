import Media.FernanByB;
import Media.Usuario;
import jdk.jshell.execution.Util;

import java.time.LocalDate;

public class PracticaObligatoria3 {
    public static void main(String[] args) {

        //Creacion de datos de ejemplo
        FernanByB f= new FernanByB();
        if (!f.nuevoUsuario("Antonio","antonio","pass")) Utils.usuariosLlenos();
        if (!f.nuevoUsuario("Manolo","manolo","pass")) Utils.usuariosLlenos();
        if (!f.nuevoPropietario("Jose","jose","pass")) Utils.propietariosLlenos();
        if (!f.nuevoPropietario("Jesus","jesus","pass")) Utils.propietariosLlenos();
        if (!f.nuevoAdmin("Admin","admin","pass")) Utils.adminLlenos();
        if (!f.nuevaVivienda("20","Pisito en la playa","Torremolinos","nose",10,1,2,"b"))
            Utils.pisosLlenos();
        if (!f.nuevaVivienda("21","Casa en la montaña","Torreperojil","La unica que hay",1))
            Utils.pisosLlenos();
        LocalDate l=LocalDate.now();
    }
}
