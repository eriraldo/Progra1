
package logica;

import indicadoresEconomicosBCCR.TipoCambio;

import java.util.ArrayList;

import java.lang.Math;


public class Counter {
    
    private String nombre ;
    private String identificacion ;
    private String direccion ;
    private int numCasilleros;
    private int rangoAscenso;        //Paquetes que debe recibir cliente para ascender de rango
    
    
    public static Casillero[] listaCasilleros;
    
    public static int casilleroAsignado = 1000;


    public Counter(){
    }

    public Counter(String nombre, String identificacion, String direccion, int numCasilleros) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.numCasilleros = numCasilleros;
        listaCasilleros= new Casillero[numCasilleros];
        rangoAscenso = 10;
    }
    
    public boolean crearCounter(String nombre, String identificacion,String direccion,int numCasilleros){
        Counter nuevo = new Counter(nombre,identificacion,direccion,numCasilleros);
        
        return true;
        
        
    }
    
    public int getNumCasilleros(){
        return numCasilleros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
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
    
    public Casillero[] getLista(){
        return listaCasilleros;
    }
    
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
        System.out.println(info);
        return info;

        
        
        
    }
    
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
    
    public void listarClientes(){
        Counter c = new Counter();
        int size = c.getSize();
        int i = 0;
        
        
        while(i<size){
            Cliente cliente = listaCasilleros[i].getCliente();
            String cedula = cliente.getIdentificador();
            c.consultarCliente(cedula);
            i++;
            
        }
                
    }
    
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
        if(temp.getCantidadPaquetes()% rangoAscenso == 0 ){     //Cuando los paquetes recibidos es multiplo del rango de ascenso, se sube de nivel
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
        String destino = temp.getCliente().getCorreo();
        String descripcion = temp.listarEntregables();
        //Correo mail = new Correo();                           //Deshabilite el envio de correos para que no envie en cada corrida
        //mail.sendMail(destino, descripcion);
        return true;
        
    }
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
        String destino = temp.getCliente().getCorreo();
        String descripcion = temp.listarEntregables();
        //Correo mail = new Correo();                               //Deshabilite el envio de correos para que no envie en cada corrida
        //mail.sendMail(destino, descripcion);
        return true;
        
        
    }
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
        String destino = temp.getCliente().getCorreo();
        String descripcion = temp.listarEntregables();
        //Correo mail = new Correo();                       //Deshabilite el envio de correos para que no envie en cada corrida
        //mail.sendMail(destino, descripcion);
        //System.out.println("Revista agregada al casillero!");
        return true;
    }
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
    public double calcularImpuestoPaquete(Paquete paquete,boolean moneda){
        TipoCambio t = new TipoCambio();
        double tipoCambio = t.getCompra();       //aqui se cambia cuando funcione la clase impuesto
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
    
    public void modificarAscensoDeRango(int valor){     //Por default, se asciende cada 10 paquetes
        rangoAscenso = valor;
       
    }
    
    
    public String retirarPaquetes(ArrayList arr,String cedula){
        int largo = arr.size();
        String resul = "Paquete\t\t\t\tImpuesto Colones\tDescuento Colones\tImpuesto Dolares\tDescuento Dolares\n" ;
        resul+="---------------------------------------------------------------------------------------------------------------------\n";
        int cont =0;
        double totalCol = 0;
        double totalDol = 0;
        while (cont<largo){
            String tipoObjeto =String.valueOf(arr.get(cont).getClass());
            if(tipoObjeto.equals("class logica.Sobre")){
                Sobre s = (Sobre)arr.get(cont);             //Hice un casteo, no se que putas es pero sirve jajaj
                resul+=s.getDescripcion()+"\t\t\t";
                String impuestoColon = String.valueOf(calcularImpuestoSobre(s,false));
                String impuestoDolar = String.valueOf(calcularImpuestoSobre(s,true));
                String descuentoColon =  String.valueOf(Math.round(descuentoClientePaquete(cedula)*calcularImpuestoSobre(s,false)));
                String descuentoDolar = String.valueOf(descuentoClientePaquete(cedula)*calcularImpuestoSobre(s,true));
                resul+=impuestoColon+"\t\t\t"+descuentoColon+"\t\t\t"+impuestoDolar+"\t\t\t"+descuentoDolar+"\n"; 
                totalCol+=(Double.parseDouble(impuestoColon)-Double.parseDouble(descuentoColon));
                totalDol+=(Double.parseDouble(impuestoDolar)-Double.parseDouble(descuentoDolar));
                cont++;
                
            }
            if(tipoObjeto.equals("class logica.Paquete")){
                Paquete p = (Paquete)arr.get(cont);             //Hice un casteo, no se que putas es pero sirve jajaj
                resul+=p.getDescripcion()+"\t\t\t";
                String impuestoColon = String.valueOf(calcularImpuestoPaquete(p,false));
                String impuestoDolar = String.valueOf(calcularImpuestoPaquete(p,true));
                String descuentoColon =  String.valueOf(Math.round(descuentoClientePaquete(cedula)*calcularImpuestoPaquete(p,false)));
                String descuentoDolar = String.valueOf(descuentoClientePaquete(cedula)*calcularImpuestoPaquete(p,true));
                resul+=impuestoColon+"\t\t\t"+descuentoColon+"\t\t\t"+impuestoDolar+"\t\t\t"+descuentoDolar+"\n";
                totalCol+=(Double.parseDouble(impuestoColon)-Double.parseDouble(descuentoColon));
                totalDol+=(Double.parseDouble(impuestoDolar)-Double.parseDouble(descuentoDolar));
                cont++;
                
            }
            if(tipoObjeto.equals("class logica.Revista")){
                Revista r = (Revista)arr.get(cont);             //Hice un casteo, no se que putas es pero sirve jajaj
                resul+=r.getDescripcion()+"\t\t\t";
                String impuestoColon = String.valueOf(calcularImpuestoRevista(r,false));
                String impuestoDolar = String.valueOf(calcularImpuestoRevista(r,true));
                String descuentoColon =  String.valueOf(Math.round(descuentoClientePaquete(cedula)*calcularImpuestoRevista(r,false)));
                String descuentoDolar = String.valueOf(descuentoClientePaquete(cedula)*calcularImpuestoRevista(r,true));
                resul+=impuestoColon+"\t\t\t"+descuentoColon+"\t\t\t"+impuestoDolar+"\t\t\t"+descuentoDolar+"\n";
                totalCol+=(Double.parseDouble(impuestoColon)-Double.parseDouble(descuentoColon));
                totalDol+=(Double.parseDouble(impuestoDolar)-Double.parseDouble(descuentoDolar));
                cont++;
                
            }
            
        }
        resul+="---------------------------------------------------------------------------------------------------------------------\n";
        resul+="Total Colones:\t"+String.valueOf(totalCol)+"\nTotal Dolares:\t"+String.valueOf(totalDol);
        return resul;
        
    }
    
                    
                    
}