
package logica;

import indicadoresEconomicosBCCR.TipoCambio;

import java.util.ArrayList;

import java.lang.Math;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author erick
 * @author dereck
 */
public class Counter {
    
    private String nombre ; 
    private String identificacion ;
    private String direccion ;
    private int numCasilleros;
    private int rangoAscenso;        //Paquetes que debe recibir cliente para ascender de rango
    private String informesDeRetiros;   //Usado en la funcion de la totalidad de retiros
    private int cantInformesDeRetiro;   //mantiene cuantos retiros se van haciendo
    
    /**
     *
     */
    public static Casillero[] listaCasilleros;  //lista de casilleros global
    
    /**
     *
     */
    public static int casilleroAsignado = 1000; //numero de casillero que aumenta conforme se asigna

    /**
     *Constructor
     */
    public Counter(){
        rangoAscenso = 10;      //por default
        informesDeRetiros = "";
        cantInformesDeRetiro = 0;
    }

    /**
     *Constructor
     * @param nombre 
     * @param identificacion
     * @param direccion
     * @param numCasilleros
     */
    public Counter(String nombre, String identificacion, String direccion, int numCasilleros) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.numCasilleros = numCasilleros;
        listaCasilleros= new Casillero[numCasilleros];
        rangoAscenso = 10;
        informesDeRetiros = "";
        cantInformesDeRetiro = 0;
    }
    
    /**
     *Funcion que crea el Counter
     * @param nombre
     * @param identificacion
     * @param direccion
     * @param numCasilleros
     * @return boolean
     */
    public boolean crearCounter(String nombre, String identificacion,String direccion,int numCasilleros){
        if (numCasilleros>0){
            Counter nuevo = new Counter(nombre,identificacion,direccion,numCasilleros); //crea el counter 
            return true;
        }
        else{
            return false;
        }
    }

    /**
     *Devuelve el numero de casilleros
     * @return numCasilleros
     */
    public int getNumCasilleros(){
        return numCasilleros;
    }

    /**
     *Devuelve el nombre del casillero
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *Setea el nombre del casillero
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *Devuelve la identificacion del casillero
     * @return identificacion
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     *Setea la identificacion del casillero
     * @param identificacion
     */
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    /**
     *Retorna la direccion de casillero
     * @return direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     *Setea la direccion del casillero
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    /**
     *Devuelve el largo de los casilleros
     * @return acu 
     */
    public int getSize(){
        int acu = 0;
        int i = 0;
        while(i<listaCasilleros.length){
            if (listaCasilleros[i]!= null){
            acu++;
            i++;
            }
            else
                i++;
                    
        }
        return acu;
    }
    
    /**
     *Devuelve la lista de casilleros
     * @return listaCasilleros
     */
    public static Casillero[] getLista(){
        return listaCasilleros;
    }
    
    /**
     * Agrega el cliente al counter
     * @param name
     * @param id
     * @param mail
     * @param gender
     * @param cellphone
     * @param location
     * @param nacimiento
     * @param rango
     */
    public void addCliente(String name,String id,String mail,String gender,String cellphone,String location,String nacimiento,String rango){
        int largo = listaCasilleros.length;
        Cliente nuevo = new Cliente(name,id,mail,gender,cellphone,location,nacimiento,rango);
        Casillero cas = new Casillero (casilleroAsignado,true,nuevo);
        casilleroAsignado++;
        int cont =0;
        while(cont<largo){
            if (listaCasilleros[cont]== null){  //asigna el espacio en el array que no este nulo
                listaCasilleros[cont] = cas;
                break;
                
            }
            else
                cont++;          
        }        
    }

    /**
     *Verificacion para que no se ingresen dos clientes con la misma cedula
     * @param ced
     * @return flag
     */
    public boolean verificarAddCliente(String ced){
        boolean flag = false;       //verificador por si encuentra una cedula ya ingresada
        int cont =0;
        while(listaCasilleros[cont]!=null){
            if(listaCasilleros[cont].getCliente().getIdentificador().equals(ced)){  //recorre la lista de casilleros
                flag = true;
                break;
            }
            else{
                cont++;
            }
        }
        return flag;    //retorna el resultado
        
        
    }

    /**
     *Modifica el cliente en el counter
     * @param cedula
     * @param datoNuevo
     * @param tipoDato
     * @return boolean
     */
    public boolean modificarCliente(String cedula,String datoNuevo,int tipoDato){      
        Cliente temp = new Cliente();
        int i=0;
        while(listaCasilleros[i]!= null){       //Busca el cliente por medio del ID
            String ced = listaCasilleros[i].getCliente().getIdentificador();
            if (ced.equals(cedula)){
                temp = listaCasilleros[i].getCliente();
                break;
                
            }
            else
                i++;
        }
        switch(tipoDato){                       //Cada tipo de dato tiene un numero de acuerdo al orden del constructor de Cliente
            case 1:{
                temp.setNombre(datoNuevo);      //#1  Nombre
                break;
                
            }
            case 2:{                            //#2 Cedula
                temp.setIdentificador(datoNuevo);
                break;
                
            }
            case 3:{
                temp.setCorreo(datoNuevo);      //#3 Correo
                break;
            }
            case 4:{
                temp.setSexo(datoNuevo);        //#4 Genero
                break;
            }
            case 5:{
                temp.setTelefono(datoNuevo);    //#5 telefono
                break; 
            }
            case 6:{
                temp.setDireccion(datoNuevo);   //#6 direccion
                break;
            }
            case 7:{
                temp.setFechaNacimiento(datoNuevo); //#7 Fecha nacimiento
                break;
            }
            case 8:{
                temp.setTipoCliente(datoNuevo);     //#8 rango de cliente
                break;
            }
        }
        listaCasilleros[i].setCliente(temp); 
        return true;    
    }
    
    /**
     *Muestra la informacion de un cliente
     * @param cedula
     * @return info
     */
    public String consultarCliente(String cedula){
        Cliente temp = new Cliente();
        int i=0;
        while(listaCasilleros[i]!= null){
            String ced = listaCasilleros[i].getCliente().getIdentificador();
            if (ced.equals(cedula)){
                temp = listaCasilleros[i].getCliente();
                break;
                
            }
            else
                i++;
        }
        String name = temp.getNombre();
        String id = temp.getIdentificador();    //Obtiene todos los datos y los asigna
        String genero = temp.getSexo();
        String correo = temp.getCorreo();
        String telefono = temp.getTelefono();
        String nacimiento = temp.getFechaNacimiento();
        String residencia = temp.getDireccion();
        String tipoCliente = temp.getTipoCliente();
        String info = "nombre: " + name + "\n";
        info += "id: " + id + "\n";
        info += "genero: " + genero + "\n";
        info += "correo: " + correo + "\n";
        info += "telefono: " + telefono + "\n";
        info += "nacimiento: " + nacimiento + "\n";
        info += "residencia: " + residencia + "\n";
        info += "tipoCliente: " + tipoCliente + "\n";
        return info;

        
        
        
    }
    
    /**
     *Elimina un cliente del array
     * @param cedula
     * @return true
     */
    public boolean eliminarCliente(String cedula){
        Casillero[] listaAux = new Casillero[listaCasilleros.length];
        int i=0;
        while(listaCasilleros[i]!= null){
            String ced = listaCasilleros[i].getCliente().getIdentificador();    //Ubica al cliente en el casillero
            if (ced.equals(cedula)){
                break;
                
            }
            else
                i++;
        }
        int contador = 0;
        while (contador < i){
            listaAux[contador]= listaCasilleros[contador];  //copia los valores en un array auxiliar hasta el cliente que se quiere quitar
            contador++;
        }
        contador+=1;    //Se salta el cliente
        while (contador < listaCasilleros.length){      //Reajusta el array eliminando el cliente
            listaAux[contador-1]= listaCasilleros[contador];
            contador++;
        }
        listaCasilleros = listaAux; //Le cae encima al array global
        casilleroAsignado--;    //disminuye el casillero asignado
        return true;
    }
    
    /**
     * Lista todos los clientes
     * @return lista
     */
    public String listarClientes(){
        Counter c = new Counter();
        int size = c.getSize();
        int i = 0;
        String lista = "";
        while(i<size){
            Cliente cliente = listaCasilleros[i].getCliente();
            String cedula = cliente.getIdentificador();     //Obtiene ID 
            lista += c.consultarCliente(cedula);
            lista += "---------------------------\n";
            i++;
            
        }
        return lista;
                
    }

    /**
     *Funcion que permite mostrar mensaje en interfaz de cambio de nivel
     * @param cedula
     * @return boolean
     */
    public boolean detectarCambioDeNivel(String cedula){
        int i=0;
        while(listaCasilleros[i]!= null){
            String ced = listaCasilleros[i].getCliente().getIdentificador();    //Busca el casillero asociado
            if (ced.equals(cedula)){
                break; 
            }
            else
                i++;
        }
        if (listaCasilleros[i].getCambioDeNivel()==true)    //Detecta si cambio de nivel al agregar el paquete
            return true;
        else
            return false; 
    }
    
    /**
     *Registra un paquete en el casillero
     * @param cedula
     * @param paquete
     * @return boolean
     */
    public boolean registrarPaquete(String cedula,Paquete paquete){
        Casillero temp = new Casillero();
        int i=0;
        while(listaCasilleros[i]!= null){
            String ced = listaCasilleros[i].getCliente().getIdentificador();    //Busca el casillero asociado
            if (ced.equals(cedula)){
                temp = listaCasilleros[i];
                break;    
            }
            else
                i++;
        } 
        temp.setListaPaquetes(paquete);
        listaCasilleros[i] = temp;
        temp.setCantidadPaquetes(temp.getCantidadPaquetes()+1); //setea la cantidad de paquetes recibidos
        int cant = temp.getCantidadPaquetes();
        if(cant % rangoAscenso == 0 ){     //Cuando los paquetes recibidos es multiplo del rango de ascenso, se sube de nivel
            temp.setCambioDeNivel(true);   //Para poder mostrar en interfaz el mensaje de cambio de nivel
            String rango = temp.getCliente().getTipoCliente();
            if(rango.equals("Normal")||rango.equals("normal")){ //Detecta tanto mayuscula como minuscula
                temp.getCliente().setTipoCliente("Plata");
            }
            if(rango.equals("Plata")||rango.equals("plata")){
                temp.getCliente().setTipoCliente("Oro");
            }
            if(rango.equals("Oro")||rango.equals("oro")){       //Si es oro y detecta un ascenso, se mantiene en oro
                temp.getCliente().setTipoCliente("Oro");
            }  
        }
        else
            temp.setCambioDeNivel(false);   //aqui no cambia de nivel aun
        
        String destino = temp.getCliente().getCorreo();     //para enviar correo
        String descripcion = temp.listarEntregables();
        temp.setCantidadPendientes(1);  //setea cantidad de pendientes
        Correo mail = new Correo();                           
        mail.sendMail(destino, descripcion);
        return true;
        
    }

    /**
     *Funcion que registra un sobre
     * @param cedula
     * @param sobre
     * @return boolean
     */
    public boolean registrarSobre(String cedula,Sobre sobre){
        Casillero temp = new Casillero();
        int i=0;
        while(listaCasilleros[i]!= null){
            String ced = listaCasilleros[i].getCliente().getIdentificador();        //Busca el casillero asociado
            if (ced.equals(cedula)){
                temp = listaCasilleros[i];
                break; 
            }
            else
                i++;
        }
        temp.setListaSobres(sobre);
        listaCasilleros[i] = temp;
        temp.setCantidadPaquetes(temp.getCantidadPaquetes()+1);
        if(temp.getCantidadPaquetes()% rangoAscenso == 0 ){     //Cuando los paquetes recibidos es multiplo del rango de ascenso, se sube de nivel
            temp.setCambioDeNivel(true);   //Para poder mostrar en interfaz el mensaje de cambio de nivel
            String rango = temp.getCliente().getTipoCliente();
            if(rango.equals("Normal")||rango.equals("normal")){
                temp.getCliente().setTipoCliente("Plata");
            }
            if(rango.equals("Plata")||rango.equals("plata")){
                temp.getCliente().setTipoCliente("Oro");
            }
            if(rango.equals("Oro")||rango.equals("oro")){       //Si es oro y detecta un ascenso, se mantiene en oro
                temp.getCliente().setTipoCliente("Oro");
            }
            
        }
        else
            temp.setCambioDeNivel(false);
        String destino = temp.getCliente().getCorreo();
        String descripcion = temp.listarEntregables();      //envio de correo
        temp.setCantidadPendientes(1);
        Correo mail = new Correo();                               
        mail.sendMail(destino, descripcion);
        return true;
        
        
    }

    /**
     *Registra una revista en el casillero
     * @param cedula
     * @param revista
     * @return boolean
     */
    public boolean registrarRevista(String cedula,Revista revista){
        Casillero temp = new Casillero();
        int i=0;
        while(listaCasilleros[i]!= null){
            String ced = listaCasilleros[i].getCliente().getIdentificador();        //busca el casillero asociado
            if (ced.equals(cedula)){
                temp = listaCasilleros[i];
                break;     
            }
            else
                i++;
        }
        temp.setListaRevistas(revista);
        listaCasilleros[i] = temp;
        temp.setCantidadPaquetes(temp.getCantidadPaquetes()+1);
        if(temp.getCantidadPaquetes()% rangoAscenso == 0 ){     //Cuando los paquetes recibidos es multiplo del rango de ascenso, se sube de nivel
            temp.setCambioDeNivel(true);   //Para poder mostrar en interfaz el mensaje de cambio de nivel
            String rango = temp.getCliente().getTipoCliente();
            if(rango.equals("Normal")||rango.equals("normal")){
                temp.getCliente().setTipoCliente("Plata");
            }
            if(rango.equals("Plata")||rango.equals("plata")){
                temp.getCliente().setTipoCliente("Oro");
            }
            if(rango.equals("Oro")||rango.equals("oro")){       //Si es oro y detecta un ascenso, se mantiene en oro
                temp.getCliente().setTipoCliente("Oro");
            } 
        }
        else
            temp.setCambioDeNivel(false);
        String destino = temp.getCliente().getCorreo();
        String descripcion = temp.listarEntregables();
        temp.setCantidadPendientes(1);
        Correo mail = new Correo();                       // envio de correos 
        mail.sendMail(destino, descripcion);
        return true;
    }

    /**
     *Funcion que calcula impuestos del sobre con tipo de cambio actual
     * @param sobre
     * @param moneda
     * @return resul
     */
    public double calcularImpuestoSobre(Sobre sobre,boolean moneda){         //moneda: false si es colones y true si es dolares
        TipoCambio t = new TipoCambio();
        double tipoCambio = t.getCompra();
        String contenido = sobre.getContenido();
        String tipoSobre = sobre.getTipoSobre();
        double resul = 0;
        if(tipoSobre.equals("Aereo")||tipoSobre.equals("aereo")){       //verifica que tipo de sobre es
            if (contenido.equals("Documento")||contenido.equals("documento")){
                resul = 0;
                                                                                //verifica si es articulo o documento
                
            }
            else if(contenido.equals("Articulo")||contenido.equals("articulo")){
                if (moneda==false)      //verifica la moneda
                    resul = tipoCambio;
                else
                    resul = 1; 
            }
            else{
                System.out.println("Error al calcular impuesto, recuerde que contenido es documento o articulo y tipoSobre es aereo o manila");
            }  
        }
        if(tipoSobre.equals( "Manila")||tipoSobre.equals( "manila")){           //verifica tipo de sobre
            if (contenido.equals("Documento")||contenido.equals("documento")){
                if (moneda==false)  
                    resul = tipoCambio;
                else
                    resul = 1;  
            }
            else if(contenido.equals("Articulo")||contenido.equals("articulo")){
                if(moneda==false)           //verifica moneda
                    resul = 2*tipoCambio;
                else
                    resul = 2;
            }
            else{
                System.out.println("Error al calcular impuesto, recuerde que contenido es documento o articulo y tipoSobre es aereo o manila");
            }
            
        }
        return resul;   
    }

    /**
     *Funcion que calcula impuestos del paquete con tipo de cambio actual
     * @param paquete
     * @param moneda
     * @return resul
     */
    public double calcularImpuestoPaquete(Paquete paquete,boolean moneda){
        TipoCambio t = new TipoCambio();
        double tipoCambio = t.getCompra();      //tipo de cambio en tiempo real
        double resul =0;
        boolean electronico = paquete.esElectronico();
        boolean fragil = paquete.esFragil();
        double peso = paquete.getPeso();
        if(fragil && electronico){              //toma en cuenta cuando es fragil y/o electronico
            if(moneda==false)
                resul = (tipoCambio*4)+(peso*0.02);
            else
                resul = 4+(peso*0.02);
            
        }
        if ((fragil&&!electronico) || (!fragil && electronico)){
            if(moneda==false)
                resul = (tipoCambio*2)+(peso*0.02);
            else
                resul = 2+(peso*0.02);
            
        }
        if (!electronico && !fragil ){
            if(moneda==false)
                resul = tipoCambio*(peso*0.02);     //siempre se toma en cuenta el peso en todos los casos
            else
                resul = peso*0.02;
            
        }
        return resul;
        
        
    }
    
    /**
     *Funcion que calcula impuestos del revista con tipo de cambio actual
     * @param revista
     * @param moneda
     * @return res
     */
    public double calcularImpuestoRevista(Revista revista,boolean moneda){
        TipoCambio t = new TipoCambio();
        double tipoCambio = t.getCompra();      //pide tipo de cambio
        boolean tipo = revista.esCatalogo();
        double res ;
        if(tipo)
            res=0;
        else{
            if (moneda == false)
                res = tipoCambio;
            else
                res = 1;            //solo cobra si no es catalogo
        
        }
        return res;
            
               
    }
    
    /**
     *Funcion que calcula el descuento segun el rango
     * @param cedula
     * @return descuento
     */
    public double descuentoClientePaquete(String cedula){        
        Casillero temp = new Casillero();
        Cliente c = new Cliente();
        int i=0;
        double descuento=0;
        while(listaCasilleros[i]!= null){
            String ced = listaCasilleros[i].getCliente().getIdentificador();
            if (ced.equals(cedula)){
                temp = listaCasilleros[i];
                break;
                
            }
            else
                i++;
        }
        c = temp.getCliente();
        String rango = c.getTipoCliente();
        if((rango.equals("Normal"))||rango.equals("normal"))      //Nada descuento para cliente Normal
            descuento = 0;
        
        if((rango.equals("Plata"))||rango.equals("plata")){       //5% descuento para cliente Plata
            
            descuento = 0.05;  
        }
        if((rango.equals("Oro"))||rango.equals("oro")){           //10% descuento para cliente Oro
            
            descuento = 0.10;  
        }
        return descuento;
        
    }
    
    /**
     *
     * @param valor
     */
    public void modificarAscensoDeRango(int valor){     //Por default, se asciende cada 10 paquetes
        rangoAscenso = valor;
        System.out.println("El nuevo valor es:" + valor);
       
    }
    
    /**
     *Funcion que devuelve un array con entregables de acuerdo a los numeros de rastreo
     * @param str
     * @param cedula
     * @return arr
     */
    public ArrayList obtenerEntregablesDeString(String str,String cedula){
        Casillero temp = new Casillero();
        int i=0;
        while(listaCasilleros[i]!= null){
            String ced = listaCasilleros[i].getCliente().getIdentificador();    //ubica el casillero asociado
            if (ced.equals(cedula)){        
                temp = listaCasilleros[i];
                break;              
            }
            else
                i++;
        }
        ArrayList arr = new ArrayList(30);
        int indice =0;
        int largo = str.length();
        String referencia = "";
        ArrayList listaGlobal = temp.getListaEntregables();
        while(indice<=largo){
            if (indice<largo){
                String pba = str.substring(indice,indice+1);        //obtiene el numero de rastreo
                if (!str.substring(indice,indice+1).equals(",")){
                    referencia+=Character.toString(str.charAt(indice));
                    indice++;
                }
                else{
                    indice++;
                    int ind2 = 0;
                    while(listaGlobal.get(ind2)!= null){
                        String tipoObjeto =String.valueOf(listaGlobal.get(ind2).getClass());
                        if(tipoObjeto.equals("class logica.Sobre")){                        //compara si el objeto es tipo Sobre
                            Sobre s = (Sobre)listaGlobal.get(ind2); //realiza un casteo
                            if(String.valueOf(s.getNumReferencia()).equals(referencia)){
                                arr.add(s);     //agrega al array
                                referencia="";
                                break;
                            }
                            else{
                                ind2++;
                            }
                        }
                        if(tipoObjeto.equals("class logica.Revista")){      //compara si el objeto es tipo revista
                            Revista r = (Revista)listaGlobal.get(ind2);     //realiza un casteo
                            if(String.valueOf(r.getNumReferencia()).equals(referencia)){
                                arr.add(r);
                                referencia="";
                                break;
                            }
                            else{
                                ind2++;
                            }
                        }
                        if(tipoObjeto.equals("class logica.Paquete")){      //compara si el objeto es tipo paquete
                            Paquete p = (Paquete)listaGlobal.get(ind2); //hace un casteo
                            if(String.valueOf(p.getNumReferencia()).equals(referencia)){
                                arr.add(p);
                                referencia="";
                                break;
                            }
                            else{
                                ind2++;
                            }
                        }
                    }
                }
            }
            if(indice ==largo){     //recorre solo en el caso final
                indice++;
                    int ind2 = 0;
                    while(listaGlobal.get(ind2)!= null){
                        String tipoObjeto =String.valueOf(listaGlobal.get(ind2).getClass());
                        if(tipoObjeto.equals("class logica.Sobre")){                
                            Sobre s = (Sobre)listaGlobal.get(ind2);
                            if(String.valueOf(s.getNumReferencia()).equals(referencia)){
                                arr.add(s);
                                referencia="";
                                break;
                            }
                            else{
                                ind2++;                                                     //se realiza lo mismo que antes
                            }
                        }
                        if(tipoObjeto.equals("class logica.Revista")){
                            Revista r = (Revista)listaGlobal.get(ind2);
                            if(String.valueOf(r.getNumReferencia()).equals(referencia)){
                                arr.add(r);
                                referencia="";
                                break;
                            }
                            else{
                                ind2++;
                            }
                        }
                        if(tipoObjeto.equals("class logica.Paquete")){
                            Paquete p = (Paquete)listaGlobal.get(ind2);
                            if(String.valueOf(p.getNumReferencia()).equals(referencia)){
                                arr.add(p);
                                referencia="";
                                break;
                            }
                            else{
                                ind2++;
                            }
                        }
                    }
            }
        }
        return arr;   
    }
    
    /**
     *Funcion que retira paquetes del casillero
     * @param arr
     * @param cedula
     * @return resul
     */
    public String retirarPaquetes(ArrayList arr,String cedula){
        int largo = arr.size();
        String resul ="" ;
        int cont =0;
        double totalCol = 0;
        double totalDol = 0;
        Date dNow = new Date( );        //Obtiene fecha para marcar salida del paquete
        Casillero temp = new Casillero();
        int i=0;
        while(listaCasilleros[i]!= null){
            String ced = listaCasilleros[i].getCliente().getIdentificador();        //ubica casillero asociado
            if (ced.equals(cedula)){
                temp = listaCasilleros[i];
                break;  
            }
            else
                i++;
        }
        while (cont<largo){
            String tipoObjeto =String.valueOf(arr.get(cont).getClass());
            resul+="------------------------------------------------\n";
            if(tipoObjeto.equals("class logica.Sobre")){                //compara si el objeto es tipo sobre
                Sobre s = (Sobre)arr.get(cont);             //Hace un casteo
                resul+=s.getDescripcion()+"\n";
                String impuestoColon = String.valueOf(calcularImpuestoSobre(s,false));      //calcula impuestos y descuentos en las dos monedas
                String impuestoDolar = String.valueOf(calcularImpuestoSobre(s,true));
                String descuentoColon =  String.valueOf(Math.round(descuentoClientePaquete(cedula)*calcularImpuestoSobre(s,false)));
                String descuentoDolar = String.valueOf(descuentoClientePaquete(cedula)*calcularImpuestoSobre(s,true));
                s.setImpuestoColon(impuestoColon);      //guarda los valores tambien como atributos en el objeto
                s.setDescuentoColon(descuentoColon);
                s.setImpuestoDolar(impuestoDolar);
                s.setDescuentoDolar(descuentoDolar);
                resul+="Impuesto Colones:\t"+impuestoColon+"\n"+"Descuento Colones:\t"+descuentoColon+"\n"+"Impuesto Dolares:\t"+impuestoDolar+"\n"+"Descuento Dolares:\t"+descuentoDolar+"\n";
                totalCol+=(Double.parseDouble(impuestoColon)-Double.parseDouble(descuentoColon));
                totalDol+=(Double.parseDouble(impuestoDolar)-Double.parseDouble(descuentoDolar));
                resul+="Total Sobre Colones:\t¢"+(String.valueOf((Double.parseDouble(impuestoColon)-Double.parseDouble(descuentoColon))))+"\n";
                resul+="Total Sobre Dolares:\t$"+(String.valueOf((Double.parseDouble(impuestoDolar)-Double.parseDouble(descuentoDolar))))+"\n";
                s.setEstadoEntrega(true);   //Paquete entregado
                SimpleDateFormat date = new SimpleDateFormat ("dd.MM.yyyy");
                SimpleDateFormat hour = new SimpleDateFormat("hh:mm:ss");
                String fechaEntrega = date.format(dNow);        //Marca fecha y hora
                String horaEntrega = hour.format(dNow);
                s.setFechaEntrega(fechaEntrega);
                s.setHoraEntrega(horaEntrega);
                temp.setCantidadPendientes(-1);     //Disminuye pendientes
                cont++;
            }
            if(tipoObjeto.equals("class logica.Paquete")){      //compara si el objeto es tipo paquete
                Paquete p = (Paquete)arr.get(cont);             //Hace un casteo
                resul+=p.getDescripcion()+"\n";
                String impuestoColon = String.valueOf(calcularImpuestoPaquete(p,false));
                String impuestoDolar = String.valueOf(calcularImpuestoPaquete(p,true));
                String descuentoColon =  String.valueOf(Math.round(descuentoClientePaquete(cedula)*calcularImpuestoPaquete(p,false)));
                String descuentoDolar = String.valueOf(descuentoClientePaquete(cedula)*calcularImpuestoPaquete(p,true));        //calcula impuestos
                p.setImpuestoColon(impuestoColon);
                p.setDescuentoColon(descuentoColon);        //setea los valores como atributos
                p.setImpuestoDolar(impuestoDolar);
                p.setDescuentoDolar(descuentoDolar);
                resul+="Impuesto Colones:\t"+impuestoColon+"\n"+"Descuento Colones:\t"+descuentoColon+"\n"+"Impuesto Dolares:\t"+impuestoDolar+"\n"+"Descuento Dolares:\t"+descuentoDolar+"\n"; 
                totalCol+=(Double.parseDouble(impuestoColon)-Double.parseDouble(descuentoColon));
                totalDol+=(Double.parseDouble(impuestoDolar)-Double.parseDouble(descuentoDolar));
                resul+="Total Paquete Colones:\t¢"+(String.valueOf((Double.parseDouble(impuestoColon)-Double.parseDouble(descuentoColon))))+"\n";
                resul+="Total Paquete Dolares:\t$"+(String.valueOf((Double.parseDouble(impuestoDolar)-Double.parseDouble(descuentoDolar))))+"\n";
                p.setEstadoEntrega(true);       //Paquete Entregado
                SimpleDateFormat date = new SimpleDateFormat ("dd.MM.yyyy");
                SimpleDateFormat hour = new SimpleDateFormat("hh:mm:ss");
                String fechaEntrega = date.format(dNow);        //Marca fecha y hora
                String horaEntrega = hour.format(dNow);
                p.setFechaEntrega(fechaEntrega);            
                p.setHoraEntrega(horaEntrega);
                temp.setCantidadPendientes(-1);     //disminuye pendientes
                cont++;
                
            }
            if(tipoObjeto.equals("class logica.Revista")){          //compara si el objeto es tipo revista
                Revista r = (Revista)arr.get(cont);             //Hice un casteo
                resul+=r.getDescripcion()+"\n";
                String impuestoColon = String.valueOf(calcularImpuestoRevista(r,false));
                String impuestoDolar = String.valueOf(calcularImpuestoRevista(r,true));
                String descuentoColon =  String.valueOf(Math.round(descuentoClientePaquete(cedula)*calcularImpuestoRevista(r,false)));
                String descuentoDolar = String.valueOf(descuentoClientePaquete(cedula)*calcularImpuestoRevista(r,true));        //calcula impuestos
                r.setImpuestoColon(impuestoColon);
                r.setDescuentoColon(descuentoColon);        //setea los valores como atributos
                r.setImpuestoDolar(impuestoDolar);
                r.setDescuentoDolar(descuentoDolar);
                resul+="Impuesto Colones:\t"+impuestoColon+"\n"+"Descuento Colones:\t"+descuentoColon+"\n"+"Impuesto Dolares:\t"+impuestoDolar+"\n"+"Descuento Dolares:\t"+descuentoDolar+"\n"; 
                totalCol+=(Double.parseDouble(impuestoColon)-Double.parseDouble(descuentoColon));
                totalDol+=(Double.parseDouble(impuestoDolar)-Double.parseDouble(descuentoDolar));
                resul+="Total Revista Colones:\t¢"+(String.valueOf((Double.parseDouble(impuestoColon)-Double.parseDouble(descuentoColon))))+"\n";
                resul+="Total Revista Dolares:\t$"+(String.valueOf((Double.parseDouble(impuestoDolar)-Double.parseDouble(descuentoDolar))))+"\n";
                r.setEstadoEntrega(true);      //Paquete Entregado
                SimpleDateFormat date = new SimpleDateFormat ("dd.MM.yyyy");
                SimpleDateFormat hour = new SimpleDateFormat("hh:mm:ss");
                String fechaEntrega = date.format(dNow);        //Marca fecha y hora
                String horaEntrega = hour.format(dNow);
                r.setFechaEntrega(fechaEntrega);
                r.setHoraEntrega(horaEntrega);
                temp.setCantidadPendientes(-1);     //disminuye pendientes
                cont++;
                
            }
            
        }
        resul+="*************************************************\n";
        resul+="\nTotal Final Colones:\t¢"+String.valueOf(totalCol)+"\nTotal Final Dolares:\t$"+String.valueOf(totalDol)+"\n";
        cantInformesDeRetiro++;             //aumenta informes de retiro, esto para otea funcion
        informesDeRetiros+="\nInforme de retiro "+String.valueOf(cantInformesDeRetiro)+"\n"+resul;  //esto tambien para otra funcion
        return resul;  
    }
    
    /**
     *Da una lista de los entregables de un cliente
     * @param cedula
     * @return resul
     */
    public String listaEntregablesPendientes(String cedula){
        Cliente temp = new Cliente();
        int i=0;
        while(listaCasilleros[i]!= null){
            String ced = listaCasilleros[i].getCliente().getIdentificador();        //busca el casillero asociado
            if (ced.equals(cedula)){
                temp = listaCasilleros[i].getCliente();
                break;  
            }
            else
                i++;
        }
        String resul ="Lista de Entregables Pendientes para "+temp.getNombre()+":\n";
        Casillero cas = listaCasilleros[i];
        resul+="Paquetes:\n";
        int cont = 0;
        ArrayList array = cas.getListaEntregables();        //agrego a lista global de entregables para no hacer otra funcion
        cas.resetInformeEstado();
        cas.setInformeEstado("Informe de Estado de Casillero:\n------------------------------\n\n");      //Esto es usado en otra funcion adelante, no aqui
        while(cas.getListaPaquetes()[cont]!= null){
            Paquete paq = cas.getListaPaquetes()[cont]; 
            array.add(paq);
            if (paq.getEstadoEntrega()==false){
                cas.setInformeEstado("Paquete:"+paq.getDescripcion()+"\nEstado:\t"+"Pendiente de retiro\n\n");//Esto es usado en otra funcion adelante, no aqui
                resul+="-"+paq.getDescripcion()+"\n"+"Referencia:"+String.valueOf(paq.getNumReferencia())+"\n";
                cont++;
            }
            else{
                cas.setInformeEstado("Paquete:"+paq.getDescripcion()+"\nEstado:\t"+"Entregado\n\n");
                cont++;
            }
        }
        cont = 0;
        resul+="Sobres:\n";
        while(cas.getListaSobres()[cont]!= null){       //busca si hay sobres
            Sobre s = cas.getListaSobres()[cont];
           
            array.add(s);
            if (s.getEstadoEntrega()==false){
                cas.setInformeEstado("Sobre:"+s.getDescripcion()+"\nEstado:\t"+"Pendiente de retiro\n\n");
                resul+="-"+s.getDescripcion()+"\n"+"Referencia:"+String.valueOf(s.getNumReferencia())+"\n";
                cont++;
            }
            else{
                cas.setInformeEstado("Sobre:\t"+s.getDescripcion()+"\nEstado:\t"+"Entregado\n\n");
                cont++;
            }
        }
        cont =0;
        while(cas.getListaRevistas()[cont]!= null){         //busca si hay revistas
            Revista r = cas.getListaRevistas()[cont];
            
            array.add(r);
            if (r.getEstadoEntrega()==false){
                cas.setInformeEstado("Revista:"+r.getDescripcion()+"\nEstado:\t"+"Pendiente de retiro\n\n");
                resul+="-"+r.getDescripcion()+"\n"+"Referencia:"+String.valueOf(r.getNumReferencia())+"\n";
                cont++;
            }
            else{
                cas.setInformeEstado("Revista:\t"+r.getDescripcion()+"\nEstado:\t"+"Entregado\n\n");
                cont++;
            }
        }
        return resul;
    }
    
    /**
     *Devuelve un string con el estado de un casillero de un cliente
     * @param num
     * @return resul
     */
    public String estadoCasillero(String num){       //Puede consultarse por cedula o numCasillero
        int cont = 0;
        String resul = "";
        if (num.length() == 4){          //Osea es un numero de casillero
            while(listaCasilleros[cont]!=null){
                if (String.valueOf(listaCasilleros[cont].getNumero()).equals(num)){
                    break;
                }
                else{
                    cont++;
                }
            }
            Casillero cas = listaCasilleros[cont];
            Counter c = new Counter();
            String ced = cas.getCliente().getIdentificador();
            c.listaEntregablesPendientes(ced);
            resul+=cas.getInformeEstado();          //obtiene el atributo de estado de casillero ya generado anteriormente y lo concatena
        }
        else{
            int i=0;
            while(listaCasilleros[i]!= null){
                String ced = listaCasilleros[i].getCliente().getIdentificador();
                if (ced.equals(num)){           
                    break;              
                }
                else                            //misma funcion solo que busca con cedula
                    i++;
            }
            Casillero cas = listaCasilleros[cont];
            Counter c = new Counter();
            String ced = cas.getCliente().getIdentificador();
            c.listaEntregablesPendientes(ced);
            resul+=cas.getInformeEstado();
        }
        return resul;
    }
    
    /**
     *Funcion que busca los articulos recibidos en una fecha
     * @param fecha
     * @return resul
     */
    public String detalleRecibidosPorFecha(String fecha){
        String resul = "Articulos recibidos el "+fecha+"\n";
        if(fecha.length() != 10 ){      //validacion de fecha
            return "Error, el formato de fecha debe ser dd.mm.yyyy";
        }
        else{
            int cont =0;
            while(listaCasilleros[cont]!= null){        //itera en todos los casilleros
                Casillero cas = listaCasilleros[cont];
                Counter count = new Counter();
                cas.resetListaEntregables();
                count.listaEntregablesPendientes(cas.getCliente().getIdentificador());
                int index = 0;
                ArrayList arr = cas.getListaEntregables();      //obtiene lista de entregables totales
                while(index<arr.size()){
                    String tipoObjeto =String.valueOf(arr.get(index).getClass());
                    if(tipoObjeto.equals("class logica.Sobre")){            //verifica si el objeto es tipo sobre
                        Sobre s = (Sobre)arr.get(index);                    //casteo
                        if (s.getFechaRecibido().equals(fecha)){
                            resul+="-"+s.getDescripcion()+"\n";
                            index++;
                        }
                        else{
                            index++;
                        }
                    }
                    if(tipoObjeto.equals("class logica.Paquete")){      //verifica si es tipo paquete
                        Paquete p = (Paquete)arr.get(index);            //casteo
                        if (p.getFechaRecibido().equals(fecha)){
                            resul+="-"+p.getDescripcion()+"\n";
                            index++;
                        }
                        else{
                            index++;
                        }
                    }
                    if(tipoObjeto.equals("class logica.Revista")){      //verifica si es tipo revista
                        Revista r = (Revista)arr.get(index);            //casteo
                        if (r.getFechaRecibido().equals(fecha)){
                            resul+="-"+r.getDescripcion()+"\n";
                            index++;
                        }
                        else{
                            index++;
                        }
                    }   
                }
                cont++;
            }
            return resul;
        }
    }

    /**
     *Funcion que lista los articulos entregados en una fecha
     * @param fecha
     * @return resul
     */
    public String detalleEntregadosPorFecha(String fecha){
        String resul = "Articulos entregados el "+fecha+"\n";
        if(fecha.length() != 10 ){
            return "Error, el formato de fecha debe ser dd.mm.yyyy";
        }
        else{
            int cont =0;
            while(listaCasilleros[cont]!= null){
                Casillero cas = listaCasilleros[cont];
                int index = 0;
                ArrayList arr = cas.getListaEntregables();      //obtiene lista de entregables totales
                while(index<arr.size()){
                    String tipoObjeto =String.valueOf(arr.get(index).getClass());
                    if(tipoObjeto.equals("class logica.Sobre")){        //verifica si es tipo sobre
                        Sobre s = (Sobre)arr.get(index);
                        if (s.getFechaEntrega().equals(fecha)){     //compara fecha entrega
                            resul+="-"+s.getDescripcion()+"\n";
                            index++;
                        }
                        else{
                            index++;
                        }
                    }
                    if(tipoObjeto.equals("class logica.Paquete")){      //verifica si es tipo paquete
                        Paquete p = (Paquete)arr.get(index);
                        if (p.getFechaEntrega().equals(fecha)){
                            resul+="-"+p.getDescripcion()+"\n";
                            index++;
                        }
                        else{
                            index++;
                        }
                    }
                    if(tipoObjeto.equals("class logica.Revista")){      //verifica si es tipo revista
                        Revista r = (Revista)arr.get(index);
                        if (r.getFechaEntrega().equals(fecha)){
                            resul+="-"+r.getDescripcion()+"\n";
                            index++;
                        }
                        else{
                            index++;
                        }
                    }
                       
                }
                cont++;
                
            }
            return resul;
        }
        
    }
    
    /**
     *Da una lista de los clientes con articulos pendientes
     * @return resul
     */
    public String  listaClientesConPendientes(){
        String resul="Clientes con articulos pendientes"+"\n\n";
        int cont = 0;
        while(listaCasilleros[cont]!=null){     //itera en los casilleros
            Casillero cas = listaCasilleros[cont];
            if (cas.getCantidadPendientes() != 0){      //busca si tiene 1 o mas pendientes
                Cliente cl = cas.getCliente();
                resul+="Nombre:"+cl.getNombre()+"\nID:"+cl.getIdentificador()+"\nCorreo:"+cl.getCorreo()+"\nTelefono:"+cl.getTelefono();
                resul+="\nArticulos Pendientes:"+String.valueOf(cas.getCantidadPendientes())+"\n"+"****************************\n";
                cont++;
            }
            else
                cont++;    
        }
        return resul;  
    }

    /**
     *Genera un reporte de contabilidad en una fecha
     * @param fecha
     * @return resul
     */
    public String reporteContable(String fecha){
        double totalImpuestosColones = 0;
        double totalImpuestosDolares = 0;
        double totalDescuentosColones = 0;
        double totalDescuentosDolares = 0;
        double totalFinalColones =0;
        double totalFinalDolares=0;
        String resul ="Reporte contable para el dia "+fecha+"\n---------------------------------------\n";
        int cont=0;
        while(listaCasilleros[cont]!=null){
            Casillero cas = listaCasilleros[cont];
            Cliente cl = cas.getCliente();
            int index=0;
            ArrayList arr = cas.getListaEntregables();      //obtiene lista de entregables
            while(index<arr.size()){
                String tipoObjeto =String.valueOf(arr.get(index).getClass());
                    if(tipoObjeto.equals("class logica.Sobre")){        //verifica si es tipo sobre
                        Sobre s = (Sobre)arr.get(index);
                        if (s.getFechaEntrega().equals(fecha)){
                            double impCol = Double.parseDouble(s.getImpuestoColon());
                            totalImpuestosColones+=impCol;
                            double desCol= Double.parseDouble(s.getDescuentoColon());
                            totalDescuentosColones+=desCol;
                            double impDol = Double.parseDouble(s.getImpuestoDolar());
                            totalImpuestosDolares+=impDol;
                            double desDol= Double.parseDouble(s.getDescuentoDolar());
                            totalDescuentosDolares+=desDol;
                            double impTotalCol = impCol-desCol;
                            totalFinalColones+=impTotalCol;
                            double impTotalDol = impDol-desDol;
                            totalFinalDolares+=impTotalDol;         //realiza las sumatorias del reporte con desglose 
                            totalFinalColones+=impCol;
                            totalFinalDolares+=impDol;
                            index++;
                        }
                        else{
                            index++;
                        }
                    }
                    if(tipoObjeto.equals("class logica.Paquete")){      //verifica si es tipo paquete
                        Paquete p = (Paquete)arr.get(index);
                        if (p.getFechaEntrega().equals(fecha)){
                            double impCol = Double.parseDouble(p.getImpuestoColon());
                            totalImpuestosColones+=impCol;
                            double desCol= Double.parseDouble(p.getDescuentoColon());
                            totalDescuentosColones+=desCol;
                            double impDol = Double.parseDouble(p.getImpuestoDolar());
                            totalImpuestosDolares+=impDol;
                            double desDol= Double.parseDouble(p.getDescuentoDolar());
                            totalDescuentosDolares+=desDol;
                            double impTotalCol = impCol-desCol;
                            totalFinalColones+=impTotalCol;
                            double impTotalDol = impDol-desDol;     //se hacen las sumatorias del reporte con desglose
                            totalFinalDolares+=impTotalDol;
                            totalFinalColones+=impCol;
                            totalFinalDolares+=impDol;
                            index++;
                        }
                        else{
                            index++;
                        }
                    }
                    if(tipoObjeto.equals("class logica.Revista")){      //verifica si es tipo revista
                        Revista r = (Revista)arr.get(index);
                        if (r.getFechaEntrega().equals(fecha)){
                            double impCol = Double.parseDouble(r.getImpuestoColon());
                            totalImpuestosColones+=impCol;
                            double desCol= Double.parseDouble(r.getDescuentoColon());
                            totalDescuentosColones+=desCol;
                            double impDol = Double.parseDouble(r.getImpuestoDolar());
                            totalImpuestosDolares+=impDol;
                            double desDol= Double.parseDouble(r.getDescuentoDolar());
                            totalDescuentosDolares+=desDol;
                            double impTotalCol = impCol-desCol;
                            totalFinalColones+=impTotalCol;
                            double impTotalDol = impDol-desDol;
                            totalFinalDolares+=impTotalDol;     //se hacen las sumatorias del reporte con desglose
                            totalFinalColones+=impCol;
                            totalFinalDolares+=impDol;
                            index++;
                        }
                        else{
                            index++;
                        }
                    }
            }
            cont++;
        }
        resul+="\nImpuestos recaudados:\n-Colones:"+totalImpuestosColones+"\n-Dolares:"+totalImpuestosDolares;      //Sumas totales
        resul+="\n\nDescuentos Aplicados:\n-Colones:"+totalDescuentosColones+"\n-Dolares:"+totalDescuentosDolares;
        resul+="\n\nTotal Final:\n-Colones:"+totalFinalColones+"\n-Dolares:"+totalFinalDolares+"\n*****************************************\n";
        resul+="Nota: Los montos en dolares son la conversion del monto en colones y no una cantidad aparte";
        return resul;
    }
    
    /**
     *Lista todos los paquetes pendientes globales
     * @return resul
     */
    public String listarPendientesTotales(){
        int cont =0;
        String resul = "";
        while (listaCasilleros[cont]!=null){        //itera entre los casilleros
            Casillero cas = listaCasilleros[cont];
            String cedula = cas.getCliente().getIdentificador();
            resul+="\n******************************************\n"+listaEntregablesPendientes(cedula); //lista los pendientes de cada casillero
            cont++;
        }
        return resul;
       
    }

    /**
     *  envia el correo a los clientes que tienen articulos pendientes
     */
    public void enviarCorreoAPendientes(){
        int cont =0;
        while(listaCasilleros[cont]!=null){
            Casillero cas = listaCasilleros[cont];
            if(cas.getCantidadPendientes()!=0){     //verifica si tiene pendientes
                String destino = cas.getCliente().getCorreo();
                String descripcion = cas.listarPendientes();
                Correo mail = new Correo();                       
                mail.sendMail(destino, descripcion);        //manda correo con pendientes
                cont++;       
            }
            else{
                cont++;
                
            }
        }
    }
        
    /**
     *Muestra todos los retiros realizados hasta la fecha con su desglose
     * @return el detalle de los retiros
     */
    public String detalleDeRetiros(){  
        return informesDeRetiros;
    }
    
    /**
     * obtiene el numero de un casillero para validacion en interfaz
     * @param cedula
     * @return numero
     */
        
    public String numeroDeCasillero(String cedula){
        int i=0;
        while(listaCasilleros[i]!= null){
            String ced = listaCasilleros[i].getCliente().getIdentificador();        //busca con la cedula el casillero
            if (ced.equals(cedula)){
                break;  
            }
            else
                i++;
        }
        Casillero cas = listaCasilleros[i];
        String numero = String.valueOf(cas.getNumero());        //devuelve el atributo de numero de casillero
        return numero;
        
    }
    
    /**
     * valida el correo electronico de un cliente
     * @param mail
     * @return true o false
     */
    public boolean validarCorreo(String mail){
        boolean contains = false;
        char[] arrayInvalidos = new char[]{'(',')','<','>',',',';',':','[',']','%','&',' ','"','$','#','!','*','=','{','}','?','/'};    //caracteres invalidos
        int indexA =0;
        int indexCh=0;
        while(indexCh<mail.length()){
            char comp = mail.charAt(indexCh);
            while(indexA<arrayInvalidos.length){
                if (arrayInvalidos[indexA]==comp){
                    contains = true;        //booleano que indica que SI tiene un caracter invalido
                    break;
                    
                }
                else
                    indexA++;
            }
            indexCh++;
            indexA = 0;
        }
        
        if (contains == false && contadorApariciones(mail,'@')==1){ //si no tiene caracter invalido y si solo tiene 1 arroba
            return true;
            
        }
        else
            return false;
    }
    /**
     * cuenta las apariciones de un caracter en un string
     * @param str
     * @param c
     * @return apariciones
     */
    public int contadorApariciones(String str,char c){
        int apariciones = 0;
        int ind = 0;
        while(ind<str.length()){
            char c2 = str.charAt(ind);      //indexa el string por caracteres
            if (c == c2){       //compara si es igual al buscado
                apariciones++;
                ind++;
            }
            else
                ind++;
        }
        return apariciones;
    }    
        
        
     
//Fin                 
}