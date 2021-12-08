
package proyectoFinal;

/**
 *
 * @author AaronSh
 */
public class Tarifa {
    private double estandar;
    private double masKilo;

    public double getEstandar() {
        return estandar;
    }

    public void setEstandar(double estandar) {
        this.estandar = estandar;
    }

    public double getMasKilo() {
        return masKilo;
    }

    public void setMasKilo(double masKilo) {
        this.masKilo = masKilo;
    }
    
    public void leer(int flag,int flag1){        
        double auxEstandar,auxMasKilo;

        System.out.println("\n[------------- TARIFA NACIONAL -------------]\n");
        System.out.println(" > Precios :");

        System.out.println("");
        
        auxEstandar = Principal.leeReal("	+ Estandar[7.00-16.00] : ",7.00,16.00," * Precio no valido");
        for (int i = 0; i < Principal.dos.size(); i++) {
                       
            if(Principal.dos.get(i).estandar == auxEstandar){
                flag = 1;
            }
        }
        auxMasKilo = Principal.leeReal("	+ Adicional[1.50-7.50] : ",1.50,7.50," * Precio no valido");
        for (int i = 0; i < Principal.dos.size(); i++) {
                       
            if(Principal.dos.get(i).masKilo == auxMasKilo){
                flag1 = 1;
            }
        }

        if(flag == 1 && flag1 == 1){

            System.out.println("");
            System.out.println("	* Tarifa registrada anteriorente");
        }else{

            estandar = auxEstandar;
            masKilo = auxMasKilo;
        }
    }

    void mostrar(){

   	System.out.println("	Estandar : "+estandar);
        System.out.println("	Adicional : "+masKilo);
    }
}
