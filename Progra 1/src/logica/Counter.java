
package logica;

import indicadoresEconomicosBCCR.TipoCambio;

import java.util.ArrayList;

import java.lang.Math;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author erick
 */
public class Counter {
    
    private String nombre ; 
    private String identificacion ;
    private String direccion ;
    private int numCasilleros;
    private int rangoAscenso;        //Paquetes que debe recibir cliente para ascender de rango
    private String informesDeRetiros;
    private int cantInformesDeRetiro;
    
    /**
     *
     */
    public static Casillero[] listaCasilleros;
    
    /**
     *
     */
    public static int casilleroAsignado = 1000;

    /**
     *
     */
    public Counter(){
        rangoAscenso = 10;
        informesDeRetiros = "";
        cantInformesDeRetiro = 0;
    }

    /**
     *
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
     *
     * @param nombre
     * @param identificacion
     * @param direccion
     * @param numCasilleros
     * @return
     */
    public boolean crearCounter(String nombre, String identificacion,String direccion,int numCasilleros){
        Counter nuevo = new Counter(nombre,identificacion,direccion,numCasilleros);
        
        return true;
        
        
    }

    /**
     *
     * @return
     */
    public int getNumCasilleros(){
        return numCasilleros;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     *
     * @param identificacion
     */
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    /**
     *
     * @return
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     *
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    /**
     *
     * @return
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
     *
     * @return
     */
    public static Casillero[] getLista(){
        return listaCasilleros;
    }
    
    /**
     *
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
        while(cont<largo-1){
            if (listaCasilleros[cont]== null){
                listaCasilleros[cont] = cas;
                break;
                
            }
            else
                cont++;
                    
        }        
    }

    /**
     *
     * @param ced
     * @return
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
     *
     * @param cedula
     * @param datoNuevo
     * @param tipoDato
     * @return
     */
    public boolean modificarCliente(String cedula,String datoNuevo,int tipoDato){      
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
     *
     * @param cedula
     * @return
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
        String id = temp.getIdentificador();
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
        //System.out.println(info);
        return info;

        
        
        
    }
    
    /**
     *
     * @param cedula
     * @return
     */
    public boolean eliminarCliente(String cedula){
        Casillero[] listaAux = new Casillero[listaCasilleros.length];
        int i=0;
        while(listaCasilleros[i]!= null){
            String ced = listaCasilleros[i].getCliente().getIdentificador();
            if (ced.equals(cedula)){
                break;
                
            }
            else
                i++;
        }
        int contador = 0;
        while (contador < i){
            listaAux[contador]= listaCasilleros[contador];
            contador++;
        }
        contador+=1;
        while (contador < listaCasilleros.length){
            listaAux[contador-1]= listaCasilleros[contador];
            contador++;
        }
        listaCasilleros = listaAux;
        casilleroAsignado--;
        
        
        
        return true;
         
        
    }
    
    /**
     *
     * @return
     */
    public String listarClientes(){
        Counter c = new Counter();
        int size = c.getSize();
        int i = 0;
        String lista = "";
        
        while(i<size){
            Cliente cliente = listaCasilleros[i].getCliente();
            String cedula = cliente.getIdentificador();
            lista += c.consultarCliente(cedula);
            lista += "---------------------------\n";
            i++;
            
        }
        return lista;
                
    }

    /**
     *
     * @param cedula
     * @return
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
     *
     * @param cedula
     * @param paquete
     * @return
     */
    public boolean registrarPaquete(String cedula,Paquete paquete){
        Casillero temp = new Casillero();
        int i=0;
        while(listaCasilleros[i]!= null){
            String ced = listaCasilleros[i].getCliente().getIdentificador();
            if (ced.equals(cedula)){
                temp = listaCasilleros[i];
                break;    
            }
            else
                i++;
        } 
        temp.setListaPaquetes(paquete);
        listaCasilleros[i] = temp;
        temp.setCantidadPaquetes(temp.getCantidadPaquetes()+1);
        int cant = temp.getCantidadPaquetes();
        if(cant % rangoAscenso == 0 ){     //Cuando los paquetes recibidos es multiplo del rango de ascenso, se sube de nivel
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
            temp.setCambioDeNivel(false);   //aqui no cambia de nivel aun
        
        String destino = temp.getCliente().getCorreo();
        String descripcion = temp.listarEntregables();
        temp.setCantidadPendientes(1);
        //Correo mail = new Correo();                           //Deshabilite el envio de correos para que no envie en cada corrida
        //mail.sendMail(destino, descripcion);
        
        return true;
        
    }

    /**
     *
     * @param cedula
     * @param sobre
     * @return
     */
    public boolean registrarSobre(String cedula,Sobre sobre){
        Casillero temp = new Casillero();
        int i=0;
        while(listaCasilleros[i]!= null){
            String ced = listaCasilleros[i].getCliente().getIdentificador();
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
        String descripcion = temp.listarEntregables();
        temp.setCantidadPendientes(1);
        //Correo mail = new Correo();                               //Deshabilite el envio de correos para que no envie en cada corrida
        //mail.sendMail(destino, descripcion);
        return true;
        
        
    }

    /**
     *
     * @param cedula
     * @param revista
     * @return
     */
    public boolean registrarRevista(String cedula,Revista revista){
        Casillero temp = new Casillero();
        int i=0;
        while(listaCasilleros[i]!= null){
            String ced = listaCasilleros[i].getCliente().getIdentificador();
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
        //Correo mail = new Correo();                       //Deshabilite el envio de correos para que no envie en cada corrida
        //mail.sendMail(destino, descripcion);
        //System.out.println("Revista agregada al casillero!");
        return true;
    }

    /**
     *
     * @param sobre
     * @param moneda
     * @return
     */
    public double calcularImpuestoSobre(Sobre sobre,boolean moneda){         //moneda: false si es colones y true si es dolares
        TipoCambio t = new TipoCambio();
        double tipoCambio = t.getCompra();
        String contenido = sobre.getContenido();
        String tipoSobre = sobre.getTipoSobre();
        double resul = 0;
        if(tipoSobre.equals("Aereo")||tipoSobre.equals("aereo")){
            if (contenido.equals("Documento")||contenido.equals("documento")){
                resul = 0;
                
                
            }
            else if(contenido.equals("Articulo")||contenido.equals("articulo")){
                if (moneda==false)
                    resul = tipoCambio;
                else
                    resul = 1; 
            }
            else{
                System.out.println("Error al calcular impuesto, recuerde que contenido es documento o articulo y tipoSobre es aereo o manila");
            }  
        }
        if(tipoSobre.equals( "Manila")||tipoSobre.equals( "manila")){
            if (contenido.equals("Documento")||contenido.equals("documento")){
                if (moneda==false)
                    resul = tipoCambio;
                else
                    resul = 1;  
            }
            else if(contenido.equals("Articulo")||contenido.equals("articulo")){
                if(moneda==false)
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
     *
     * @param paquete
     * @param moneda
     * @return
     */
    public double calcularImpuestoPaquete(Paquete paquete,boolean moneda){
        TipoCambio t = new TipoCambio();
        double tipoCambio = t.getCompra();      //tipo de cambio en tiempo real
        double resul =0;
        boolean electronico = paquete.esElectronico();
        boolean fragil = paquete.esFragil();
        double peso = paquete.getPeso();
        if(fragil && electronico){
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
                resul = tipoCambio*(peso*0.02);
            else
                resul = peso*0.02;
            
        }
        return resul;
        
        
    }
    
    /**
     *
     * @param revista
     * @param moneda
     * @return
     */
    public double calcularImpuestoRevista(Revista revista,boolean moneda){
        TipoCambio t = new TipoCambio();
        double tipoCambio = t.getCompra();
        boolean tipo = revista.esCatalogo();
        double res ;
        if(tipo)
            res=0;
        else{
            if (moneda == false)
                res = tipoCambio;
            else
                res = 1;
        
        }
        return res;
            
               
    }
    
    /**
     *
     * @param cedula
     * @return
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
     *
     * @param str
     * @param cedula
     * @return
     */
    public ArrayList obtenerEntregablesDeString(String str,String cedula){
        Casillero temp = new Casillero();
        int i=0;
        while(listaCasilleros[i]!= null){
            String ced = listaCasilleros[i].getCliente().getIdentificador();
            if (ced.equals(cedula)){
                temp = listaCasilleros[i];
                break;              
            }
            else
                i++;
        }
        ArrayList arr = new ArrayList(15);
        int indice =0;
        int largo = str.length();
        String referencia = "";
        ArrayList listaGlobal = temp.getListaEntregables();
        while(indice<=largo){
            if (indice<largo){
                String pba =str.substring(indice,indice+1);
                if (!str.substring(indice,indice+1).equals(",")){
                    referencia+=Character.toString(str.charAt(indice));
                    indice++;
                }
                else{
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
                                ind2++;
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
            if(indice ==largo){
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
                                ind2++;
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
     *
     * @param arr
     * @param cedula
     * @return
     */
    public String retirarPaquetes(ArrayList arr,String cedula){
        int largo = arr.size();
        String resul ="" ;
        int cont =0;
        double totalCol = 0;
        double totalDol = 0;
        Date dNow = new Date( );
        Casillero temp = new Casillero();
        int i=0;
        while(listaCasilleros[i]!= null){
            String ced = listaCasilleros[i].getCliente().getIdentificador();
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
            if(tipoObjeto.equals("class logica.Sobre")){
                Sobre s = (Sobre)arr.get(cont);             //Hice un casteo
                resul+=s.getDescripcion()+"\n";
                String impuestoColon = String.valueOf(calcularImpuestoSobre(s,false));
                String impuestoDolar = String.valueOf(calcularImpuestoSobre(s,true));
                String descuentoColon =  String.valueOf(Math.round(descuentoClientePaquete(cedula)*calcularImpuestoSobre(s,false)));
                String descuentoDolar = String.valueOf(descuentoClientePaquete(cedula)*calcularImpuestoSobre(s,true));
                s.setImpuestoColon(impuestoColon);
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
                temp.setCantidadPendientes(-1);
                cont++;
            }
            if(tipoObjeto.equals("class logica.Paquete")){
                Paquete p = (Paquete)arr.get(cont);             //Hice un casteo
                resul+=p.getDescripcion()+"\n";
                String impuestoColon = String.valueOf(calcularImpuestoPaquete(p,false));
                String impuestoDolar = String.valueOf(calcularImpuestoPaquete(p,true));
                String descuentoColon =  String.valueOf(Math.round(descuentoClientePaquete(cedula)*calcularImpuestoPaquete(p,false)));
                String descuentoDolar = String.valueOf(descuentoClientePaquete(cedula)*calcularImpuestoPaquete(p,true));
                p.setImpuestoColon(impuestoColon);
                p.setDescuentoColon(descuentoColon);
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
                temp.setCantidadPendientes(-1);
                cont++;
                
            }
            if(tipoObjeto.equals("class logica.Revista")){
                Revista r = (Revista)arr.get(cont);             //Hice un casteo
                resul+=r.getDescripcion()+"\n";
                String impuestoColon = String.valueOf(calcularImpuestoRevista(r,false));
                String impuestoDolar = String.valueOf(calcularImpuestoRevista(r,true));
                String descuentoColon =  String.valueOf(Math.round(descuentoClientePaquete(cedula)*calcularImpuestoRevista(r,false)));
                String descuentoDolar = String.valueOf(descuentoClientePaquete(cedula)*calcularImpuestoRevista(r,true));
                r.setImpuestoColon(impuestoColon);
                r.setDescuentoColon(descuentoColon);
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
                temp.setCantidadPendientes(-1);
                cont++;
                
            }
            
        }
        resul+="*************************************************\n";
        resul+="\nTotal Final Colones:\t¢"+String.valueOf(totalCol)+"\nTotal Final Dolares:\t$"+String.valueOf(totalDol)+"\n";
        cantInformesDeRetiro++;
        informesDeRetiros+="\nInforme de retiro "+String.valueOf(cantInformesDeRetiro)+"\n"+resul;
        return resul;
        
    }
    
    /**
     *
     * @param cedula
     * @return
     */
    public String listaEntregablesPendientes(String cedula){
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
        while(cas.getListaSobres()[cont]!= null){
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
        while(cas.getListaRevistas()[cont]!= null){
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
     *
     * @param num
     * @return
     */
    public String estadoCasillero(String num){       //Puede consultarse por cedula o numCasillero
        int cont = 0;
        String resul="";
        if (num.length()==4){          //Osea es un numero de casillero
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
            resul+=cas.getInformeEstado();
        }
        else{
            int i=0;
            while(listaCasilleros[i]!= null){
                String ced = listaCasilleros[i].getCliente().getIdentificador();
                if (ced.equals(num)){
                    
                    break;

                }
                else
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
     *
     * @param fecha
     * @return
     */
    public String detalleRecibidosPorFecha(String fecha){
        String resul = "Articulos recibidos el "+fecha+"\n";
        if(fecha.length() != 10 ){
            return "Error, el formato de fecha debe ser dd.mm.yyyy";
        }
        else{
            int cont =0;
            while(listaCasilleros[cont]!= null){
                Casillero cas = listaCasilleros[cont];
                Counter count = new Counter();
                cas.resetListaEntregables();
                count.listaEntregablesPendientes(cas.getCliente().getIdentificador());
                int index = 0;
                ArrayList arr = cas.getListaEntregables();
                while(index<arr.size()){
                    String tipoObjeto =String.valueOf(arr.get(index).getClass());
                    if(tipoObjeto.equals("class logica.Sobre")){
                        Sobre s = (Sobre)arr.get(index);
                        if (s.getFechaRecibido().equals(fecha)){
                            resul+="-"+s.getDescripcion()+"\n";
                            index++;
                        }
                        else{
                            index++;
                        }
                    }
                    if(tipoObjeto.equals("class logica.Paquete")){
                        Paquete p = (Paquete)arr.get(index);
                        if (p.getFechaRecibido().equals(fecha)){
                            resul+="-"+p.getDescripcion()+"\n";
                            index++;
                        }
                        else{
                            index++;
                        }
                    }
                    if(tipoObjeto.equals("class logica.Revista")){
                        Revista r = (Revista)arr.get(index);
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
     *
     * @param fecha
     * @return
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
                //Counter count = new Counter();
                //count.listaEntregablesPendientes(cas.getCliente().getIdentificador());
                int index = 0;
                ArrayList arr = cas.getListaEntregables();
                while(index<arr.size()){
                    String tipoObjeto =String.valueOf(arr.get(index).getClass());
                    if(tipoObjeto.equals("class logica.Sobre")){
                        Sobre s = (Sobre)arr.get(index);
                        if (s.getFechaEntrega().equals(fecha)){
                            resul+="-"+s.getDescripcion()+"\n";
                            index++;
                        }
                        else{
                            index++;
                        }
                    }
                    if(tipoObjeto.equals("class logica.Paquete")){
                        Paquete p = (Paquete)arr.get(index);
                        if (p.getFechaEntrega().equals(fecha)){
                            resul+="-"+p.getDescripcion()+"\n";
                            index++;
                        }
                        else{
                            index++;
                        }
                    }
                    if(tipoObjeto.equals("class logica.Revista")){
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
     *
     * @return
     */
    public String  listaClientesConPendientes(){
        String resul="Clientes con articulos pendientes"+"\n\n";
        int cont = 0;
        while(listaCasilleros[cont]!=null){
            Casillero cas = listaCasilleros[cont];
            if (cas.getCantidadPendientes() != 0){
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
     *
     * @param fecha
     * @return
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
            ArrayList arr = cas.getListaEntregables();
            while(index<arr.size()){
                String tipoObjeto =String.valueOf(arr.get(index).getClass());
                    if(tipoObjeto.equals("class logica.Sobre")){
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
                            totalFinalDolares+=impTotalDol;
                            totalFinalColones+=impCol;
                            totalFinalDolares+=impDol;
                            index++;
                        }
                        else{
                            index++;
                        }
                    }
                    if(tipoObjeto.equals("class logica.Paquete")){
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
                            double impTotalDol = impDol-desDol;
                            totalFinalDolares+=impTotalDol;
                            totalFinalColones+=impCol;
                            totalFinalDolares+=impDol;
                            index++;
                        }
                        else{
                            index++;
                        }
                    }
                    if(tipoObjeto.equals("class logica.Revista")){
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
                            totalFinalDolares+=impTotalDol;
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
        resul+="\nImpuestos recaudados:\n-Colones:"+totalImpuestosColones+"\n-Dolares:"+totalImpuestosDolares;
        resul+="\n\nDescuentos Aplicados:\n-Colones:"+totalDescuentosColones+"\n-Dolares:"+totalDescuentosDolares;
        resul+="\n\nTotal Final:\n-Colones:"+totalFinalColones+"\n-Dolares:"+totalFinalDolares+"\n*****************************************\n";
        resul+="Nota: Los montos en dolares son la conversion del monto en colones y no una cantidad aparte";
        return resul;
    }
    
    /**
     *
     * @return
     */
    public String listarPendientesTotales(){
        int cont =0;
        String resul = "";
        while (listaCasilleros[cont]!=null){
            Casillero cas = listaCasilleros[cont];
            String cedula = cas.getCliente().getIdentificador();
            resul+="\n******************************************\n"+listaEntregablesPendientes(cedula);
            cont++;
            
        }
        return resul;
       
    }

    /**
     *  enviar el correo a los clientes que tienen articulos pendientes
     */
    public void enviarCorreoAPendientes(){
        int cont =0;
        while(listaCasilleros[cont]!=null){
            Casillero cas = listaCasilleros[cont];
            if(cas.getCantidadPendientes()!=0){
                String destino = cas.getCliente().getCorreo();
                String descripcion = cas.listarPendientes();
                Correo mail = new Correo();                       
                mail.sendMail(destino, descripcion);
                cont++;       
            }
            else{
                cont++;
                
            }
        }
    }
        
    /**
     *
     * @return el detalle de los retiros
     */
    public String detalleDeRetiros(){  
        return informesDeRetiros;
    }
    
    /**
     * obtiene el numero de un casillero
     * @param cedula
     * @return numero
     */
        
    public String numeroDeCasillero(String cedula){
        int i=0;
        while(listaCasilleros[i]!= null){
            String ced = listaCasilleros[i].getCliente().getIdentificador();
            if (ced.equals(cedula)){
                break;  
            }
            else
                i++;
        }
        Casillero cas = listaCasilleros[i];
        String numero = String.valueOf(cas.getNumero());
        return numero;
        
    }
    
    /**
     * valida el correo electronico de un cliente
     * @param mail
     * @return true o false
     */
    public boolean validarCorreo(String mail){
        boolean contains = false;
        char[] arrayInvalidos = new char[]{'(',')','<','>',',',';',':','[',']','%','&',' ','"','$','#','!','*','=','{','}','?','/'};
        int indexA =0;
        int indexCh=0;
        while(indexCh<mail.length()){
            char comp = mail.charAt(indexCh);
            while(indexA<arrayInvalidos.length){
                if (arrayInvalidos[indexA]==comp){
                    contains = true;
                    break;
                    
                }
                else
                    indexA++;
            }
            indexCh++;
            indexA = 0;
        }
        
        if (contains == false && contadorApariciones(mail,'@')==1){
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
            char c2 = str.charAt(ind);
            if (c == c2){
                apariciones++;
                ind++;
            }
            else
                ind++;
        }
        return apariciones;
    }    
        
        
     
                    
                    
}