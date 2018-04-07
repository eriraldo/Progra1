
package logica;


public class Counter {
    private String nombre ;
    private String identificacion ;
    private String direccion ;
    private int numCasilleros;
    
    
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
    }
    
    public void crearCounter(String nombre, String identificacion,String direccion,int numCasilleros){
        Counter nuevo = new Counter(nombre,identificacion,direccion,numCasilleros);
        System.out.println("Counter creado exitosamente!");
        
        
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
        while(cont<largo){
            if (listaCasilleros[cont]== null){
                listaCasilleros[cont] = cas;
                break;
                
            }
            else
                cont++;
                    
        }
        
           
    }
    public void modificarCliente(String cedula,String datoNuevo,int tipoDato){      
        Cliente temp = new Cliente();
        int i=0;
        while(listaCasilleros[i]!= null){
            String ced = listaCasilleros[i].getCliente().getIdentificador();
            if (ced == cedula){
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
        System.out.println("Modificado!");
        
    }
    
    public String consultarCliente(String cedula){
        Cliente temp = new Cliente();
        int i=0;
        while(listaCasilleros[i]!= null){
            String ced = listaCasilleros[i].getCliente().getIdentificador();
            if (ced == cedula){
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
        return info;

        
        
        
    }
    
    public void eliminarCliente(String cedula){
        Casillero[] listaAux = new Casillero[listaCasilleros.length];
        int i=0;
        while(listaCasilleros[i]!= null){
            String ced = listaCasilleros[i].getCliente().getIdentificador();
            if (ced == cedula){
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
        
        
        System.out.println("Eliminado!");
         
        
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
    
    public void registrarPaquete(String cedula,Paquete paquete){
        Casillero temp = new Casillero();
        int i=0;
        while(listaCasilleros[i]!= null){
            String ced = listaCasilleros[i].getCliente().getIdentificador();
            if (ced == cedula){
                temp = listaCasilleros[i];
                break;
                
            }
            else
                i++;
        }
        
        temp.setListaPaquetes(paquete);
        listaCasilleros[i] = temp;
        String destino = temp.getCliente().getCorreo();
        String descripcion = temp.listarEntregables();
        Correo mail = new Correo();
        mail.sendMail(destino, descripcion);
        System.out.println("Paquete agregado al casillero!");
        
    }
    public void registrarSobre(String cedula,Sobre sobre){
        Casillero temp = new Casillero();
        int i=0;
        while(listaCasilleros[i]!= null){
            String ced = listaCasilleros[i].getCliente().getIdentificador();
            if (ced == cedula){
                temp = listaCasilleros[i];
                break;
                
            }
            else
                i++;
        }
        
        temp.setListaSobres(sobre);
        listaCasilleros[i] = temp;
        String destino = temp.getCliente().getCorreo();
        String descripcion = temp.listarEntregables();
        Correo mail = new Correo();
        mail.sendMail(destino, descripcion);
        System.out.println("Sobre agregado al casillero!");
        
        
    }
    public void registrarRevista(String cedula,Revista revista){
        Casillero temp = new Casillero();
        int i=0;
        while(listaCasilleros[i]!= null){
            String ced = listaCasilleros[i].getCliente().getIdentificador();
            if (ced == cedula){
                temp = listaCasilleros[i];
                break;
                
            }
            else
                i++;
        }
        
        temp.setListaRevistas(revista);
        listaCasilleros[i] = temp;
        String destino = temp.getCliente().getCorreo();
        String descripcion = temp.listarEntregables();
        Correo mail = new Correo();
        mail.sendMail(destino, descripcion);
        System.out.println("Revista agregada al casillero!");
        
    }
    
    
    
    
            
          
}