
package envioListas;

import java.util.Scanner;
import proyectoFinal.Principal;

/**
 *
 * @author AaronSh
 */
public class Consignado {
    private final Scanner leer = new Scanner(System.in);
    
    private int auxRemito;
    private String dni;
    private String nombre;
    private String direccion;
    private String telefono;

    public int getAuxRemito() {
        return auxRemito;
    }

    public void setAuxRemito(int auxRemito) {
        this.auxRemito = auxRemito;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void leer(int aux){

        System.out.println("\n------- CONSIGNADO [Nro. "+(aux+1)+"] -------\n");

        do{
            System.out.print(" > DNI(8 digitos) : ");
            dni = leer.nextLine();
        }while(!(dni.length() == Principal.MAXDNI));
        System.out.print(" > Nombre : ");
        nombre = leer.nextLine();
        System.out.print(" > Direccion : ");
        direccion = leer.nextLine();
        do{
            System.out.print(" > Telefono(9 digitos) : ");
            telefono = leer.nextLine();
        }while(!(telefono.length() == Principal.MAXFONE));
    }

    public void mostrarConsignado(){

   	System.out.println("	DNI : "+dni);
        System.out.println("	Nombre : "+nombre);
        System.out.println("	Direccion : "+direccion);
        System.out.println("	Telefono : "+telefono);
    }
}
