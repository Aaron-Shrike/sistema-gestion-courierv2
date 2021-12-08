
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
public class EnvioEventos extends Envio{
    private String destino;
    private String abreviatura;
    private int cantidadConsignados;
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

    public int getCantidadConsignados() {
        return cantidadConsignados;
    }

    public void setCantidadConsignados(int cantidadConsignados) {
        this.cantidadConsignados = cantidadConsignados;
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
        double auxEstandar = 0;
   	double auxAdicional = 0;
        double auxPeso;
        int auxTipo;
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

        n = 0;
        registrarObjeto(n,1);

        n = 0;
        registrarConsignado(n);

        Objeto objeto;

        objeto = objetos.get(0);

        auxPeso = objeto.getPeso();
        auxTipo = objeto.getTipoObjeto();

        System.out.println("");
        if(auxTipo == 1){
            cantidadConsignados = Principal.leeEntero(" > Sobres[70-200] : ",70,200," * Cantidad no valida");
        }else{
            cantidadConsignados = Principal.leeEntero(" > Paquetes[30-100] : ",30,100," * Cantidad no valida");
        }

        System.out.println("\n(------- REGISTRAR CONSIGNADOS -------)");

        n = 0;
        do{
            registrarConsignado(n);
            n++;
        }while(!(n == cantidadConsignados));

        pesoTotal = (double)auxPeso * cantidadConsignados;

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

    public void mostrarEventos(){
   	Objeto objeto;
        Consignado consignado;

        super.mostrar();
        System.out.println("	Departamento : "+destino+"("+abreviatura+")\n");
        for(int i=0;i<consignados.size();i++){
            consignado = consignados.get(i);

            consignado.mostrarConsignado();
        }
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
        return 4;
    }
    
}
