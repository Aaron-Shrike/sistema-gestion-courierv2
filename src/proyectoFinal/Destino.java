
package proyectoFinal;

import java.util.Scanner;

/**
 *
 * @author AaronSh
 */
public abstract class Destino {
    private String destino;
    private String abreviatura;

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public void leer(){
        Scanner leer = new Scanner(System.in);
        
	destino = leer.nextLine();
	System.out.print(" > Abreviatura : ");
        abreviatura = leer.nextLine();
    }

    public void mostrar(){

        System.out.println("	Destino : "+destino);
        System.out.println("	Abreviatura : "+abreviatura);
    }
    
    public int leerTarifaDepartamento(){
        int op;
	double estandar;
   	double masKilo;

        Tarifa tarifa;

   	System.out.println("    Listado de Tarifas\n");
        System.out.println("	    -Estandar-	-Adicional-\n");
   	for(int i = 0; i < Principal.dos.size(); i++){
            tarifa = Principal.dos.get(i);

            estandar = tarifa.getEstandar();
            masKilo = tarifa.getMasKilo();
            System.out.println("	"+(i+1)+".     "+estandar+"    	    "+masKilo);
	}
        System.out.println("");
        op = Principal.leeEntero(" > Tipo de tarifa : ",1,Principal.dos.size()," * Tipo no valido");

   	return (op-1);
   }
    
    public abstract int getTipoDestino();
}
