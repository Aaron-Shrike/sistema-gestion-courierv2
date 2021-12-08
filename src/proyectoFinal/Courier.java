
package proyectoFinal;

import java.util.Scanner;

/**
 *
 * @author AaronSh
 */
public class Courier {
    private String nombre;
    private String nombreEmpresa;
    private String rucEmpresa;
    private String direccionEmpresa;
    private String referenciaEmpresa;
    private String departamento;
    private String direccion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getRucEmpresa() {
        return rucEmpresa;
    }

    public void setRucEmpresa(String rucEmpresa) {
        this.rucEmpresa = rucEmpresa;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    public String getReferenciaEmpresa() {
        return referenciaEmpresa;
    }

    public void setReferenciaEmpresa(String referenciaEmpresa) {
        this.referenciaEmpresa = referenciaEmpresa;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public void leer(){
        Scanner lee = new Scanner(System.in);
        
        System.out.println("[+---------------- REGISTRAR COURIER ----------------+]\n");
        System.out.print(" > Nombre : ");
        nombre = lee.nextLine();
        System.out.println("");
        System.out.println(" > Datos de la Empresa:");
        System.out.print("	+ Nombre : ");
        nombreEmpresa = lee.nextLine();
        do{
            System.out.print("	+ RUC(11 digitos) : ");
            rucEmpresa = lee.nextLine();
        }while(!(rucEmpresa.length() == Principal.MAXRUC));
        System.out.print("	+ Direccion : ");
        direccionEmpresa = lee.nextLine();
        System.out.print("	+ Referencia : ");
        referenciaEmpresa = lee.nextLine();
        System.out.println("");
        System.out.print(" > Departamento : ");
        departamento = lee.nextLine();
        System.out.print(" > Direccion : ");
        direccion = lee.nextLine();
    }

   void mostrar(){
        System.out.println("			"+nombre);
        System.out.println("");
        System.out.println("			"+nombreEmpresa);
        System.out.println("    RUC : "+rucEmpresa+" - "+direccionEmpresa);
        System.out.println("		"+referenciaEmpresa);
        System.out.println("");
        System.out.println("			"+departamento);
        System.out.println("		"+direccion);
   }
}
