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
    
    public Casillero[] demeLista(){
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
    
    public void registarSobre(String cedula,Sobre sobre){
        counter.registrarSobre(cedula, sobre);
    }
    public void registrarRevista(String cedula,Revista revista){
        counter.registrarRevista(cedula, revista);
    }
    public void registrarPaquete(String cedula,Paquete paquete){
        counter.registrarPaquete(cedula, paquete);
    }
    public double calcularImpuestoSobre(Sobre sobre,boolean moneda){
        return counter.calcularImpuestoSobre(sobre, moneda);
    }
    public double calcularImpuestoRevista(Revista rev,boolean moneda){
        return counter.calcularImpuestoRevista(rev, moneda);
    }
    public double calcularImpuestoPaquete(Paquete paquete,boolean moneda){
        return counter.calcularImpuestoPaquete(paquete, moneda);
    }
    
    public double calcularDescuentoCliente(String cedula){
        return counter.descuentoClientePaquete(cedula);
    }
    
            
}
