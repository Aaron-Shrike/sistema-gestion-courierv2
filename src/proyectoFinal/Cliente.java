
package proyectoFinal;

import java.util.Scanner;

/**
 *
 * @author AaronSh
 */
public class Cliente {
   private int codigo;
   private String pagina;
   private String dni;
   private String nombre;
   private String direccion;
   private String telefono;
   private String correo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo + 100;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
   
    public void leer(){
        Scanner leer = new Scanner(System.in);
        
        System.out.println(" > Codigo Asignado : "+codigo);
        System.out.print(" > Pagina WEB : ");
        pagina = leer.nextLine();
   	do{
            System.out.print(" > DNI(8 digitos) : ");
            dni = leer.nextLine();
        }while(!(dni.length() == Principal.MAXDNI));
        System.out.print(" > Nombre : ");
        nombre = leer.nextLine();
        System.out.print(" > Direccion : ");
        direccion = leer.nextLine();
        do{
            System.out.print(" > Telefono : ");
            telefono = leer.nextLine();
        }while(!(telefono.length() == Principal.MAXFONE));
        System.out.print(" > Correo : ");
        correo = leer.nextLine();
   }

   void mostrar(){

        System.out.println("	CODIGO : "+codigo);
        System.out.println("	Pagina WEB : "+pagina);
        System.out.println("	DNI : "+dni);
        System.out.println("	Nombre : "+nombre);
        System.out.println("	Direccion : "+direccion);
        System.out.println("	Telefono : "+telefono);
        System.out.println("	Correo : "+correo);
   }
}
