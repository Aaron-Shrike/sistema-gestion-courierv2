
package proyectoFinal;

import envioListas.Consignado;
import envioListas.Detalle;
import envioListas.Objeto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author AaronSh
 */
public abstract class Envio {
    private final Scanner leer = new Scanner(System.in);
    
    private Date fRegistro = new Date(0,0,0,0,0,0);
    private Date fRuta = new Date(0,0,0,0,0,0);
    private Date fLlegada = new Date(0,0,0,0,0,0);
    private int numRemito;
    private int estado;
    private String dignatario;
    //Remitente
    private String dni;
    private String nombre;
    private String direccion;
    private String telefono;
    private String correo;
    //Listas
    public static List<Detalle> detalles = new ArrayList<>();
    public static List<Objeto> objetos = new ArrayList<>();
    public static List<Consignado> consignados = new ArrayList<>();

      
    public Date getfRegistro() {
        return fRegistro;
    }
    
    public void setfRegistro(Date fRegistro) {
        this.fRegistro = fRegistro;
    }
    
    public Date getfRuta() {
        return fRuta;
    }

    public void setfRuta(Date fRuta) {
        this.fRuta = fRuta;
    }

    public Date getfLlegada() {
        return fLlegada;
    }

    public void setfLlegada(Date fLlegada) {
        this.fLlegada = fLlegada;
    }
    
    public int getNumRemito() {
        return numRemito;
    }

    public void setNumRemito(int numRemito) {
        this.numRemito = numRemito + 10000;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getDignatario() {
        return dignatario;
    }

    public void setDignatario(String dignatario) {
        this.dignatario = dignatario;
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

    public static List<Detalle> getDetalles() {
        return detalles;
    }

    public static void setDetalles(List<Detalle> detalles) {
        Envio.detalles = detalles;
    }

    public static List<Objeto> getObjetos() {
        return objetos;
    }

    public static void setObjetos(List<Objeto> objetos) {
        Envio.objetos = objetos;
    }

    public static List<Consignado> getConsignados() {
        return consignados;
    }

    public static void setConsignados(List<Consignado> consignados) {
        Envio.consignados = consignados;
    }
    
    public void leer(){
   	
        setfRegistro(new Date());
        System.out.println("\n > Nro. Remito asignado: "+numRemito);
        System.out.print(" > Dignatario: ");
        dignatario = leer.nextLine();

        System.out.println("\n(--------- REGISTRAR REMITENTE ---------)\n");

        if(getTipoEnvio() != 2) {

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
            System.out.print(" > Correo : ");
            correo = leer.nextLine();

            System.out.println("\n * REMITENTE registrado exitosamente");
        }else{
            int auxCodigo;

            Cliente cliente = null;

            auxCodigo = Principal.leeEntero(" > Codigo de cliente[100-999] : ",100,999," * Codigo no valido"); 
            for (int i = 0; i < Principal.cuatro.size(); i++) {
                
                if(Principal.cuatro.get(i).getCodigo() == auxCodigo){
                    cliente = Principal.cuatro.get(i);
                }
            }

            if(cliente != null){

         	dni = cliente.getDni();
         	nombre = cliente.getNombre();
         	direccion = cliente.getDireccion();
         	telefono = cliente.getTelefono();
         	correo = cliente.getCorreo();

                System.out.println("\n * REMITENTE registrado exitosamente");
            }else{
                
                System.out.println("\n * Cliente no encontrado");
            }
        }

    }

    public void mostrar(){

        System.out.println("	Nro. Remito : "+numRemito);
        System.out.println("	Dignatario : "+dignatario);
        System.out.println("");
        System.out.println("	DNI : "+dni);
        System.out.println("	Nombre : "+nombre);
        System.out.println("	Direccion : "+direccion);
        System.out.println("	Telefono : "+telefono);
        System.out.println("	Correo : "+correo);
    }
    
    public abstract int getTipoEnvio();
    
    //ADD
    
    public int registrarDestino(){
        String auxDestino;
        int op;
        int n = 0;
        int contador = 0 ;
        int auxTipo;

        Destino destino;

        System.out.println("");

        if(getTipoEnvio() != 3){
            
            auxTipo = 1;
            
            System.out.println("    Listado de Departamentos");
        }else{
            
            auxTipo = 2;

            System.out.println("    Listado de Paises");
        }

        System.out.println("");

   	for(int i=0;i<Principal.tres.size();i++){
            destino = Principal.tres.get(i);

            if(destino.getTipoDestino() == auxTipo){
      		auxDestino = destino.getDestino();

      		System.out.println("	"+(n+1)+". "+auxDestino);
                n++;
            }
   	}

        System.out.println("");
        op = Principal.leeEntero(" Opcion : ",1,n," * Opcion no valida");

        for(int i=0;i<Principal.tres.size();i++){
            destino = Principal.tres.get(i);

            if(destino.getTipoDestino() == auxTipo){
      		contador++;

                if(contador == op){
                    op = i;
                }
            }
   	}

        return op;       
    }

    public void registrarObjeto(int aux,int aux1){
	Objeto objeto = new Objeto();

   	System.out.println("");
   	objeto.leer(aux,aux1);
   	objetos.add(objeto);

   	System.out.println("\n * OBJETO registrado exitosamente");
    }

    public void registrarConsignado(int aux){
   	Consignado consignado = new Consignado();

        consignado.setAuxRemito(getNumRemito());
        consignado.leer(aux);
        consignados.add(consignado);

        System.out.println("\n * CONSIGNADO registrado exitosamente");
   }
}
