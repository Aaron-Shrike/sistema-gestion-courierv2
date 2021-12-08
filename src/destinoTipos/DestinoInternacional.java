package destinoTipos;

import java.util.Scanner;
import proyectoFinal.Destino;

/**
 *
 * @author AaronSh
 */
public class DestinoInternacional extends Destino{
    private final Scanner leer = new Scanner(System.in);
    
    private String codPostal;

    @Override
    public void leer(){

   	System.out.println("\n[--------- REGISTRAR PAIS ---------]\n");
        System.out.print(" > Pais : ");
        super.leer();
        System.out.print(" > Codigo postal : ");
        codPostal = leer.nextLine();
    }

    public void mostrarDestinoInternacional(){

        super.mostrar();
        System.out.println("	Codigo Postal : "+codPostal);
    }
    
    @Override
    public int getTipoDestino() {
        return 2;
    }
   
}
