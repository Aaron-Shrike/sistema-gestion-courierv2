
package proyectoFinal;

import destinoTipos.DestinoInternacional;
import destinoTipos.DestinoNacional;
import envioListas.Consignado;
import envioListas.Detalle;
import envioListas.Objeto;
import envioTipos.EnvioEcommerce;
import envioTipos.EnvioEventos;
import envioTipos.EnvioInternacional;
import envioTipos.EnvioRegular;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author AaronSh
 */
public class Principal {
    public static Scanner leer = new Scanner(System.in);
    public static int MAXRUC = 11;
    public static int MAXDNI = 8;
    public static int MAXFONE = 9;
    
    public static double leeReal(String msje,double min,double max,String msje1){
        double num;

  	do{
            System.out.print(msje);
            num = leer.nextDouble();
            if(num<min || num>max){
                System.out.println(msje1);
            }
        }while(!(num>=min && num<=max));
        
        return num;
    }
    
    public static int leeEntero(String msje,int min,int max,String msje1){        
        int num;

  	do{
            System.out.print(msje);
            num = leer.nextInt();
            if(num<min || num>max){
                System.out.println(msje1);
            }
        }while(!(num>=min && num<=max));
        
        return num;
    }
    
    
    
    
    public static Courier uno = new Courier();
    public static List<Tarifa> dos = new ArrayList<>();
    public static List<Destino> tres = new ArrayList<>();
    public static List<Cliente> cuatro = new ArrayList<>();
    public static List<Envio> cinco = new ArrayList<>();
    
    public static void main(String[] args) {
        int flag = 0,flag1 = 0,flag2 = 0,flag3 = 0,op;

	do{
            System.out.println("\n\n\n\n\n\n[+------------> { * MENU * } <------------+]");

            op = leerOpcion();

            switch(op){
                case 1: if(flag == 0){
                            registrarCourier();
                            flag = 1;
                        }else{
                            System.out.println("	* Ya registro su COURIER");
                        }
                    break;
                case 2: if(flag == 1){
                            registrarTarifas();
                            flag1 = 1;
                        }else{
                            System.out.println("   * Courier no registrada");
                        }
                    break;
                case 3: if(flag1 == 1){
                            registrarDestinos();
                            flag2 = 1;
         		}else{
                            System.out.println("   * Tarifas no registrada");
                        }
                    break;
                case 4: if(flag == 1){
                            registrarClientes();
                        }else{
                            System.out.println("   * Courier no registrada");
                        }
                    break;
                case 5: if(flag2 == 1){
                            registrarEnvios();
                            flag3 = 1;
                        }else{
                            System.out.println("   * Departamentos no registrada");
                        }
                    break;
                case 6: if(flag3 == 1){
                            registrarDetalles();
                        }else{
                            System.out.println("   * No hay Envios registrados");
                        }
                    break;
                case 7: if(flag3 == 1){
                            actualizacionEstado();
                        }else{
                            System.out.println("   * No hay Envios registrados");
                        }
                    break;
                case 8: if(flag == 1 && flag3 == 1){
                            presentarReportes();
                        }else{
                            System.out.println("   * Faltan datos");
                        }
                    break;
                case 9: break;
            }
  	}while(op < 9);
    }

    private static int leerOpcion() {
        String opciones[]={"Registrar Courier","Registrar Tarifas","Registrar Destinos","Registrar Clientes",
   			"Registrar Envios","Registrar Detalle de envio","Actualizacion de estado","Listar Reportes",
            "Salir"};
        int op;

        for(int i=0;i<opciones.length;i++){

            System.out.println("   ["+(i+1)+"] "+opciones[i]);
        }

	op = leeEntero("	> Opcion : ",1,opciones.length,"		* Opcion no valida");

        return op;
    }
    
    private static int leerReporte(){
	String reportes[]={"Datos registrados","Lista de envios","Listado de Destinos segun tipo",
		"Listado de Objetos segun tipo de Envio","Listado de Consignados segun tipo de Envio",
                "Estadistica de Objetos","Simulacion de boleta","Consultar estado del envio","Retornar"};
        int rep;

        for(int i=0;i<reportes.length;i++){

            System.out.println("   ("+(i+1)+") "+reportes[i]);
        }

	rep = leeEntero(" Opcion : ",1,reportes.length," * Opcion no valida");

        return rep;
    }

    private static int leerDatos(){
	String datos[]={"Datos de la Courier","Listado de Tarifas",
                "Listado de Destinos","Listado de Clientes","Listado de Envios","Retornar"};
        int dat;

        for(int i=0;i<datos.length;i++){

            System.out.println("   ("+(i+1)+") "+datos[i]);
        }

	dat = leeEntero(" Opcion : ",1,datos.length," * Opcion no valida");

        return dat;
    }
    
    private static int leerEstado(){
	String estados[]={"Ruta","Llegada","Cancelar"};
        int estado;

        for(int i=0;i<estados.length;i++){

            System.out.println("	("+(i+1)+") "+estados[i]);
        }

	estado = leeEntero("		Opcion : ",1,estados.length," * Opcion no valida");

        return estado;
    }

    //TIPO DE DESTINO:
    public static int leerTipoDestino(){
	String tipos[]={"Nacional","Internacional"};
        int tipo;

        System.out.println("");

        for(int i=0;i<tipos.length;i++){

            System.out.println("	("+(i+1)+") "+tipos[i]);
        }

        tipo = leeEntero(" > Tipo de destino : ",1,tipos.length," * Tipo no valido");

        return tipo;
    }

    public static Destino crearDestino(int tipo){
	Destino d = null;

        switch(tipo){
            case 1: d = new DestinoNacional(); break;
            case 2: d = new DestinoInternacional(); break;
        }

        return d;
    }

    // TIPO DE ENVIO :
    public static int leerTipoEnvio(){
	String tipos[]={"Regular","E-commerce","Internacional","Eventos","Cancelar"};
        String auxDepartamento;
        int tipo;

        auxDepartamento = uno.getDepartamento();

        System.out.println("");

        for(int i=0;i<tipos.length;i++){
            
            System.out.println("	("+(i+1)+") "+tipos[i]);
        }

        tipo = leeEntero(" > Tipo de envio : ",1,tipos.length," * Tipo no valido");

        if(tipo == 2){

            if("Lima".equals(auxDepartamento)){
                tipo = 5;

                System.out.println("\n * Servicio exclusivo para el departamento de LIMA *");
            }
        }

        return tipo;
    }

    public static Envio crearEnvio(int tipo){
	Envio e = null;

        switch(tipo){
            case 1: e = new EnvioRegular(); break;
            case 2: e = new EnvioEcommerce(); break;
            case 3: e = new EnvioInternacional(); break;
            case 4: e = new EnvioEventos(); break;
        }

        return e;
    }

    public static void registrarCourier() {
        System.out.println("");

        uno.leer();

        System.out.println("\n          * COURIER registrada exitosamente *");
    }

    public static void registrarTarifas() {
        Tarifa tarifa = new Tarifa();

        int flag = 0,flag1 = 0;

        System.out.println("");

	tarifa.leer(flag,flag1);

        if(flag == 0 || flag1 == 0){
            dos.add(tarifa);

            System.out.println("\n     * TARIFA registrada exitosamente *");
        }
    }

    public static void registrarDestinos() {
        Destino destino;

        int tipo;
        
        System.out.println("\n[+---------- NUEVO DESTINO ----------+]");

        tipo = leerTipoDestino();
        destino = crearDestino(tipo);
        destino.leer();
        tres.add(destino);

        System.out.println("\n  * DESTINO registrado exitosamente *");
    }

    public static void registrarClientes() {
        Cliente cliente = new Cliente();

        System.out.println("\n[--------------- Registrar Cliente ---------------]\n");

        cliente.setCodigo(cuatro.size());
        cliente.leer();
        cuatro.add(cliente);

        System.out.println("\n	* CLIENTE registrado exitosamente *");
    }

    public static void registrarEnvios() {
        int tipo,flag = 0,flag1 = 0,dest;

	Envio envio;

        System.out.println("\n[--------------- Registrar Envio ---------------]");

  	tipo = leerTipoEnvio();

        if(tipo != 5){

            if(tipo != 3){

   		dest = 1;

                if(tipo == 2){
                    
                    if(cuatro.isEmpty()){
      			
                        flag1 = 1;
                    }
                }
            }else{

   		dest = 2;
            }

            for(int i=0;i<tres.size();i++){

   		if(tres.get(i).getTipoDestino() == dest){

                    flag = 1;
   		}
            }

            if(flag == 1){

                if(tipo != 2){

                    envio = crearEnvio(tipo);
                    envio.setNumRemito(cinco.size());
                    envio.leer();
                    cinco.add(envio);
		
                    System.out.println("\n		* ENVIO registrado exitosamente *");
                }else{

                    if(flag1 == 1){

                        envio = crearEnvio(tipo);
                        envio.setNumRemito(cinco.size());
                        envio.leer();
                        cinco.add(envio);
                    
                        System.out.println("\n		* ENVIO registrado exitosamente *");
                    }else{

                        System.out.println("\n * No se han registrado clientes");
                    }
                }
            }else{

                System.out.println("\n * No se han registrado destinos del tipo requerido");
            }
        }else{

            System.out.println("	* ENVIO cancelado *");
        }

    }

    public static void registrarDetalles() {
        int auxRemito;

        Envio envio = null;
        Detalle detalle = new Detalle();       

        System.out.println("\n[-------- Registrar Detalle --------]\n");

        auxRemito = leeEntero(" > Nro. de remito[10,000-20,000] : ",10000,20000," * Remito no valido");

        for (int i = 0; i < cinco.size(); i++) {
            
            if(cinco.get(i).getNumRemito() == auxRemito){
                
                envio = cinco.get(i);
            }
        }
        
        List<Detalle> deta = envio.getDetalles();

        System.out.println("");

        if(envio != null){

            detalle.leer();
            deta.add(detalle);

            System.out.println("\n * El DETALLE se registro exitosamente *");
        }else{
            
            System.out.println("\n * No se encontro envio solicitado *");
        }
    }
    
    public static void actualizacionEstado() {
        int auxRemito;
        int nuevoEstado;
        int op;

        Envio envio = null;

        System.out.println("\n[-------- Actualizar Estado --------]\n");

        auxRemito = leeEntero(" > Nro. de remito[10,000-20,000] : ",10000,20000," * Remito no valido");
        
        for (int i = 0; i < cinco.size(); i++) {
            
            if(cinco.get(i).getNumRemito() == auxRemito){
                
                envio = cinco.get(i);
            }
        }
        
        System.out.println("");

        if(envio != null){

            op = envio.getEstado() + 1;

            switch(op){
   		case 1:
                    System.out.println("	(1) Ruta");
                    System.out.println("	(2) Retornar");
                    nuevoEstado = leeEntero(" Opcion : ",1,2," * Opcion no valida");

                    if(nuevoEstado == 1){

         		envio.setfRuta(new Date());
                        envio.setEstado(nuevoEstado);

                        System.out.println("\n  * El estado del envio ha sido actualizado ");
                    }
                    break;

		case 2:
                    System.out.println("	(1) Llegada");
                    System.out.println("	(2) Retornar");
                    nuevoEstado = leeEntero(" Opcion : ",1,2," * Opcion no valida");

                    if(nuevoEstado == 1){

         		envio.setfLlegada(new Date());
                        envio.setEstado(nuevoEstado + 1);

                        System.out.println("\n  * El estado del envio ha sido actualizado");
                    }
                    break;

                case 3:
                    System.out.println("	* No es posible la actualizacion, el envio ha llegado al destino");
                    break;
            }
        }else{

            System.out.println("\n  * El envio solicitado no existe *");          
        }
    }

    public static void presentarReportes() {
        int rep;

	do{
            System.out.println("\n\n[+------------- REPORTES -------------+]");

            rep = leerReporte();

            switch(rep){
   		case 1: datosRegistrados(); break;
                case 2: listaEnvios(); break;
                case 3: listaDestinosSegunTipo(); break;
                case 4: listaObjetosSegunEnvio(); break;
                case 5: listaConsignadosSegunEnvio(); break;
                case 6: estadisticaObjetos(); break;
                case 7: simulacionBoleta(); break;
                case 8: estadoSegunRemito(); break;
                case 9: break;
            }
  	}while(rep < 9);
    }

    public static void datosRegistrados() {
        int dat;

	do{
  	    System.out.println("\n\n\n(----------- DATOS COURIER -----------)");

            dat = leerDatos();

            switch(dat){
   		case 1: courierRegistrada(); break;
                case 2: tarifasRegistradas(); break;
                case 3: destinosRegistrados(); break;
                case 4: clientesRegistrados(); break;
                case 5: enviosRegistrados(); break;
                case 6: break;
            }
  	}while(dat < 6);
    }
    
    public static void courierRegistrada(){

	uno.mostrar();
    }
    
    public static void tarifasRegistradas(){
	Tarifa tarifa;

        System.out.println("\n------------- Listado de Tarifas -------------\n");

        for(int i=0;i<dos.size();i++){
            tarifa = dos.get(i);

            System.out.println("\nTarifa Nro." + (i+1) + " :");

            tarifa.mostrar();
        }

        System.out.println("----------------------------------------------");
    }

    public static void destinosRegistrados(){
        String tipos[] = {"Nacional","Internacional"};
        int tipoDestino;

	Destino destino;

        System.out.println("\n------------- Listado de Destinos ------------");

        for(int i=0;i<tres.size();i++){
            destino = tres.get(i);

            tipoDestino = destino.getTipoDestino();

            System.out.println("Destino Nro." + (i+1) + " (" + tipos[tipoDestino-1] + ") :");

            switch(tipoDestino){
                case 1: ((DestinoNacional )destino).mostrarDestinoNacional();
                    break;
                case 2: ((DestinoInternacional)destino).mostrarDestinoInternacional();
                    break;
            }
        }

        System.out.println("\n----------------------------------------------");
    }

    public static void clientesRegistrados(){
        Cliente cliente;

	System.out.println("\n----------------- Listado de Clientes ----------------");

        if(cuatro.size() != 0){

            for(int i=0;i<cuatro.size();i++){
   		cliente = cuatro.get(i);

      	         System.out.println("Cliente Nro." + (i+1) + " :");

                cliente.mostrar();
            }
        }else{

   	    System.out.println("\n * No hay CLIENTES registrados *");
        }

        System.out.println("\n------------------------------------------------------");
    }

    public static void enviosRegistrados(){
        String tipos[] = {"Regular","E-commerce","Internacional","Eventos"};
        int tipoEnvio;

        Envio envio;

	System.out.println("------------------ Listado de Envios -----------------");

        for(int i=0;i<cinco.size();i++){
            envio = cinco.get(i);

            tipoEnvio = envio.getTipoEnvio();

            System.out.println("\nEnvio Nro." + (i+1) + " (" + tipos[tipoEnvio-1] + ") :");

            switch(tipoEnvio){
                case 1: ((EnvioRegular)envio).mostrarRegular();
                    break;
                case 2: ((EnvioEcommerce)envio).mostrarEcommerce();
                    break;
                case 3: ((EnvioInternacional)envio).mostrarInternacional();
                    break;
                case 4: ((EnvioEventos)envio).mostrarEventos();
                    break;
            }
        }

        System.out.println("\n--------------------------------------------------------");
    }

    public static void listaEnvios() {
        String tipos[] = {"Regular","E-commerce","Internacional","Evento"};
	String nombre;
        String dni;
        String abreviatura = "";
        int tipoEnvio;

        Envio envio;

        //mostrar dni, nombre, tipo de envio y destino
        System.out.println("\n----------------- Listado de Envios -----------------");

        for(int i=0;i<cinco.size();i++){
            envio = cinco.get(i);

            dni = envio.getDni();
            nombre = envio.getNombre();
            tipoEnvio = envio.getTipoEnvio();

            switch(tipoEnvio){
                case 1: abreviatura = ((EnvioRegular)envio).getAbreviatura();
                    break;
                case 2: abreviatura = ((EnvioEcommerce)envio).getAbreviatura();
                    break;
                case 3: abreviatura = ((EnvioInternacional)envio).getAbreviatura();
                    break;
                case 4: abreviatura = ((EnvioEventos)envio).getAbreviatura();
                    break;
            }

            System.out.println("\n  " + (i+1) + ".- " + dni + "   " + nombre + "   "
      		+ tipos[tipoEnvio-1] + "(" + abreviatura + ")");
        }

        System.out.println("\n-----------------------------------------------------");
    }

    public static void listaDestinosSegunTipo() {
        String tipos[] = {"Nacional","Internacional"};
	String auxDestino;
        int n = 0;
        int auxTipo;

        Destino destino;

        System.out.println("");;

        for(int i=0;i<2;i++){

   	        System.out.println("	(" + (i+1) + ") " + tipos[i]);
        }

        auxTipo = leeEntero(" Opcion : ",1,2," * Opcion no valida");

        System.out.println("\n----- Listado de Destinos (" + tipos[auxTipo-1] + ") -----");

        for(int i=0;i<tres.size();i++){
            destino = tres.get(i);

            if(destino.getTipoDestino() == auxTipo){
                auxDestino = destino.getDestino();

                System.out.println("	(" + (n+1) + ") " + auxDestino);
                n++;
            }
        }

        if(n == 0){

            System.out.println("\n * No hay DESTINOS registrados *");
        }

        System.out.println("\n----------------------------------------------");
    }

    public static void listaObjetosSegunEnvio() {
        String tipos[] = {"Regular","E-commerce","Internacional","Eventos"};
	String auxDescripcion;
        double auxPeso;
        int n = 0;
        int auxTipo;

        Envio envio;
        Objeto objeto;

        System.out.println("");

        for(int i=0;i<4;i++){

   	    System.out.println("	(" + (i+1) + ") " + tipos[i]);
        }

        auxTipo = leeEntero(" Opcion : ",1,4," * Opcion no valida");

        System.out.println("\n-------- Listado de Objetos (" + tipos[auxTipo-1] + ") --------");

        for(int i=0;i<cinco.size();i++){
            envio = cinco.get(i);

            if(envio.getTipoEnvio() == auxTipo){
                List<Objeto>  obje = envio.getObjetos();

                for(int j=0;j<obje.size();j++){
                    objeto = obje.get(j);

                    auxDescripcion = objeto.getDescripcion();
                    auxPeso = objeto.getPeso();

                    System.out.println("	" + (n+1) + ".- " + auxDescripcion + "(" + auxPeso + " Kg.)");
                    n++;
                }
            }
        }

        if(n == 0){

            System.out.println("\n * No hay OBJETOS registrados en este tipo*");
        }

        System.out.println("\n--------------------------------------------------");
    }

    public static void listaConsignadosSegunEnvio() {
        String tipos[] = {"Regular","E-commerce","Internacional","Eventos"};
	String auxNombre;
        String auxDNI;
        int n = 0;
        int auxTipo;

        Envio envio;
        Consignado consignado;

        System.out.println("");

        for(int i=0;i<4;i++){

   	    System.out.println("	(" + (i+1) + ") " + tipos[i]);
        }

        auxTipo = leeEntero(" Opcion : ",1,4," * Opcion no valida");

        System.out.println("-------- Listado de Consignados (" + tipos[auxTipo-1] + ") --------");

        for(int i=0;i<cinco.size();i++){
            envio = cinco.get(i);

            if(envio.getTipoEnvio() == auxTipo){
                List<Consignado>  cons = envio.getConsignados();

                for(int j=0;j<cons.size();j++){
                    consignado = cons.get(j);

                    auxDNI = consignado.getDni();
                    auxNombre = consignado.getNombre();

                    System.out.println("	" + (n+1) + ".- " + auxDNI + "   " + auxNombre);
                    n++;
                }
            }
        }

        if(n == 0){

            System.out.println(" * No hay CONSIGNADOS registrados en este tipo*");
        }

        System.out.println("\n----------------------------------------------------");
    }

    public static void estadisticaObjetos() {
        int contador[] = {0,0,0,0};
        int auxTipo;

        Envio envio;

        System.out.println("\n--------- Estadisticas de Objetos --------");

        for(int i=0;i<cinco.size();i++){
            envio = cinco.get(i);

            auxTipo = envio.getTipoEnvio();

            List<Objeto>  obje = envio.getObjetos();

            for(int j=0;j<obje.size();j++){

                contador[auxTipo-1]++;
            }
        }

        System.out.println("	Regular : " + contador[0]);
        System.out.println("	E-commerce : " + contador[1]);
        System.out.println("	Internacional : " + contador[2]);
        System.out.println("	Eventos : " + contador[3]);

        System.out.println("\n------------------------------------------");
    }

    public static void simulacionBoleta() {
        String tipos[] = {"Regular","E-commerce","Internacional","Eventos"};
        String dni;
        String nombre;
        String direccion;
        String telefono;
        String correo;
        String abreviatura = "";
        String dignatario;
        int numRemito;
        int dia,mes,anio;
        int tipoEnvio;
        int hora,minuto,segundo;
        double costo = 0;
        double igv;
        double total;
        double efectivo;
        double vuelto;

        Envio envio = null;

        System.out.println("");
        numRemito = leeEntero(" > Nro. de Remito[10,000-20,000] : ",10000,20000," * Remito no valido");
        for (int i = 0; i < cinco.size(); i++) {
            envio = cinco.get(i);
            
            if(envio.getNumRemito() == numRemito){
                envio = cinco.get(i);
            }
        }        

        if(envio != null){
            dia = envio.getfRegistro().getDay();
            mes = envio.getfRegistro().getMonth() + 1;
            anio = envio.getfRegistro().getYear() + 1900;
            dni = envio.getDni();
            nombre = envio.getNombre();
            direccion = envio.getDireccion();
            telefono = envio.getTelefono();
            correo = envio.getCorreo();
            tipoEnvio = envio.getTipoEnvio();

            switch(tipoEnvio){
                case 1: abreviatura = ((EnvioRegular)envio).getAbreviatura();
            		costo = ((EnvioRegular)envio).getCosto();
                    break;
                case 2: abreviatura = ((EnvioEcommerce)envio).getAbreviatura();
            		costo = ((EnvioEcommerce)envio).getCosto();
                    break;
                case 3: abreviatura = ((EnvioInternacional)envio).getAbreviatura();
            		costo = ((EnvioInternacional)envio).getCosto();
                    break;
                case 4: abreviatura = ((EnvioEventos)envio).getAbreviatura();
            		costo = ((EnvioEventos)envio).getCosto();
                    break;
            }

            igv = costo*0.18;
            total = costo + igv;
            dignatario = envio.getDignatario();
            hora = envio.getfRegistro().getHours();
            minuto = envio.getfRegistro().getMinutes(); 
            segundo = envio.getfRegistro().getSeconds();

   	    System.out.println("\n\n\n");
            System.out.println(" =========================================================\n\n");

            uno.mostrar();
   	    System.out.println("\n    		BOLETA DE VENTA ELECTRONICA");
            System.out.println("    		 B011-" + numRemito + anio + "  " + dia + "/" + mes + "/" + anio);
            System.out.println("\n DNI : " + dni);
            System.out.println(" CLIENTE : " + nombre);
            System.out.println(" DIRECCION : " + direccion);
            System.out.println(" TELEFONO : " + telefono);
            System.out.println(" CORREO : " + correo);
            System.out.println("\n Para el seguimiento de sus envios en la pagina web o");
            System.out.println(" contact center, puede realizarlo mediante el Nro. REMITO:");
            System.out.println(" ---------------------------------------------------------");
            System.out.println(" NRO. REMITO  -  ANIO	DESCRIPCION");
            System.out.println(" ---------------------------------------------------------");
            System.out.println("    " + numRemito + "     -  " + anio + "	" + tipos[tipoEnvio-1] + "(" + abreviatura + ")	  	" + costo);
            System.out.println(" ---------------------------------------------------------");
            System.out.println(" OP. GRAVADA				S/.	" + costo);
            System.out.println(" I.G.V.					S/.	" + igv);
            System.out.println("\n IMPORTE TOTAL				S/.	" + total);
            System.out.println("");
            efectivo = leeReal(" EFECTIVO				S/.	",total,1000.0," ");
            System.out.println("");
            vuelto = efectivo - total;
            System.out.println(" VUELTO					S/.	" + vuelto);
            System.out.println("\n\n DIG.: " + dignatario + "		 HORA: " + hora + ":" + minuto);            
            if(hora>=12){
                System.out.println(" PM");
            }else{
                System.out.println("AM");
            }     
            System.out.println("\n       Representacion impresa de la boleta de venta       ");
            System.out.println("     electronica, esta puede ser consultada en la web     ");
            System.out.println("\n		Gracias por su preferencia");
            System.out.println("\n\n =========================================================");

        }else{

            System.out.println("\n  * El envio solicitado no existe *");
        }
    }

    public static void estadoSegunRemito() {
        int numRemito;
        int diaRegistro,mesRegistro,anioRegistro;
        int diaRuta,mesRuta,anioRuta;
        int diaLlegada,mesLlegada,anioLlegada;
        int diaDetalle,mesDetalle,anioDetalle;
        int horaRegistro,minutoRegistro,segundoRegistro;
        int horaRuta,minutoRuta,segundoRuta;
        int horaLlegada,minutoLlegada,segundoLlegada;
        int horaDetalle,minutoDetalle,segundoDetalle;
        String auxNombre;
        String auxDescripcion;

	Envio envio = null;
        Detalle detalle;

        System.out.println("");
        numRemito = leeEntero(" > Nro. de Remito[10,000-20,000] : ",10000,20000," * Remito no valido");
        for (int i = 0; i < cinco.size(); i++) {
            envio = cinco.get(i);
            
            if(envio.getNumRemito() == numRemito){
                envio = cinco.get(i);
            }
        } 

        if(envio != null){
            diaRegistro = envio.getfRegistro().getDate();
            mesRegistro = envio.getfRegistro().getMonth() + 1; 
            anioRegistro = envio.getfRegistro().getYear() +  1900;
            diaRuta = envio.getfRuta().getDate();
            mesRuta = envio.getfRuta().getMonth() + 1;
            anioRuta = envio.getfRuta().getYear() +  1900;
            diaLlegada = envio.getfLlegada().getDate();
            mesLlegada = envio.getfLlegada().getMonth() + 1; 
            anioLlegada = envio.getfLlegada().getYear() +  1900;
           
            horaRegistro = envio.getfRegistro().getHours();
            minutoRegistro = envio.getfRegistro().getMinutes(); 
            segundoRegistro = envio.getfRegistro().getSeconds();
            horaRuta = envio.getfRuta().getHours();
            minutoRuta = envio.getfRuta().getMinutes();
            segundoRuta = envio.getfRuta().getSeconds();
            horaLlegada = envio.getfLlegada().getHours();
            minutoLlegada = envio.getfLlegada().getMinutes(); 
            segundoLlegada = envio.getfLlegada().getSeconds();

            System.out.println("\n--(REGISTRO)--	---(RUTA)---	--(LLEGADA)--");

            System.out.print("  " + diaRegistro + "/" + mesRegistro + "/" + anioRegistro + "	");
            if(horaRuta > 0){

                System.out.print(" " + diaRuta + "/" + mesRuta + "/" + anioRuta + "	");
            }else{

                System.out.print("    -/-/-	");
            }
            if(horaLlegada > 0){

                System.out.println("  " + diaLlegada + "/" + mesLlegada + "/" + anioLlegada);
            }else{

		System.out.println("   -/-/-");
            }

            System.out.print("   " + horaRegistro + ":" + minutoRegistro + ":" + segundoRegistro + "	");
            if(horaRuta > 0){

                System.out.print("  " + horaRuta + ":" + minutoRuta + ":" + segundoRuta + "	");
            }else{

                System.out.print("    -:-:-	");
            }
            if(horaLlegada > 0){

                System.out.println("   " + horaLlegada + ":" + minutoLlegada + ":" + segundoLlegada);
            }else{

		System.out.println("   -:-:-");
            }

            System.out.println("\n (+)DETALLES:\n");

            List<Detalle> deta = envio.getDetalles();

            if(!(deta.isEmpty())){
                for(int i=0;i<deta.size();i++){
                    detalle = deta.get(i);

                    auxNombre = detalle.getNombre();
                    auxDescripcion = detalle.getDescripcion();
                    diaDetalle = detalle.getfDetalle().getDate();
                    mesDetalle = detalle.getfDetalle().getMonth() + 1;
                    anioDetalle = detalle.getfDetalle().getYear() + 1900;
                    horaDetalle = detalle.getfDetalle().getHours();
                    minutoDetalle = detalle.getfDetalle().getMinutes();
                    segundoDetalle = detalle.getfDetalle().getSeconds();

                    System.out.print(" " + diaDetalle + "/" + mesDetalle + "/" + anioDetalle);
                    System.out.println("	" + auxNombre + ": ");
                    System.out.print(" " + horaDetalle + ":" + minutoDetalle + ":" + segundoDetalle);
                    System.out.println("	" + auxDescripcion);
                    System.out.println("");
                }
            }else{

   		System.out.println("  * Sin DETALLES");
            }
        }else{

            System.out.println("\n  * El Nro. de REMITO solicitado no existe *");
        }
    }
 
}
