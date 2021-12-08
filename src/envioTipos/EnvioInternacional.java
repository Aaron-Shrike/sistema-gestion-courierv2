
package envioTipos;

import envioListas.Consignado;
import envioListas.Objeto;
import java.util.Scanner;
import proyectoFinal.Destino;
import proyectoFinal.Envio;
import proyectoFinal.Principal;

/**
 *
 * @author AaronSh
 */
public class EnvioInternacional extends Envio{
    private final Scanner leer = new Scanner(System.in);
    
    private String codPostal;
    private String destino;
    private String abreviatura;
    private double precioEstandar;
    private double precioAdicional;
    private double pesoTotal;
    private double costo;

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

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

    public double getPrecioEstandar() {
        return precioEstandar;
    }

    public void setPrecioEstandar(double precioEstandar) {
        this.precioEstandar = precioEstandar;
    }

    public double getPrecioAdicional() {
        return precioAdicional;
    }

    public void setPrecioAdicional(double precioAdicional) {
        this.precioAdicional = precioAdicional;
    }

    public double getPesoTotal() {
        return pesoTotal;
    }

    public void setPesoTotal(double pesoTotal) {
        this.pesoTotal = pesoTotal;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public void leer(){
        double auxDouble;
        int n;
        int pos;
        
        Destino dest;

        System.out.println("");
        super.leer();

        System.out.println("\n > Codigo postal(Estado) : ");
        codPostal = leer.nextLine();

        pos = registrarDestino();
        
        dest = Principal.tres.get(pos);
        
        destino = dest.getDestino();
        abreviatura = dest.getAbreviatura();
        System.out.println("");
        precioEstandar = Principal.leeReal(" > Precio Estandar[60-300] : ",60.0,300.0," * Precio no valido");
        precioAdicional = Principal.leeReal(" > Precio Adicional[20-100] : ",20.0,100.0," * Precio no valido");

        n = 0;
        registrarObjeto(n,2);

        n = 0;
        registrarConsignado(n);

        Objeto objeto;

        objeto = objetos.get(0);

        pesoTotal = objeto.getPeso();

        n = 0;
        if(pesoTotal > 0.5){

            auxDouble = pesoTotal - 0.5;
            do{
                auxDouble--;
         	n++;
            }while(auxDouble > 0.0);

            costo = precioEstandar + (double)n * precioAdicional;
   	}else{

            costo = precioEstandar;
        }
    }

    public void mostrarInternacional(){
   	Objeto objeto;
        Consignado consignado;
   	
        super.mostrar();
        System.out.println("\n	Codigo Postal : "+codPostal);
        System.out.println("	Pais : "+destino+"("+abreviatura+")\n");
        for(int i=0;i<consignados.size();i++){
            consignado = consignados.get(i);

            consignado.mostrarConsignado();
        }
        System.out.println("");
        for(int i=0;i<objetos.size();i++){
            objeto = objetos.get(i);

            objeto.mostrarObjeto();
        }
        System.out.println("	Peso total : "+pesoTotal+" Kg.");
        System.out.println("	Costo : S/. "+costo);
    }
       
    @Override
    public int getTipoEnvio() {
        return 3;
    }
    
}
