package destinoTipos;

import proyectoFinal.Destino;
import proyectoFinal.Principal;
import proyectoFinal.Tarifa;

/**
 *
 * @author AaronSh
 */
public class DestinoNacional extends Destino{
    private double tarifaEstandar;
    private double tarifaAdicional;

    public double getTarifaEstandar() {
        return tarifaEstandar;
    }

    public void setTarifaEstandar(double tarifaEstandar) {
        this.tarifaEstandar = tarifaEstandar;
    }

    public double getTarifaAdicional() {
        return tarifaAdicional;
    }

    public void setTarifaAdicional(double tarifaAdicional) {
        this.tarifaAdicional = tarifaAdicional;
    }
    
    @Override
    public void leer(){
        int pos;
        
        Tarifa tari;
        
   	System.out.println("\n[---------- NUEVO DEPARTAMENTO ----------]\n");
        System.out.print(" > Departamento : ");
        super.leer();
        System.out.println("");
        pos = leerTarifaDepartamento();
        
        tari = Principal.dos.get(pos);

	tarifaEstandar = tari.getEstandar();
   	tarifaAdicional = tari.getMasKilo();
        
        System.out.println("Prueb Tarifas : "+tarifaEstandar+" - "+tarifaAdicional);
    }

    public void mostrarDestinoNacional(){

        super.mostrar();
   	System.out.println("	Estandar : "+tarifaEstandar);
        System.out.println("	Adicional : "+tarifaAdicional);
    }   
    
    @Override
    public int  getTipoDestino() {
        return 1;
    }
    
}
