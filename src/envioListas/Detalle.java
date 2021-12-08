
package envioListas;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author AaronSh
 */
public class Detalle {
    private final Scanner leer = new Scanner(System.in);
    
    private Date fDetalle = new Date(0,0,0,0,0,0);
    private String nombre;
    private String descripcion;

    public Date getfDetalle() {
        return fDetalle;
    }

    public void setfDetalle(Date fDetalle) {
        this.fDetalle = fDetalle;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public void leer(){
        
        setfDetalle(new Date());
        System.out.print(" > Nombre : ");
        nombre = leer.nextLine();
        System.out.print(" > Descripcion : ");
        descripcion = leer.nextLine();
    }
    
    public void mostrar(){
        
        System.out.println("    Nombre : "+nombre);
        System.out.println("    Descripcion : "+descripcion);
    }
}
