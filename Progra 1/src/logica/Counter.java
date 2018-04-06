
package logica;


public class Counter {
    private String nombre ;
    private String identificacion ;
    private String direccion ;
    private int numCasilleros;
    
    
    public static Cliente[] listaClientes;


    public Counter(){
    }

    public Counter(String nombre, String identificacion, String direccion, int numCasilleros) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.numCasilleros = numCasilleros;
        listaClientes = new Cliente[numCasilleros];
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
        while(i<listaClientes.length){
            if (listaClientes[i]!= null){
            acu++;
            i++;
            }
            else
                i++;
                    
        }
        return acu;
    }
    
    public Cliente[] getLista(){
        return listaClientes;
    }
    
    public void addCliente(String name,String id,String mail,String gender,String cellphone,String location,String nacimiento,String rango){
        int largo = listaClientes.length;
        Cliente nuevo = new Cliente(name,id,mail,gender,cellphone,location,nacimiento,rango);
        int cont =0;
        while(cont<largo){
            if (listaClientes[cont]== null){
                listaClientes[cont] = nuevo;
                break;
                
            }
            else
                cont++;
                    
        }
        
                
    }
    public void modificarCliente(String cedula,String datoNuevo,int tipoDato){      
        Cliente temp = new Cliente();
        int i=0;
        while(listaClientes[i]!= null){
            String ced = listaClientes[i].getIdentificador();
            if (ced == cedula){
                temp = listaClientes[i];
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
        listaClientes[i]= temp;
        System.out.println("Modificado!");
        
    }
    
    public void consultarCliente(String cedula){
        Cliente temp = new Cliente();
        int i=0;
        while(listaClientes[i] != null){
            String ced = listaClientes[i].getIdentificador();
            if (ced == cedula){
                temp = listaClientes[i];
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
        
        System.out.println("   **Datos del Cliente**   ");
        System.out.println("Nombre: " + name);
        System.out.println("Identificacion: " + id);
        System.out.println("Genero: " + genero);
        System.out.println("Fecha de Nacimiento: " + nacimiento);
        System.out.println("Telefono: " + telefono);
        System.out.println("Correo: " + correo);
        System.out.println("Lugar de residencia: " + residencia);
        System.out.println("Rango de Cliente: " + tipoCliente);
        System.out.println("***********************************");
        
        
        
    }
    
    public void eliminarCliente(String cedula){
        Cliente[] listaAux = new Cliente[listaClientes.length];
        int i=0;
        while(listaClientes[i] != null){
            String ced = listaClientes[i].getIdentificador();
            if (ced == cedula)
                break;
            else
                i++;
        }
        int contador = 0;
        while (contador < i){
            listaAux[contador]= listaClientes[contador];
            contador++;
        }
        contador+=1;
        while (contador < listaClientes.length){
            listaAux[contador-1]= listaClientes[contador];
            contador++;
        }
        listaClientes = listaAux;
        
        System.out.println("Eliminado!");
         
        
    }
    
    public void listarClientes(){
        Counter c = new Counter();
        int size = c.getSize();
        int i = 0;
        
        while(i<size){
            Cliente cliente = listaClientes[i];
            String cedula = cliente.getIdentificador();
            c.consultarCliente(cedula);
            i++;
            
        }
                
    }
    
            
          
}