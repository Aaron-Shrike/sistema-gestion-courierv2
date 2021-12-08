
package envioListas;

import java.util.Scanner;
import proyectoFinal.Principal;

/**
 *
 * @author AaronSh
 */
public class Objeto {
    private final Scanner leer = new Scanner(System.in);
    
    private int tipoObjeto;
    private double peso;
    private String descripcion;

    public int getTipoObjeto() {
        return tipoObjeto;
    }

    public void setTipoObjeto(int tipoObjeto) {
        this.tipoObjeto = tipoObjeto;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public void leer(int aux,int auxTipo){

   	if(auxTipo == 1){
            objetoNacional(aux);
        }else{
            objetoInternacional(aux);
        }
    }

    public void objetoNacional(int aux){    
        String magnitudes[] = {"Gramos(gr.)","Kilogramos(Kg.)"};
   	String tipos[] = {"Sobre","Paquete"};
        int op;

        System.out.println("--- OBJETO [Nro. "+(aux+1)+"] ---\n\n");

        for(int i = 0; i < 2; i++){
            
            System.out.println("   "+(i+1)+". "+magnitudes[i]);
        }

        op = Principal.leeEntero(" Opcion : ",1,2," * Opcion no valida");

        System.out.println("");
        if(op == 1){
            
            peso = Principal.leeReal(" > Peso[1-999] : ",1.0,999.0,"	  * Peso no valido");
            peso = peso/1000;
        }else{
            
            peso = Principal.leeReal(" > Peso[1-25] : ",1.0,25.00,"	  * Peso no valido");
        }

        if(peso > 1.3){
            
            tipoObjeto = 2;
        }else{
            System.out.println("");
            for(int i=0;i<2;i++){
                
                System.out.println("	"+(i+1)+". "+tipos[i]);
            }

            tipoObjeto = Principal.leeEntero(" > Tipo de Objeto : ",1,2,"	* Tipo no valida");
   	}
        System.out.print("\n > Descripcion : ");
        descripcion = leer.nextLine();
    }

    public void objetoInternacional(int aux){
        String magnitudes[] = {"Gramos(gr.)","Kilogramos(Kg.)"};
   	String tipos[] = {"Sobre","Paquete"};
        int op;

        System.out.println("--- OBJETO [Nro. "+(aux+1)+"] ---\n\n");

        for(int i=0;i<2;i++){
            
            System.out.println("   "+(i+1)+". "+magnitudes[i]);
        }

        op = Principal.leeEntero(" Opcion : ",1,2," * Opcion no valida");

        System.out.println("");
        if(op == 1){
            
            peso = Principal.leeReal(" > Peso[1-999] : ",1.0,999.0,"	  * Peso no valido");
            peso = peso/1000;
        }else{
            
            peso = Principal.leeReal(" > Peso[1-5] : ",1.0,5.00,"	  * Peso no valido");
        }

        if(peso > 0.5){
            
            tipoObjeto = 2;
        }else{
            
            System.out.println("");
            for(int i=0;i<2;i++){
                
                System.out.println("	"+(i+1)+". "+tipos[i]);
            }

            tipoObjeto = Principal.leeEntero(" > Tipo de Objeto : ",1,2,"	* Tipo no valida");
   	}
        
        System.out.print("\n > Descripcion : ");
        descripcion = leer.nextLine();
    }

    public void mostrarObjeto(){
        String tipos[] = {"Sobre","Paquete"};

   	System.out.println("	Tipo de objeto : "+tipos[tipoObjeto-1]);
        System.out.println("	Peso : "+peso+" Kg.");
        System.out.println("	Descripcion : "+descripcion);
    }
}
