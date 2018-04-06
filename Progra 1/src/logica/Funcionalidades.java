package logica;




public class Funcionalidades {
    Counter counter = new Counter();
    
    
    
    
    
    public Funcionalidades(){
        
    }
    
    public void crearCounter(String nombre,String identificacion,String direccion,int numCasilleros){
        
        counter.crearCounter(nombre,identificacion, direccion, numCasilleros);
        
        
        
    }
    public void agregarCliente(String name,String id,String mail,String gender,String cellphone,String location,String nacimiento,String rango){
        
        counter.addCliente(name, id, mail, gender, cellphone, location, nacimiento, rango);
        //System.out.println("Cliente agregado!");
        
    }
    public void modificarCliente(String cedula,String dato,int tipo){
        counter.modificarCliente(cedula, dato, tipo);
    }
    
    public Cliente[] demeLista(){
        return counter.getLista();
    }
    
    public String consultarCliente(String cedula){
        String temp = counter.consultarCliente(cedula);
              return temp  ;
        
    }
    public void eliminarCliente(String cedula){
        counter.eliminarCliente(cedula);
    }
    
    public void listarClientes(){
        counter.listarClientes();
    }
            
}
