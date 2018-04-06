
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
    
    public Cliente[] getLista(){
        return listaClientes;
    }
    
    public void addCliente(String name,String id,String mail,String gender,String cellphone,String location,String nacimiento,String rango){
        int largo = listaClientes.length;
        //System.out.println(largo);
        Cliente nuevo = new Cliente(name,id,mail,gender,cellphone,location,nacimiento,rango);
        
        listaClientes[largo-1] = nuevo;
    }
    
}