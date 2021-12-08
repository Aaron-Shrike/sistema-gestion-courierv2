
package envioTipos;

import destinoTipos.DestinoNacional;
import envioListas.Consignado;
import envioListas.Objeto;
import proyectoFinal.Destino;
import proyectoFinal.Envio;
import proyectoFinal.Principal;

/**
 *
 * @author AaronSh
 */
public class EnvioRegular extends Envio{
    private String destino;
    private String abreviatura;
    private int cantidadObjetos;
    private double pesoTotal;
    private double costo;

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

    public int getCantidadObjetos() {
        return cantidadObjetos;
    }

    public void setCantidadObjetos(int cantidadObjetos) {
        this.cantidadObjetos = cantidadObjetos;
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
        double auxDouble = 0;
        double auxEstandar = 0;
   	double auxAdicional = 0;
        int n;
        int pos;
        
        Destino dest;

        System.out.println("");
        super.leer();

        pos = registrarDestino();
        
        dest = Principal.tres.get(pos);
        
        destino = dest.getDestino();
        abreviatura = dest.getAbreviatura();
        auxEstandar = ((DestinoNacional )dest).getTarifaEstandar();
        auxAdicional = ((DestinoNacional )dest).getTarifaAdicional();

        System.out.println("");
        cantidadObjetos = Principal.leeEntero(" > Cantidad de objetos[1-8]: ",1,8," * Cantidad no valida");

        System.out.println("\n(------- REGISTRAR OBJETOS -------)");

        n = 0;
        do{
            registrarObjeto(n,1);
            n++;
        }while(!(n == cantidadObjetos));

        n = 0;
        registrarConsignado(n);

        Objeto objeto;

        for(int i=0;i<objetos.size();i++){
            objeto = objetos.get(i);

            pesoTotal += objeto.getPeso();
        }

        n = 0;
        if(pesoTotal > 1.3){

            auxDouble = pesoTotal - 1.3;
            do{
                auxDouble--;
         	n++;
            }while(auxDouble > 0.0);

            costo = auxEstandar + (double)n * auxAdicional;
   	}else{
            costo = auxEstandar;
        }
    }

    public void mostrarRegular(){
   	Objeto objeto;
        Consignado consignado;

   	super.mostrar();
        System.out.println("\n	Departamento : "+destino+"("+abreviatura+")\n");
      	consignado = consignados.get(0);
        consignado.mostrarConsignado();
        
        System.out.println("");
        for(int i=0;i<objetos.size();i++){
            objeto = objetos.get(i);

            objeto.mostrarObjeto();
        }
        
        System.out.println("\n	Peso total : "+pesoTotal+" Kg.");
        System.out.println("	Costo : S/. "+costo);
    }
    
    @Override
    public int getTipoEnvio() {
        return 1;
    }
    
}
