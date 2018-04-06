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
        System.out.println("Cliente agregado!");
        
    }
    
}
